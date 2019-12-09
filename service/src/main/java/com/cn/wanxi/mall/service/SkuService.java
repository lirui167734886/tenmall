package com.cn.wanxi.mall.service;

import com.baomidou.mybatisplus.service.IService;
import com.cn.wanxi.mall.bean.Sku;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiRui
 * @since 2019-11-22
 */
public interface SkuService extends IService<Sku> {

    /**
     * <p>
     *     添加sku
     * </p>
     * @param sku sku对象
     * @return map信息
     */
    Map<String, String> add(Sku sku);

    /**
     * <p>
     *     修改sku
     * </p>
     * @param sku sku对象
     * @return map信息
     */
    Map<String, String> update(Sku sku);

    /**
     * <p>
     *     删除sku
     * </p>
     * @param id id
     * @return map信息
     */
    Map<String, String> delete(Integer id);

    /**
     * <p>
     *     根据id查询sku
     * </p>
     * @param id id
     * @return map信息
     */
    Map<String, Object> findById(Integer id);
}
