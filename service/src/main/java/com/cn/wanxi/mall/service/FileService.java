package com.cn.wanxi.mall.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: LucioWade
 * @Date: 9:51 2019/12/9
 */
public interface FileService {

    /**
     * 存储文件到系统
     *
     * @param file 文件
     * @return 文件名
     */
    String storeFile(MultipartFile file);

    /**
     * 加载文件
     * @param fileName 文件名
     * @return 文件
     */
    Resource loadFileAsResource(String fileName);

}