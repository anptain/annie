package com.airball.annie.mapper.user;


import com.airball.annie.domain.UserVo;
import com.airball.annie.domain.user.User;

import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User>{
	User selectOne(Long id);
	UserVo selectByUsername(String username);
}
