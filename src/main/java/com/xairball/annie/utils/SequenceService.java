package com.xairball.annie.utils;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class SequenceService {

	private static final Log logger = LogFactory.getLog(SequenceService.class);
	
	private static final String DT_FORMAT="yyMMdd";

	public static final Sequence SEQ_TIGER_RECORD = new Sequence("SEQ_GLOBAL");

	/**
	 * Sequence整体占位15位，组成：prefix(1) + date(6) + seed(4, 13(二进制)) + increment(4,
	 * 13(二进制))
	 */
	public static class Sequence {

		/**
		 */
		private final int MAX_INCREMENT = 999999;

		/**
		 * seed获取锁
		 */
		private final Lock lock = new ReentrantLock();

		/**
		 * 依赖的可持久化分布式序列名称
		 */
		private String sequenceName;

		/**
		 * Sequence持久化因子
		 */
		private volatile Integer seed = -1;

		/**
		 * 增长因子
		 */
		private AtomicInteger increment = new AtomicInteger(0);

		public Sequence(String sequenceName) {
			this.sequenceName = sequenceName;
		}

		public long getNextValue() throws SequenceException {

			int incr = increment.getAndIncrement();

			int seed = this.seed;

			if (seed == -1) {// 如果seed值未初始化，则先初始化seed
				lock.lock();
				try {
					if ((seed = this.seed) == -1)
						seed = getSeedAndCache();
				} finally {
					lock.unlock();
				}
			}

			if (incr > MAX_INCREMENT) {// 如果自增变量超过最大允许值，则重新获取seed，并循环increment.
				lock.lock();
				try {
					incr = increment.getAndIncrement();
					// 超过了9999（MAX_INCREMENT）后，要么自己把seed修改掉，要么用别的线程修改过的seed
					if (incr > MAX_INCREMENT) {// double check.
						// generate seed first to avoid old seed being used with
						// new cycle increment to generate conflict sequence.
						seed = getSeedAndCache();
						increment.set(1);// cycle the increment.
						incr = 0;
					} else {
						seed = this.seed;
					}
				} finally {
					lock.unlock();
				}
			}

			final String sequence = new StringBuilder(DateTimeUtil.formatTimestamp2String(new Date(),DT_FORMAT)).append(lpad(seed, 4))
					.append(lpad(incr, 6)).toString();

			if (logger.isDebugEnabled())
				logger.debug("generate sequence for " + sequenceName + ": " + sequence);

			return Long.parseLong(sequence);
		}

		private String lpad(int num, int radix) {
			if (num < 0)
				throw new IllegalArgumentException("illegal positive number:" + num);

			if (num >= Math.pow(10, radix))
				throw new IllegalArgumentException("number overflow: " + num + ", radix: " + radix);

			if (num == 0)
				return lpad0(num, radix - 1);

			for (int i = 0; i < radix; i++) {
				if (num < Math.pow(10, i)) {
					return lpad0(num, radix - i);
				}
			}

			return String.valueOf(num);
		}

		private String lpad0(int num, int pad) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < pad; i++) {
				sb.append("0");
			}
			return sb.append(num).toString();
		}

		/**
		 * 获取seed因子
		 * 
		 * @return
		 * @throws SequenceException
		 */
		private int getSeedAndCache() throws SequenceException {
			RedisPool.incrBy(sequenceName, 1);
			int seed = Long.valueOf(RedisPool.get(sequenceName)).intValue();
			seed -= ((seed / 10000) * 10000);// 仅取后4位数字
			if (logger.isInfoEnabled())
				logger.info("get seed from redis for " + sequenceName + " : " + seed);

			this.seed = seed;
			return seed;
		}
	}

	public static class SequenceException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SequenceException() {

		}

		public SequenceException(String msg) {
			super(msg);
		}

		public SequenceException(String msg, Throwable e) {
			super(msg, e);
		}
	}

}
