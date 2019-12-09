package com.cn.wanxi.mall.service.impl;

import com.cn.wanxi.mall.bean.Brand;
import com.cn.wanxi.mall.bean.dto.ResultDTO;
import com.cn.wanxi.mall.service.BrandService;
import com.cn.wanxi.mall.dao.BrandMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: LucioWade
 * @Date: 17:53 2019/11/26
 */
@Service
public class BrandServiceImpl extends ResultDTO implements BrandService {

    @Resource
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public List<Brand> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        List<Brand> brands = brandMapper.selectAll();
        PageInfo<Brand> brandPageInfo = new PageInfo<>(brands);
        return brandPageInfo.getList();
    }

    @Override
    public List<Brand> findPageByName(String name, int page, int size) {
        PageHelper.startPage(page, size);
        List<Brand> brands = brandMapper.selectBrandsByName(name);
        PageInfo<Brand> brandPageInfo = new PageInfo<>(brands);
        return brandPageInfo.getList();
    }

    @Override
    public Brand findOneById(int id) {
        return brandMapper.selectOneById(id);
    }

    @Override
    public ResultDTO addBrand(String name, String image, char letter, int seq) {
        return this.resultHandle(brandMapper.insertBrand(name, image, letter, seq));
    }

    @Override
    public ResultDTO updateBrand(int id, String name, String image, char letter, int seq) {
        return this.resultHandle(brandMapper.updateBrand(id, name, image, letter, seq));
    }

    @Override
    public ResultDTO deleteBrandById(int id) {
        return this.resultHandle(brandMapper.deleteBrandById(id));
    }

    private ResultDTO resultHandle(int count) {
        if (count > 0) {
            return success("success");
        } else {
            return failure("failure");
        }
    }
}
