package com.xairball.annie;

import org.apache.commons.lang3.RandomUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages = "com.xairball.annie.mapper")
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	
	
	
	public static void main(String[] args) throws Exception {
		final String[][] map = new String[12][30];
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(;;){
				int x = RandomUtils.nextInt(0, map.length);
				int y = RandomUtils.nextInt(0, map[1].length);
				map[x][y] = "&";
				
				for (String[] str : map) {
					for (int i = 0; i < str.length; i++) {
						System.out.print(str[i]);
					}
					System.out.println();
				}
				}
			}
		}).start();
		
//		String aa= "110000　　北京市";
//		for (int i = 0; i < 10000; i++) {
//			System.out.println(RandomUtils.nextInt(1,7));
//		}
		//System.out.println(DateFormatUtils.format(date, pattern)));
//		SpringApplication.run(Application.class, args);
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
