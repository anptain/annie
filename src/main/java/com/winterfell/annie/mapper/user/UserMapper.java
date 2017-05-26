package com.winterfell.annie.mapper.user;

import org.apache.ibatis.annotations.Mapper;

import com.winterfell.annie.domain.UserVo;
import com.winterfell.annie.domain.user.User;

@Mapper
public interface UserMapper {
	User findOne(Long id);
	UserVo selectByUsername(String username);
}
