package com.airball.annie.domain.content;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.airball.annie.domain.AbstractDomain;

@Entity
@Table(name = "t_nba_team")
public class NbaTeam extends AbstractDomain{
	private String name;
	
}
