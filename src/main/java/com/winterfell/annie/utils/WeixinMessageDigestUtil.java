package com.winterfell.annie.utils;

import java.security.MessageDigest;
import java.util.Arrays;

public final class WeixinMessageDigestUtil {
	private static final WeixinMessageDigestUtil _instance = new WeixinMessageDigestUtil();

	private MessageDigest alga;

	private WeixinMessageDigestUtil() {
		try {
			alga = MessageDigest.getInstance("SHA-1");
		} catch (Exception e) {
			throw new InternalError("init MessageDigest error:" + e.getMessage());
		}
	}

	public static WeixinMessageDigestUtil getInstance() {
		return _instance;
	}

	public static String byte2hex(byte[] b) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < b.length; i++) {
			tmp = (Integer.toHexString(b[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}

	public String encipher(String strSrc) {
		String strDes = null;
		byte[] bt = strSrc.getBytes();
		alga.update(bt);
		strDes = byte2hex(alga.digest()); // to HexString
		return strDes;
	}

	public boolean validate(String signature, String timestamp, String nonce) {
		String token = "token";
		String[] ArrTmp = { token, timestamp, nonce };
		Arrays.sort(ArrTmp);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ArrTmp.length; i++) {
			sb.append(ArrTmp[i]);
		}
		return signature.equals(WeixinMessageDigestUtil.getInstance().encipher(sb.toString()));
	}
}