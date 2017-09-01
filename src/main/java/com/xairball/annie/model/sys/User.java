package com.xairball.annie.model.sys;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.xairball.annie.model.AbstractModel;
@Entity
@Table(name = "t_user") 
public class User extends AbstractModel {
	/** 用户名*/
	private String username;
	/** 密码 */
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
