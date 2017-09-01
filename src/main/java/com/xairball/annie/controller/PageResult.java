package com.xairball.annie.controller;

import java.util.List;

import com.github.pagehelper.PageInfo;

public class PageResult extends JsonResult{
	private boolean isLastPage;
	@Override
	public void setBody(Object content) {
		@SuppressWarnings("unchecked")
		PageInfo<Object> page = new PageInfo<>((List<Object>)content);
		isLastPage = page.isIsLastPage();
		super.setBody(content);
	}
	
	public boolean isLastPage() {
		return isLastPage;
	}
	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}
}
