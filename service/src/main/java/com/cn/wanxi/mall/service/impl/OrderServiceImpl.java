package com.cn.wanxi.mall.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cn.wanxi.mall.bean.Order;
import com.cn.wanxi.mall.dao.OrderMapper;
import com.cn.wanxi.mall.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 车元朴
 * @since 2019-11-26
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
