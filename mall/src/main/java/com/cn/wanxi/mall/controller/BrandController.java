package com.cn.wanxi.mall.controller;

import com.cn.wanxi.mall.bean.Brand;
import com.cn.wanxi.mall.bean.dto.PageDTO;
import com.cn.wanxi.mall.bean.dto.ResultDTO;
import com.cn.wanxi.mall.service.BrandService;
import org.springframework.web.bind.annotation.*;

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
    public List<Brand> findAll() {
        return brandService.findAll();
    }

    @GetMapping("findPage")
    public PageDTO<Brand> findBrandPage(@RequestParam("page") int page, @RequestParam("size") int size) {
        List<Brand> brands = brandService.findPage(page, size);
        return new PageDTO<>(brands, brands.size());
    }

    @GetMapping("findCondPage")
    public PageDTO<Brand> findCondBrandPage(@RequestParam("name") String name,
                                            @RequestParam("page") int page,
                                            @RequestParam("size") int size) {
        List<Brand> brands = brandService.findPageByName(name, page, size);
        return new PageDTO<>(brands, brands.size());
    }


    @GetMapping("findById")
    public Brand findOneById(@RequestParam("id") int id) {
        return brandService.findOneById(id);
    }

    @GetMapping("findByName")
    public Brand findOneByName(@RequestParam("name") String name) {
        return brandService.selectOneByName(name);
    }

    @PostMapping("add")
    public ResultDTO addBrand(@RequestParam("name") String name, @RequestParam("image") String image,
                              @RequestParam("letter") char letter, @RequestParam("seq") int seq) {
        return brandService.addBrand(name, image, letter, seq);
    }

    @PostMapping("update")
    public ResultDTO updateBrand(@RequestParam("id") int id, @RequestParam("name") String name,
                                 @RequestParam("image") String image, @RequestParam("letter") char letter,
                                 @RequestParam("seq") int seq) {
        return brandService.updateBrand(id, name, image, letter, seq);
    }

    @DeleteMapping("delete")
    public ResultDTO deleteBrandById(@RequestParam("id") int id) {
        return brandService.deleteBrandById(id);
    }


}
