package com.winterfell.annie.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.filter.GenericFilterBean;

import com.winterfell.annie.constants.AppConstant;
import com.winterfell.annie.exception.RecaptchaAuthenticationException;

public class RecaptchaAuthenticationFilter extends GenericFilterBean {
	private RequestMatcher requiresAuthenticationRequestMatcher = new AntPathRequestMatcher("/login", "POST");
	private final static String FORM_CAPTCHA_KEY = "captcha";
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		if (requiresAuthentication(request, response)) {
			String sessionCaptcha = (String) request.getSession().getAttribute(AppConstant.KAPTCHA_SESSION_KEY);
			String captcha = request.getParameter(FORM_CAPTCHA_KEY);
			if (!StringUtils.equals(sessionCaptcha, captcha)) {
				throw new RecaptchaAuthenticationException("验证码认证失败");
			}
		}
		chain.doFilter(request, response);
	}

	protected boolean requiresAuthentication(HttpServletRequest request,
			HttpServletResponse response) {
		return requiresAuthenticationRequestMatcher.matches(request);
	}
}