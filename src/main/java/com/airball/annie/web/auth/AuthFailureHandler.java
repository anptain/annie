package com.airball.annie.web.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.airball.annie.web.controller.JsonResult;

@Component
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler{
	@Autowired
	private ObjectMapper objectMapper;
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		JsonResult json = new JsonResult();
		response.getWriter().print(objectMapper.writeValueAsString(json));
		response.getWriter().flush();
	}
}
