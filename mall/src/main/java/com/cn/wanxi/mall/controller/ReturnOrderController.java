package com.cn.wanxi.mall.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.cn.wanxi.mall.bean.ReturnCause;
import com.cn.wanxi.mall.bean.ReturnOrder;
import com.cn.wanxi.mall.service.ReturnCauseService;
import com.cn.wanxi.mall.service.ReturnOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 车元朴
 * @since 2019-11-26
 */
@RestController
@RequestMapping("/return")
public class ReturnOrderController {
    @Autowired
    ReturnOrderService service;
    @Autowired
    ReturnCauseService returnCauseService;


    @RequestMapping("/list")
    public Page<ReturnOrder> list(){
        Page<ReturnOrder> page1 = new Page<>(1, 5, "id");
        Page<ReturnOrder> list = service.selectPage(page1,null);
        return list;
    }

    @RequestMapping("/casue")
    public List<ReturnCause> casue(@RequestParam(value = "id") int id){
        ReturnCause approval = returnCauseService.selectById(id);
        List<ReturnCause> list = new ArrayList<ReturnCause>();
        list.add(approval);
        return list;
    }

    @RequestMapping("/approval")
    public String approval(@RequestParam(value = "id")int id,@RequestParam(value = "status") char status){
        int code = id;
        String message;
        if (status==1){
             message = "操作成功";
        }else {
             message = "操作失败";
        }
        String approval = "code:"+code+","+"message:"+ message;
        return approval;
    }

}
