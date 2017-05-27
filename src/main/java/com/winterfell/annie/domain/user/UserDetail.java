package com.winterfell.annie.domain.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.winterfell.annie.domain.AbstractDomain;
@Entity
@Table(name = "t_user_detail") 
public class UserDetail extends AbstractDomain{
	/** 用户ID */
	private Long userId;
	/** 昵称 */
	private String nickname;
	/**电话*/
	private String phone;
	/**性别*/
	private String gender;
	/**年龄*/
	private Integer age;
	/**真实姓名*/
	private String realname;
	/**生日*/
	private Date birthday;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	
}
