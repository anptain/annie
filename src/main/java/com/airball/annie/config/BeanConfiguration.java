package com.airball.annie.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import com.airball.annie.utils.CommonBeanFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
	
    @Bean
    public CommonBeanFactory commonBeanFactory(){
    	return new CommonBeanFactory();
    }
	
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
	  return new EmbeddedServletContainerCustomizer() {
	    @Override
	    public void customize(ConfigurableEmbeddedServletContainer container) {
	      container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
	      container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"));
	    }
	  };
	}
}
