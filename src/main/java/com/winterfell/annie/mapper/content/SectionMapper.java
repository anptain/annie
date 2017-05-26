package com.winterfell.annie.mapper.content;

import org.apache.ibatis.annotations.Mapper;

import com.winterfell.annie.domain.UserVo;
import com.winterfell.annie.domain.content.Section;

@Mapper
public interface SectionMapper {
	Section findOne(Long id);
}
