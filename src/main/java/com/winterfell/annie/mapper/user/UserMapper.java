package com.winterfell.annie.mapper.user;


import com.winterfell.annie.domain.UserVo;
import com.winterfell.annie.domain.user.User;

import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User>{
	User selectOne(Long id);
	UserVo selectByUsername(String username);
}
