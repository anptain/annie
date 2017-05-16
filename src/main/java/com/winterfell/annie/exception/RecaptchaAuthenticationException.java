package com.winterfell.annie.exception;

import org.springframework.security.core.AuthenticationException;

public class RecaptchaAuthenticationException extends AuthenticationException{

	public RecaptchaAuthenticationException(String msg) {
		super(msg);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2106002950873843990L;

}
