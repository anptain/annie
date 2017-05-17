package com.winterfell.annie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.winterfell.annie.mapper.UserMapper;
import com.winterfell.annie.model.UserVo;
@Service
public class WebUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVo user =  userMapper.selectByUsername(username);
		if(user == null){
			user = new UserVo();
		}
		return user;
	}
}
