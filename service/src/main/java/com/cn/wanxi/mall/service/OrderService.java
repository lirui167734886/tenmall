package com.cn.wanxi.mall.service;

import com.baomidou.mybatisplus.service.IService;
import com.cn.wanxi.mall.bean.Order;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 车元朴
 * @since 2019-11-26
 */
public interface OrderService extends IService<Order> {

    List<Order> sendsumbit(int id);
    List<Order> findAll();
    String timeout();

}
