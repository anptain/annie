package com.winterfell.annie.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.winterfell.annie.mapper.UserMapper;
import com.winterfell.annie.service.UserService;

@Controller
public class HomeController {
	private final static Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private UserMapper userMapper;
	

	@RequestMapping(value = "/")
	public String index(String aa) {
		userMapper.findOne(1l);
		return "index";
	}
	
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public String login(String aa) {
		userMapper.findOne(1l);
		return "login";
	}

}
