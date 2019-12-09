package com.cn.wanxi.mall.controller;


import com.cn.wanxi.mall.bean.Sku;
import com.cn.wanxi.mall.service.SkuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author LiRui
 * @since 2019-11-22
 */
@RestController
@RequestMapping("/sku")
public class SkuController {

    @Resource
    private SkuService sks;


    @PostMapping("add")
    public Map<String, String> add(@RequestBody Sku sku) {
        Map<String, String> add = new HashMap<>(16);
        if (!sku.getCID(sku)) {
            add.put("code", "1");
            add.put("message", "添加参数不完整");
            return add;
        }

        return sks.add(sku);
    }

    @PostMapping("update")
    public Map<String, String> update(@RequestBody Sku sku) {
        Map<String, String> update = new HashMap<>(16);
        if (!sku.getAll(sku)) {
            update.put("code", "1");
            update.put("message", "添加参数不完整");
            return update;
        }
        return sks.update(sku);
    }

    @PostMapping("delete")
    public Map<String, String> delete(Integer id) {
        Map<String, String> delete = new HashMap<>(16);
        if (id == null) {
            delete.put("code", "1");
            delete.put("message", "请选择id");
            return delete;
        }
        return sks.delete(id);
    }

    @GetMapping("findById")
    public Map<String,Object> findById(Integer id){
        Map<String,Object> map=new HashMap<>(16);
        if (id==null||id==0){
            map.put("message","请传id");
        }
        return sks.findById(id);
    }

}

