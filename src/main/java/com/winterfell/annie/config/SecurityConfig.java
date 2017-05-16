package com.winterfell.annie.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.winterfell.annie.service.WebUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private WebUserDetailService webUserDetailService;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/static/**"); // #3O
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 设置拦截规则
		http.authorizeRequests().antMatchers("/", "/home","/video").permitAll().anyRequest().authenticated();
		// 自定义登录
		http.formLogin().loginPage("/login").permitAll().failureHandler(new ExceptionMappingAuthenticationFailureHandler());
		// 自定义注销
		http.logout().logoutUrl("/logout").logoutSuccessUrl("/");
		// 禁用 csrf
		http.csrf().disable();
		// session管理
		http.sessionManagement().sessionFixation().changeSessionId().maximumSessions(1).expiredUrl("/");
		// 添加验证码
		// http.addFilterBefore(, UsernamePasswordAuthenticationFilter.class);
		http.addFilterBefore(new RecaptchaAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(webUserDetailService);
	}
	
}
