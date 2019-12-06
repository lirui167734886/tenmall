package com.cn.wanxi.mall.service;

import com.baomidou.mybatisplus.service.IService;
import com.cn.wanxi.mall.bean.Category;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LiRui
 * @since 2019-11-22
 */
public interface CategoryService extends IService<Category> {

    /**
     * <p>
     * 添加商品分类
     * </p>
     *
     * @param category 分类实体
     * @return map信息
     */
    Map<String, String> add(Category category);

    /**
     * <p>
     * 修改商品分类
     * </p>
     *
     * @param category
     * @return
     */
    Map<String, String> update(Category category);

    /**
     * <p>
     * 查询所有
     * </p>
     *
     * @return 分类集合
     */
    List<Category> findAll();

    /**
     * <p>
     * 根据父级显示列表
     * </p>
     *
     * @param parentId 父级id
     * @return Category对象
     */
    Category findByParentId(int parentId);

    /**
     * <p>
     *     根据id删除
     * </p>
     * @param id
     * @return
     */
    Map<String, String> delete(Integer id);
}
