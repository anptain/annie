package com.airball.annie.web.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airball.annie.domain.sys.BankCardBin;
import com.airball.annie.mapper.content.SectionMapper;
import com.airball.annie.mapper.sys.BankCardBinMapper;
import com.airball.annie.mapper.user.UserMapper;
import com.airball.annie.service.user.UserService;
import com.airball.annie.web.auth.BadCaptchaException;

@Controller
public class HomeController {
	private final static Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private SectionMapper sectionMapper;
	@Autowired
	private BankCardBinMapper bankCardBinMapper;

	@RequestMapping(value = "/")
	public String index(String aa) {
		for (BankCardBin bankCardBin : bankCardBinMapper.selectAll()) {
			System.out.println(bankCardBin.getBankName());
		}
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(String error, Model model, HttpSession session) {
		Object expcetion = session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		if (error != null && expcetion != null) {
			if (expcetion instanceof BadCredentialsException) {
				model.addAttribute("loginMsg", "用户名或密码错误");
			}
			if (expcetion instanceof BadCaptchaException) {
				model.addAttribute("loginMsg", "验证码输入错误");
			}
		}
		return "login";
	}
}
