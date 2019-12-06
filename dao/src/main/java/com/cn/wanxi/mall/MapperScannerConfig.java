package com.cn.wanxi.mall;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;

/**
 * @author LiRui
 */
@SpringBootConfiguration
 /**
  * 保证在MyBatisConfig实例化之后再实例化该类
  * @author LiRui*/
@AutoConfigureAfter(MybatisConfig.class)
public class MapperScannerConfig {

	 /**mapper接口的扫描器*/
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("com.cn.wanxi.mall.dao");
		return mapperScannerConfigurer;
	}

}
