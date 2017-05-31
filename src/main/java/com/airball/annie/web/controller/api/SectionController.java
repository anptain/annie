package com.airball.annie.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.airball.annie.mapper.content.SectionMapper;
import com.airball.annie.web.controller.JsonResult;
import com.airball.annie.web.controller.PageResult;

@RestController
@RequestMapping("api/section")
public class SectionController {
	@Autowired
	private SectionMapper sectionMapper; 
	
	
	@RequestMapping("list")
	public JsonResult getSection(){
		PageHelper.startPage(1, 5);
		PageResult json = new PageResult();
		json.setContent(sectionMapper.selectSectionVo());
		return json;
	}
}