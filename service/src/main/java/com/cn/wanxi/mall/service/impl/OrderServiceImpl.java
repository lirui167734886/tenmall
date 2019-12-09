package com.cn.wanxi.mall.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cn.wanxi.mall.bean.Order;

import com.cn.wanxi.mall.bean.OrderConfig;
import com.cn.wanxi.mall.dao.OrderConfigMapper;
import com.cn.wanxi.mall.dao.OrderMapper;
import com.cn.wanxi.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired(required = false)
    OrderMapper orderMapper;
    @Autowired(required = false)
    OrderConfigMapper orderConfigMapper;


    @Override
    public List<Order> sendsumbit(int id) {
        List<Order> list = orderMapper.sendsumbit(id);
        return list;
    }


    @Override
    public List<Order> findAll() {
        List<Order> list = orderMapper.findAll();
        return list;
    }

    @Override
    @Scheduled(cron = "0 */2 * * * ?")
    public String timeout() {
        List<OrderConfig> list = orderConfigMapper.selectList(null);
        String message="";
        for (OrderConfig a:list
             ) {
            if( a.getOrderTimeout()>30){
                message= "订单失效";
            }else if(a.getSeckillTimeout()>30){
                message= "订单失效";
            }
        }
        return message;
    }

}

