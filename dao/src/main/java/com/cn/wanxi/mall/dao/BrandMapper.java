package com.cn.wanxi.mall.dao;

import com.cn.wanxi.mall.bean.Brand;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: LucioWade
 * @Date: 17:55 2019/11/26
 */
public interface BrandMapper {

    /**
     * find all brand
     *
     * @return brands list
     */
    @Select("select * from wx_tab_brand")
    @Transactional(readOnly = true)
    List<Brand> selectAll();

    /**
     * find a brand by id
     *
     * @param id brand id
     * @return brand
     */
    @Select("select * from wx_tab_brand where id = #{id}")
    Brand selectOneById(int id);

    /**
     * find a brand by name
     *
     * @param name brand name
     * @return brand
     */
    @Select("select * from wx_tab_brand where name = #{name}")
    Brand selectOneByName(String name);

    /**
     * find a brand list by name
     *
     * @param name brand name
     * @return brand list
     */
    @Select("select * from wx_tab_brand brand where brand.name like CONCAT(#{name},'%')")
    List<Brand> selectBrandsByName(String name);

    /**
     * insert a brand
     *
     * @param name   brand name
     * @param image  image path
     * @param letter brand first letter
     * @param seq    sort
     * @return modify count
     */
    @Insert("insert into wx_tab_brand(name, image, letter, seq) values(#{name}, #{image}, #{letter}, #{seq})")
    int insertBrand(String name, String image, char letter, int seq);

    /**
     * update a brand
     *
     * @param id     brand id
     * @param name   brand name
     * @param image  image path
     * @param letter brand first letter
     * @param seq    sort
     * @return modify count
     */
    @Update("update wx_tab_brand set name =#{name}, image = #{image}, letter = #{letter}, seq = #{seq} where id = #{id}")
    int updateBrand(int id, String name, String image, char letter, int seq);

    /**
     * delete brand by id
     *
     * @param id brand id
     * @return modify count
     */
    @Delete("delete from wx_tab_brand where id = #{id}")
    int deleteBrandById(int id);

}
