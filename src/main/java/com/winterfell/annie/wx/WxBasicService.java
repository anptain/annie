package com.winterfell.annie.wx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WxBasicService {
	@Autowired
	private WxBasicHelper helper;
	
	public void getSessionByCode(String code){
		helper.requestSnsJscode2session(code);
	}
}
