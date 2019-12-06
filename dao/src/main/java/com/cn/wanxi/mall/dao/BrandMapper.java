package com.cn.wanxi.mall.dao;

import com.cn.wanxi.mall.bean.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: LucioWade
 * @Date: 17:55 2019/11/26
 */
@Mapper
public interface BrandMapper {

    /**
     * find all brand
     *
     * @return brand list
     */
    @Select("select * from wx_tab_brand")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "image", column = "image"),
            @Result(property = "letter", column = "letter"),
            @Result(property = "seq", column = "seq")
    })
    List<Brand> findAll();

}
