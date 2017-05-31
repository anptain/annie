package com.airball.annie.web.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.NullRememberMeServices;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.airball.annie.constants.AppConstant;
@Component
public class RecaptchaAuthenticationFilter extends GenericFilterBean {
	private RememberMeServices rememberMeServices = new NullRememberMeServices();
	
	private RequestMatcher requiresAuthenticationRequestMatcher = new AntPathRequestMatcher("/login", "POST");
	
	private AuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();

	private final static String FORM_CAPTCHA_KEY = "captcha";
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		if (requiresAuthentication(request, response)) {
			String sessionCaptcha = (String) request.getSession().getAttribute(AppConstant.KAPTCHA_SESSION_KEY);
			String captcha = request.getParameter(FORM_CAPTCHA_KEY);
			if (!StringUtils.equals(sessionCaptcha, captcha)) {
				unsuccessfulAuthentication(request, response, new BadCaptchaException("验证码认证失败"));
			}
		}
		chain.doFilter(request, response);
		
	}
	
	protected void unsuccessfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException failed)
			throws IOException, ServletException {
		SecurityContextHolder.clearContext();

		if (logger.isDebugEnabled()) {
			logger.debug("Authentication request failed: " + failed.toString(), failed);
			logger.debug("Updated SecurityContextHolder to contain null Authentication");
			logger.debug("Delegating to authentication failure handler " + failureHandler);
		}

		rememberMeServices.loginFail(request, response);

		failureHandler.onAuthenticationFailure(request, response, failed);
	}
	
	protected boolean requiresAuthentication(HttpServletRequest request,
			HttpServletResponse response) {
		return requiresAuthenticationRequestMatcher.matches(request);
	}
}