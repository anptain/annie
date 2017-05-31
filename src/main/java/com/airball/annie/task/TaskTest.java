package com.airball.annie.task;

import org.springframework.stereotype.Component;

@Component
public class TaskTest {
	/**
	 * 心跳更新。启动时执行一次，之后每隔2秒执行一次
	 */
	// @Scheduled(fixedRate = 1000 * 2)
	public void print() {
		System.out.println("Annotation：print run");
	}
}
