package com.cn.wanxi.mall.controller;


import com.cn.wanxi.mall.bean.Order;
import com.cn.wanxi.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * @author: LiRui
 * @Date: 2019/11/19
 * @Time: 18:05
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/list")
    public List<Order> list() {
        List<Order> list = orderService.findAll();
        return list;
    }

    @RequestMapping("/batchlist")
    public List<Order> batchlist(@RequestParam(value = "ids") String ids){
        Integer [] list = new Integer[ids.length()];
        String[] split = ids.split(",");
        for (int i = 0; i <ids.length(); i++) {
            list[i] = Integer.parseInt(split[i]);
        }
        List<Order> orders = new ArrayList<Order>();
        for (int a:list
             ) {
            Order order = orderService.selectById(a);
            orders.add(order);
        }
        return orders;
    }

    @RequestMapping("/sendsubmit")
    public List<Order> send(@RequestParam(value = "id") int id){
        List<Order> list = orderService.sendsumbit(id);
        return list;
    }


}



