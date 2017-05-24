package com.winterfell.annie.model.user;

import java.math.BigDecimal;

import com.winterfell.annie.model.AbstractModel;

public class UserAccount extends AbstractModel{
	/**用户ID*/
	private Long userId;
	/**账户金额*/
	private BigDecimal amount;
}
