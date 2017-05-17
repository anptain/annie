package com.winterfell.annie.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.winterfell.annie.model.User;
import com.winterfell.annie.model.UserVo;

@Mapper
public interface UserMapper {
	User selectOne(Long id);
	UserVo selectByUsername(String username);
}
