package com.winterfell.annie.model;

public class User extends AbstractModel {
	/** 用户名*/
	private String username;
	/** 密码 */
	private String pwd;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
