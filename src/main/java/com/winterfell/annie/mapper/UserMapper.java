package com.winterfell.annie.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.winterfell.annie.model.User;

@Mapper
public interface UserMapper {
	User findOne(Long id);
}
