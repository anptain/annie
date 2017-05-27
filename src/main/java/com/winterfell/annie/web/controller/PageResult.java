package com.winterfell.annie.web.controller;

import java.util.List;

import com.github.pagehelper.PageInfo;

public class PageResult extends JsonResult{
	private boolean isLastPage;
	@Override
	public void setContent(Object content) {
		@SuppressWarnings("unchecked")
		PageInfo<Object> page = new PageInfo<>((List<Object>)content);
		isLastPage = page.isIsLastPage();
		super.setContent(content);
	}
	
	public boolean isLastPage() {
		return isLastPage;
	}
	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}
}
