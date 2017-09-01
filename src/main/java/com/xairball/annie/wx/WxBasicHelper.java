package com.xairball.annie.wx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xairball.annie.utils.HttpClientUtil;
import com.xairball.annie.wx.vo.WxSessionVo;
@Component
@EnableConfigurationProperties(WxProperties.class)
public class WxBasicHelper {
	private static final Logger LOG = LoggerFactory.getLogger(WxBasicHelper.class);
	
	@Autowired
	private WxProperties wxProperties;
	@Autowired
	private ObjectMapper objectMapper; 
	
	public WxSessionVo requestSnsJscode2session(String code){
		List<BasicNameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("appid", wxProperties.getAppid()));
		params.add(new BasicNameValuePair("secret", wxProperties.getSecret()));
		params.add(new BasicNameValuePair("js_code", code));
		params.add(new BasicNameValuePair("grant_type", "authorization_code"));
		String resp = HttpClientUtil.get(wxProperties.getJscode2sessionUrl(), params);
		LOG.debug("获取 session_key 和 openid - {}",resp);
		try {
			return objectMapper.readValue(resp, WxSessionVo.class);
		} catch (IOException e) {
			LOG.error("转换 WxSessionVo 异常",e);
			return null;
		}
	}
}
