package com.airball.annie.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airball.annie.mapper.content.ArticleMapper;
import com.airball.annie.web.controller.JsonResult;
import com.airball.annie.web.controller.PageResult;
import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("api/article")
public class ArticleController {
	@Autowired
	private ArticleMapper articleMapper; 
	
	
	@RequestMapping("")
	public JsonResult getArticle(){
		PageHelper.startPage(1, 5);
		PageResult json = new PageResult();
		json.setBody(articleMapper.selectArticleVo());
		return json;
	}
}