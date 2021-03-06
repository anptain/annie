package com.xairball.annie.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.xairball.annie.auth.AuthFailureHandler;
import com.xairball.annie.auth.AuthSuccessHandler;
import com.xairball.annie.auth.RecaptchaAuthenticationFilter;
import com.xairball.annie.service.WebUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private WebUserDetailService webUserDetailService;
	@Autowired
	private RecaptchaAuthenticationFilter recaptchaAuthenticationFilter;
	@Autowired
	private AuthFailureHandler authFailureHandler;
	@Autowired
	private AuthSuccessHandler authSuccessHandler;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/static/**"); // #3O
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/home","/api/**").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").failureHandler(authFailureHandler).successHandler(authSuccessHandler).permitAll()
				.and().logout().permitAll();
		// 禁用 csrf
		http.csrf().disable();
		// session管理
		http.sessionManagement().sessionFixation().changeSessionId().maximumSessions(1).expiredUrl("/");
		// 添加验证码
		// http.addFilterBefore(, UsernamePasswordAuthenticationFilter.class);
		http.addFilterBefore(recaptchaAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(webUserDetailService);
	}

}
