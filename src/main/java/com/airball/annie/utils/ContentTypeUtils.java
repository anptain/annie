package com.airball.annie.utils;

import java.util.HashMap;
import java.util.Map;

public class ContentTypeUtils {
	private static Map<String, String> mapper = new HashMap<String, String>();
	static {
		mapper.put("image/jpeg", "jpg");
	}

	public static String convertToSuffix(String contentType) {
		String type = mapper.get(contentType);
		if (type != null) {
			return "." + type;
		} else {
			return "";
		}
	}
}
