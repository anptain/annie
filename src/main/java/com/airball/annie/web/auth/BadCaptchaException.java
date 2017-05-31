package com.airball.annie.web.auth;

import org.springframework.security.core.AuthenticationException;

public class BadCaptchaException extends AuthenticationException{

	public BadCaptchaException(String msg) {
		super(msg);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2106002950873843990L;

}
