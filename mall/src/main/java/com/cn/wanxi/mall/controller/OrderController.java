package com.cn.wanxi.mall.controller;


import com.cn.wanxi.mall.bean.Order;
import com.cn.wanxi.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author: LiRui
 * @Date: 2019/11/19
 * @Time: 18:05
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/list")
    @ResponseBody
    public String list() {
        List<Order> list = orderService.selectList(null);
        return list.toString();
    }
}



