package com.winterfell.annie.mapper.content;


import java.util.List;

import com.winterfell.annie.domain.content.Section;
import com.winterfell.annie.vo.SectionVo;

import tk.mybatis.mapper.common.Mapper;

public interface SectionMapper extends Mapper<Section>{
	List<SectionVo> selectSectionVo();
}
