package com.cn.wanxi.mall.service;

import com.cn.wanxi.mall.bean.Brand;

import java.util.List;

/**
 * @Author: LucioWade
 * @Date: 17:53 2019/11/26
 */
public interface BrandService {

    /**
     * find all brand
     *
     * @return brand list
     */
    List<Brand> findAll();

}
