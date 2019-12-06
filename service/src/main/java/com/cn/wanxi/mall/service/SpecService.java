package com.cn.wanxi.mall.service;

import com.baomidou.mybatisplus.service.IService;
import com.cn.wanxi.mall.bean.Spec;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiRui
 * @since 2019-11-22
 */
public interface SpecService extends IService<Spec> {

    /**
     * <p>
     *     查询规格
     * </p>
     * @param spec 规格参数对象
     * @return 规格参数集合
     */
    List<Spec> selectBySpec(Spec spec);

    /**
     * <p>
     *     规格参数添加
     * </p>
     * @param spec 规格参数对象
     * @return map信息
     */
    Map<String, String> add(Spec spec);

    /**
     * <p>
     *     规格参数修改
     * </p>
     * @param spec 规格参数对象
     * @return map信息
     */
    Map<String, String> update(Spec spec);

    /**
     * <p>
     *     根据id删除
     * </p>
     * @param id id
     * @return map信息
     */
    Map<String, String> delete(Integer id);

    /**
     * <p>
     *     查询所有
     * </p>
     * @return 规格
     */
    List<Spec> findAll();

    /**
     * <p>
     *     根据名字，页数，每页条数查询
     * </p>
     * @param name 模版名字
     * @param page 当前页
     * @param size 每页条数
     * @return map信息
     */
    Map<String, Object> findCondPage(String name, String options, int page, int size);
}
