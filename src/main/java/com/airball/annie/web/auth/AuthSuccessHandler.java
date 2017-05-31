package com.airball.annie.web.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.airball.annie.web.controller.JsonResult;
@Component
public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	@Autowired
	private ObjectMapper objectMapper;
	
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		response.setStatus(HttpServletResponse.SC_OK);
		JsonResult json = new JsonResult();
		response.getWriter().print(objectMapper.writeValueAsString(json));
		response.getWriter().flush();
	}
}
