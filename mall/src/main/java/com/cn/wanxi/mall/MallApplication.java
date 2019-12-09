package com.cn.wanxi.mall;

import com.cn.wanxi.mall.bean.FileProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author LiRui
 */
@SpringBootApplication
@MapperScan(basePackages = "com.cn.wanxi.mall.dao")
@EnableConfigurationProperties({
        FileProperties.class
})
public class MallApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class, args);
    }

}
