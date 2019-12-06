package com.cn.wanxi.mall.controller;

import com.cn.wanxi.mall.bean.Brand;
import com.cn.wanxi.mall.service.BrandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: LucioWade
 * @Date: 15:14 2019/12/5
 */
@RestController
@RequestMapping("brand")
public class BrandController {

    @Resource
    private BrandService brandService;

    @GetMapping("findAll")
    public List<Brand> findAllBrands() {
        return brandService.findAll();
    }

}
