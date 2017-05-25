package com.winterfell.annie.model.user;

import com.winterfell.annie.model.AbstractModel;
/**
 * 微信OpenId登录用户
 * 
 * @author xujing
 */
public class WxOpenId extends AbstractModel{
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
