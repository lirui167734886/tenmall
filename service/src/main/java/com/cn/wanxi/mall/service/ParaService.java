package com.cn.wanxi.mall.service;

import com.baomidou.mybatisplus.service.IService;
import com.cn.wanxi.mall.bean.Para;

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
public interface ParaService extends IService<Para> {

    /**
     * <p>
     *     添加参数
     * </p>
     * @param para 参数对象
     * @return map信息
     */
    Map<String, String> add(Para para);

    /**
     * <p>
     *     修改参数
     * </p>
     * @param para 参数对象
     * @return map信息
     */
    Map<String, String> update(Para para);

    /**
     * <p>
     *     删除参数
     * </p>
     * @param id 参数id
     * @return map信息
     */
    Map<String, String> delete(Integer id);

    /**
     * <p>
     *     查询所有
     * </p>
     * @return 参数集合
     */
    List<Para> findAll();

    /**
     * <p>
     *     分页
     * </p>
     * @param name 参数名字
     * @param options 参数选项
     * @param page 起始页
     * @param size 每页数据
     * @return map信息
     */
    Map<String, Object> findCondPage(String name, String options, int page, int size);
}
