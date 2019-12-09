package com.cn.wanxi.mall.service;

import com.cn.wanxi.mall.bean.Brand;
import com.cn.wanxi.mall.bean.dto.ResultDTO;

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

    /**
     * get brands pages
     *
     * @param page 页码
     * @param size 每页记录
     * @return brand list
     */
    List<Brand> findPage(int page, int size);


    /**
     * find a brand page by name
     *
     * @param name brand name
     * @param page page
     * @param size page size
     * @return brand list
     */
    List<Brand> findPageByName(String name, int page, int size);

    /**
     * get a brand
     *
     * @param id brand id
     * @return brand
     */
    Brand findOneById(int id);

    /**
     * insert a brand
     *
     * @param name   brand name
     * @param image  image path
     * @param letter brand first letter
     * @param seq    sort
     * @return code and message
     */
    ResultDTO addBrand(String name, String image, char letter, int seq);

    /**
     * update a brand
     *
     * @param id     brand id
     * @param name   brand name
     * @param image  image path
     * @param letter brand first letter
     * @param seq    sort
     * @return code and message
     */
    ResultDTO updateBrand(int id, String name, String image, char letter, int seq);

    /**
     * delete brand by id
     *
     * @param id brand id
     * @return code and message
     */
    ResultDTO deleteBrandById(int id);

}
