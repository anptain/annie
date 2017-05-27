package com.winterfell.annie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages = "com.winterfell.annie.mapper")
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) throws Exception {
		
		String aa= "110000　　北京市";
		
		SpringApplication.run(Application.class, args);
//		List<String> lines = FileUtils.readLines(new File("e:/aa.txt"));
//		StringBuilder sb = new StringBuilder();
//		int index = 1;
//		int parentId = 1;
//		for (String str : lines) {
//			String[] tmp = str.replaceAll("[ 　]+", " ").trim().split(" ");
//			if(str.startsWith("　")){
//				if(!tmp[1].equals("市辖区")){
//					sb.append("INSERT INTO `sys_district`(`id`,`code`,`name`,`parent_id`,`deleted`,`created_by`,`created_date`,`last_modified_by`,`last_modified_date`) ");
//					sb.append("VALUES("+index+",'"+tmp[0]+"','"+tmp[1]+"',"+(index-1)+",0,1,NOW(),1,NOW())").append("\n");
//				}
//			}else{
//				if(str.endsWith("市")){
//					sb.append("INSERT INTO `sys_district`(`id`,`code`,`name`,`parent_id`,`deleted`,`created_by`,`created_date`,`last_modified_by`,`last_modified_date`) ");
//					sb.append("VALUES("+index+",'"+tmp[0]+"','"+tmp[1]+"',0,0,1,NOW(),1,NOW())").append("\n");;
//					index++;
//					sb.append("INSERT INTO `sys_district`(`id`,`code`,`name`,`parent_id`,`deleted`,`created_by`,`created_date`,`last_modified_by`,`last_modified_date`) ");
//					sb.append("VALUES("+index+",'"+tmp[0]+"','"+tmp[1]+"',"+(parentId-1)+",0,1,NOW(),1,NOW())").append("\n");;
//					parentId = index;
//				}else{
//					sb.append("INSERT INTO `sys_district`(`id`,`code`,`name`,`parent_id`,`deleted`,`created_by`,`created_date`,`last_modified_by`,`last_modified_date`) ");
//					sb.append("VALUES("+index+",'"+tmp[0]+"','"+tmp[1]+"',0,0,1,NOW(),1,NOW())").append("\n");;
//					parentId = index;
//				}
//				
//			}
//			index++;
//		}
//		
//		FileUtils.write(new File("e:/abc.sql"), sb.toString(),"utf-8");
	}
}
