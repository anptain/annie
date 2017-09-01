package com.xairball.annie.model.sys;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.xairball.annie.model.AbstractModel;

@Entity
@Table(name = "t_document")
public class Document extends AbstractModel {
	private String name;
	private Long length;
	private String type;
	private byte[] content;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

}
