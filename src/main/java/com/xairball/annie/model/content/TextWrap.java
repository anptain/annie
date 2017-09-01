package com.xairball.annie.model.content;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.xairball.annie.model.AbstractModel;

@Entity
@Table(name = "t_text_wrap")
public class TextWrap extends AbstractModel{
	private String body;
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
