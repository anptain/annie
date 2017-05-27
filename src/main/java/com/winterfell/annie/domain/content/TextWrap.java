package com.winterfell.annie.domain.content;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.winterfell.annie.domain.AbstractDomain;

@Entity
@Table(name = "t_text_wrap")
public class TextWrap extends AbstractDomain{
	private String body;
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
