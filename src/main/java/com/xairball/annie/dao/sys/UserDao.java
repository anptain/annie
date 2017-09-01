package com.xairball.annie.dao.sys;

import com.xairball.annie.model.UserVo;
import com.xairball.annie.model.sys.User;

import tk.mybatis.mapper.common.Mapper;

public interface UserDao extends Mapper<User> {
	User selectOne(Long id);

	UserVo selectByUsername(String username);
}
