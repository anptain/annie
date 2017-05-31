package com.airball.annie.domain.user;

import java.math.BigDecimal;

import com.airball.annie.domain.AbstractDomain;

public class UserAccount extends AbstractDomain{
	/**用户ID*/
	private Long userId;
	/**账户金额*/
	private BigDecimal amount;
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
