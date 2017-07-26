package com.airball.annie.domain.content;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.airball.annie.domain.AbstractDomain;

@Entity
@Table(name = "t_article")
public class Article extends AbstractDomain{
	/**用户ID*/
	private Long userId;
	/**内容*/
	private Long textWrapId;
	/**发布时间*/
	private Date pubdate;
	/**点赞人数*/
	private Integer likeCount;
	/**留言人数*/
	private Integer messageCount;
	
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
	public Integer getMessageCount() {
		return messageCount;
	}
	public void setMessageCount(Integer messageCount) {
		this.messageCount = messageCount;
	}
	public Long getTextWrapId() {
		return textWrapId;
	}
	public void setTextWrapId(Long textWrapId) {
		this.textWrapId = textWrapId;
	}
}
