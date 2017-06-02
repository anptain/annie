package com.airball.annie.domain.content;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.airball.annie.domain.AbstractDomain;

@Entity
@Table(name = "t_nba_schedule")
public class NbaSchedule extends AbstractDomain{
	private Long homeNbaTeamId;
	private Long awayNbaTeamId;
	private Date eventDate;
	
	public Long getHomeNbaTeamId() {
		return homeNbaTeamId;
	}
	public void setHomeNbaTeamId(Long homeNbaTeamId) {
		this.homeNbaTeamId = homeNbaTeamId;
	}
	public Long getAwayNbaTeamId() {
		return awayNbaTeamId;
	}
	public void setAwayNbaTeamId(Long awayNbaTeamId) {
		this.awayNbaTeamId = awayNbaTeamId;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
}
