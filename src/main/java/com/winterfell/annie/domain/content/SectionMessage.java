package com.winterfell.annie.domain.content;

import com.winterfell.annie.domain.AbstractDomain;

public class SectionMessage extends AbstractDomain{
	private Long sectionId;
	private Long userId;
	private String body;
	private String msgdate;
	
	public Long getSectionId() {
		return sectionId;
	}
	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getMsgdate() {
		return msgdate;
	}
	public void setMsgdate(String msgdate) {
		this.msgdate = msgdate;
	}
}
