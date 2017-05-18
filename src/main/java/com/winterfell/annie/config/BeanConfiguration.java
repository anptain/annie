package com.winterfell.annie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class BeanConfiguration {
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}
