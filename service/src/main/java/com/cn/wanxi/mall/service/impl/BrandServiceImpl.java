package com.cn.wanxi.mall.service.impl;

import com.cn.wanxi.mall.bean.Brand;
import com.cn.wanxi.mall.service.BrandService;
import com.cn.wanxi.mall.dao.BrandMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: LucioWade
 * @Date: 17:53 2019/11/26
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.findAll();
    }
}
