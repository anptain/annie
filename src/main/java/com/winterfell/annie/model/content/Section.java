package com.winterfell.annie.model.content;

import java.util.Date;

import com.winterfell.annie.model.AbstractModel;

public class Section extends AbstractModel{
	/**用户ID*/
	private Long userId;
	/**内容*/
	private Long bodyWrapId;
	/**发布时间*/
	private Date pubdate;
	/**点赞人数*/
	private Integer likeCount;
	
	public Date getPubdate() {
		return pubdate;
	}
	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}
	public Long getBodyWrapId() {
		return bodyWrapId;
	}
	public void setBodyWrapId(Long bodyWrapId) {
		this.bodyWrapId = bodyWrapId;
	}
}
