package com.cn.wanxi.mall.service;

import com.baomidou.mybatisplus.service.IService;
import com.cn.wanxi.mall.bean.Template;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiRui
 * @since 2019-11-21
 */
public interface TemplateService extends IService<Template> {

    /**
     * <p>
     *          添加（模版名字必有）
     * </p>
     * @param template 模版对象
     * @return map的key为code map的value数据库不存在这个模版名字；map的key为message1：存在
     */
    Map<String,String> add(Template template);

    /**
     * <p>
     *     修改（模版必有）
     * </p>
     * @param template 模版对象
     * @return map信息
     */
    Map<String,String> update(Template template);

    /**
     * <p>
     *     查询所有模版
     * </p>
     * @return
     */
    List<Template> findAll();


    /**
     * <p>
     *     根据id删除
     * </p>
     * @param id id
     * @return map信息
     */
    Map<String,String> delete(Integer id);

    /**
     * <p>
     *     根据名字，页数，每页条数查询
     * </p>
     * @param name 模版名字
     * @param page 当前页
     * @param size 每页条数
     * @return map信息
     */
    Map<String, Object> findCondPage(String name, int page, int size);
}
