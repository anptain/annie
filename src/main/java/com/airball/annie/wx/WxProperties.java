package com.airball.annie.wx;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "wx.cxc")
public class WxProperties {
	/**微信小程序 ： 使用登录凭证 code 获取 session_key 和 openid*/
	private String jscode2sessionUrl = "https://api.weixin.qq.com/sns/jscode2session";
	private String appid;
	private String secret;
	
	public String getJscode2sessionUrl() {
		return jscode2sessionUrl;
	}

	public void setJscode2sessionUrl(String jscode2sessionUrl) {
		this.jscode2sessionUrl = jscode2sessionUrl;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
}
