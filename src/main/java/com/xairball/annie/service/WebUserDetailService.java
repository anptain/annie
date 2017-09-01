package com.xairball.annie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xairball.annie.dao.sys.UserDao;
import com.xairball.annie.model.UserVo;

@Service
public class WebUserDetailService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVo user = userDao.selectByUsername(username);
		if (user == null) {
			user = new UserVo();
		}
		return user;
	}
}
