package com.airball.annie.mapper.content;


import java.util.List;

import com.airball.annie.domain.content.Section;
import com.airball.annie.vo.SectionVo;

import tk.mybatis.mapper.common.Mapper;

public interface SectionMapper extends Mapper<Section>{
	List<SectionVo> selectSectionVo();
}
