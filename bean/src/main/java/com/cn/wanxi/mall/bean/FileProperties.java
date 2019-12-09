package com.cn.wanxi.mall.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: LucioWade
 * @Date: 9:41 2019/12/9
 */
@Configuration
@ConfigurationProperties(prefix = "file")
public class FileProperties {

    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }

}
