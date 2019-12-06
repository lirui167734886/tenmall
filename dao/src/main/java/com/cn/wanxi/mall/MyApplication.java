package com.cn.wanxi.mall;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 启动类核心程序类
 * @author LiRui
 */
@SpringBootApplication
public class MyApplication extends SpringBootServletInitializer {

//	public static void main(String[] args) {
//		SpringApplication app = new SpringApplication(MyApplication.class);
//		//app.setBannerMode(Banner.Mode.OFF);
//		app.run(args); //启动
//	}
	
	/**插件可以打成War包*/
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MyApplication.class);
	}
	
}
