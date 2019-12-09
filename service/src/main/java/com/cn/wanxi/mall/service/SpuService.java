package com.cn.wanxi.mall.service;

import com.baomidou.mybatisplus.service.IService;
import com.cn.wanxi.mall.bean.Spu;

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
public interface SpuService extends IService<Spu> {

    /**
     * <p>
     *     添加spu
     * </p>
     * @param spu spu对象
     * @return map信息
     */
    Map<String, String> add(Spu spu);

    /**
     * <p>
     *     spu修改
     * </p>
     * @param spu spu对象
     * @return map信息
     */
    Map<String, String> update(Spu spu);

    /**
     * <p>
     *     根据id删除
     * </p>
     * @param id spu删除
     * @return map信息
     */
    Map<String, String> delete(Integer id);

    /**
     * <p>
     *     根据id查询
     * </p>
     * @param id
     * @return
     */
    Map<String, Object> findById(Integer id);

    /**
     * <p>
     *     根据spu查所有sku
     * </p>
     * @param spu
     * @param page
     * @param size
     * @return
     */
    Map<String, Object> findPage(Spu spu, Integer page, Integer size);

    /**
     * <p>
     *     SPU分页
     * </p>
     * @param spu
     * @param page
     * @param size
     * @param brandName
     * @return
     */
    Map<String, Object> findSpuPage(Spu spu, Integer page, Integer size, String brandName);

    /**
     * <p>
     *     审核
     * </p>
     * @param id
     * @return
     */
    Map<String, String> submitReq(Integer id);

    /**
     * <p>
     *     查看审核列表
     * </p>
     * @param status
     * @param page
     * @param size
     * @return
     */
    Map<String, Object> findAuditALL(String status, Integer page, Integer size);

    /**
     * <p>
     *     审核成功
     * </p>
     * @param id
     * @return
     */
    Map<String, String> auditReq(Integer id);

    /**
     * <p>
     *     下架
     * </p>
     * @param id
     * @return
     */
    Map<String, String> pullReq(Integer id);

    /**
     * <p>
     *     上架
     * </p>
     * @param id
     * @return
     */
    Map<String, String> shelvesReq(Integer id);

    /**
     * <p>
     *     批量上架
     * </p>
     * @param strings id的string集合
     * @return
     */
    Map<String, String> batchShelvesReq(List<String> strings);

    /**
     * <p>
     *     批量下架
     * </p>
     * @param strings id的string集合
     * @return
     */
    Map<String, String> batchPullReq(List<String> strings);
}
