package com.winterfell.annie.model.identity;

import java.util.Date;

import com.winterfell.annie.model.AbstractModel;

public class MobileIdentity extends AbstractModel{
	/**姓名*/
	private String name;
	/**身份证号码*/
	private String idcard;
	/**手机号码*/
	private String mobile;
	/**数据入库时间*/
	private Date entryDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
}
