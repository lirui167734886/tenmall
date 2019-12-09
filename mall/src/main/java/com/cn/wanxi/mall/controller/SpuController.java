package com.cn.wanxi.mall.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.cn.wanxi.mall.bean.Sku;
import com.cn.wanxi.mall.bean.Spu;
import com.cn.wanxi.mall.service.SpuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
@RequestMapping("/product")
public class SpuController {

    @Resource
    private SpuService sps;

    @PostMapping("add")
    public Map<String, String> add(HttpServletRequest request) {
        String sn = request.getParameter("sn");
        String name = request.getParameter("name");
        String caption = request.getParameter("caption");
        String image = request.getParameter("image");
        String images = request.getParameter("images");
        String introduction = request.getParameter("introduction");
        String skuLists = request.getParameter("skuList");

        String brandIds = request.getParameter("brandId");
        String category1Ids = request.getParameter("category1Id");
        String category2Ids = request.getParameter("category2Id");
        String category3Ids = request.getParameter("category3Id");
        String templateIds = request.getParameter("templateId");
        String freightIds = request.getParameter("freightId");
        Map<String, String> map = new HashMap<>(16);
        if (sn == null || name == null || caption == null || image == null || images == null || introduction == null || skuLists == null
                || brandIds == null || category1Ids == null || category2Ids == null || category3Ids == null || templateIds == null
                || freightIds == null) {
            map.put("code", "1");
            map.put("message", "请输入完整参数");
            return map;
        }
        List<Sku> skuList = JSON.parseObject("skuLists", new TypeReference<ArrayList<Sku>>() {
        });
        int brandId = Integer.parseInt(brandIds);
        int category1Id = Integer.parseInt(category1Ids);
        int category2Id = Integer.parseInt(category2Ids);
        int category3Id = Integer.parseInt(category3Ids);
        int templateId = Integer.parseInt(templateIds);
        int freightId = Integer.parseInt(freightIds);
        Integer saleNum = 0;
        Integer commentNum = 0;
        String isMarketable = "0";
        String isEnableSpec = "0";
        String isDelete = "0";
        String status = "0";
        String specItems = "";
        String paraItems = "";
        String saleService = "无";
        Spu spu = new Spu(sn, name, caption, brandId, category1Id,
                category2Id, category3Id, templateId, freightId,
                image, images, saleService, introduction, specItems,
                paraItems, saleNum, commentNum, isMarketable, isEnableSpec,
                isDelete, status, skuList);

        return sps.add(spu);
    }

    @PostMapping("update")
    public Map<String, String> update(@RequestBody Spu spu) {
        Map<String, String> update = new HashMap<>(16);
        if (!spu.getAll(spu)) {
            update.put("code", "1");
            update.put("message", "请添加完整参数");
            return update;
        }
        return sps.update(spu);
    }

    @PostMapping("delete")
    public Map<String, String> delete(Integer id) {
        Map<String, String> delete = new HashMap<>(16);
        if (id == null) {
            delete.put("code", "1");
            delete.put("message", "请选择id");
            return delete;
        }
        return sps.delete(id);
    }

    @GetMapping("findById")
    public Map<String, Object> findById(Integer id) {
        Map<String, Object> map = new HashMap<>(16);
        if (id == null || id == 0) {
            map.put("message", "请传id");
        }
        return sps.findById(id);
    }

    @GetMapping("findPage")
    public Map<String, Object> findPage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String sn = request.getParameter("sn");
        String ids = request.getParameter("id");
        String pages = request.getParameter("page");
        String sizes = request.getParameter("size");

        Integer id = ids == null ? null : Integer.parseInt(ids);
        Integer page = pages == null ? 1 : Integer.parseInt(pages);
        Integer size = sizes == null ? 5 : Integer.parseInt(sizes);

        Spu spu = new Spu();
        spu.setName(name);
        spu.setSn(sn);
        spu.setId(id);

        return sps.findPage(spu, page, size);

    }

    @PostMapping("findSpuPage")
    public Map<String, Object> findSpuPage(HttpServletRequest request) {
        String pages = request.getParameter("page");
        String sizes = request.getParameter("size");

        String name = request.getParameter("name");
        String caption = request.getParameter("caption");
        String brandName = request.getParameter("brandName");


        Integer page = pages == null ? 1 : Integer.parseInt(pages);
        Integer size = sizes == null ? 5 : Integer.parseInt(sizes);

        Spu spu = new Spu();
        spu.setName(name);
        spu.setCaption(caption);

        return sps.findSpuPage(spu, page, size, brandName);
    }

    @PostMapping("submitReq")
    public Map<String, String> submitReq(Integer id) {
        Map<String, String> map = new HashMap<>(16);
        if (id == null) {
            map.put("code", "1");
            map.put("message", "id为空");
            return map;
        }

        return sps.submitReq(id);
    }

    @PostMapping("findAuditALL")
    public Map<String, Object> findAuditALL(
            @RequestParam(value = "status", defaultValue = "9") String status,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "5") Integer size) {

        return sps.findAuditALL(status,page,size);

    }

    @PostMapping("auditReq")
    public Map<String, String> auditReq(Integer id){
        Map<String, String> map = new HashMap<>(16);
        if (id == null) {
            map.put("code", "1");
            map.put("message", "id为空");
            return map;
        }
        return sps.auditReq(id);
    }

    @PostMapping("pullReq")
    public Map<String, String> pullReq(Integer id){
        Map<String, String> map = new HashMap<>(16);
        if (id==null){
            map.put("code", "1");
            map.put("message", "id为空");
            return map;
        }
        return sps.pullReq(id);
    }
    @PostMapping("shelvesReq")
    public Map<String, String> shelvesReq(Integer id){
        Map<String, String> map = new HashMap<>(16);
        if (id==null){
            map.put("code", "1");
            map.put("message", "id为空");
            return  map;
        }
        return sps.shelvesReq(id);
    }

    @PostMapping("batchShelvesReq")
    public Map<String, String> batchShelvesReq(HttpServletRequest request){
        Map<String, String> map = new HashMap<>(16);
        String ids = request.getParameter("id");
        if (ids==null){
            map.put("code", "1");
            map.put("message", "id为空");
            return  map;
        }
        String[] split = ids.split(",");
        List<String> strings = Arrays.asList(split);
        return sps.batchShelvesReq(strings);
    }

    @PostMapping("batchPullReq")
    public Map<String, String> batchPullReq(HttpServletRequest request){
        Map<String, String> map = new HashMap<>(16);
        String ids = request.getParameter("id");
        if (ids==null){
            map.put("code", "1");
            map.put("message", "id为空");
            return  map;
        }
        String[] split = ids.split(",");
        List<String> strings = Arrays.asList(split);
        return sps.batchPullReq(strings);
    }

}

