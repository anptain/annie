package com.airball.annie.domain.user;

import com.airball.annie.domain.AbstractDomain;
/**
 * 微信OpenId登录用户
 * 
 * @author xujing
 */
public class WxOpenId extends AbstractDomain{
	/**关联User*/
	private Long userId;
	/**openId*/
	private String openId;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
}
