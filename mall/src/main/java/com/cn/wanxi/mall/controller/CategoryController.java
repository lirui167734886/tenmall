package com.cn.wanxi.mall.controller;


import com.cn.wanxi.mall.bean.Category;
import com.cn.wanxi.mall.service.CategoryService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService cs;

    @PostMapping("add")
    public Map<String, String> add(ModelMap m, HttpServletResponse response, HttpServletRequest request) {
        String name = request.getParameter("name");
        String num = request.getParameter("goodsNum");
        String isShow = request.getParameter("isShow");
        String isMenu = request.getParameter("isMenu");
        String seqs = request.getParameter("seq");
        String parentIds = request.getParameter("parentId");
        String templateIds = request.getParameter("templateId");
        Map<String, String> h = new HashMap<>(16);
        if (name == null || num == null || isShow == null || isMenu == null || seqs == null || parentIds == null || templateIds == null) {
            h.put("code", "1");
            h.put("message", "请输入完整参数！");
            return h;
        }
        Integer goodsNum = Integer.parseInt(num);
        Integer seq = Integer.parseInt(seqs);
        int parentId = Integer.parseInt(parentIds);
        int templateId = Integer.parseInt(templateIds);
        Category category = new Category(name, goodsNum, isShow, isMenu, seq, parentId, templateId);

        return cs.add(category);
    }
    @PostMapping("update")
    public Map<String,String> update(ModelMap m, HttpServletResponse response, HttpServletRequest request) {
        String ids = request.getParameter("id");
        String name = request.getParameter("name");
        String num = request.getParameter("goodsNum");
        String isShow = request.getParameter("isShow");
        String isMenu = request.getParameter("isMenu");
        String seqs = request.getParameter("seq");
        String parentIds = request.getParameter("parentId");
        String templateIds = request.getParameter("templateId");
        Map<String, String> h = new HashMap<>(16);
        if (ids==null||name == null || num == null || isShow == null || isMenu == null || seqs == null || parentIds == null || templateIds == null) {
            h.put("code", "1");
            h.put("message", "请输入完整参数！");
            return h;
        }
        int id = Integer.parseInt(ids);
        Integer goodsNum = Integer.parseInt(num);
        Integer seq = Integer.parseInt(seqs);
        int parentId = Integer.parseInt(parentIds);
        int templateId = Integer.parseInt(templateIds);
        Category category = new Category(id,name, goodsNum, isShow, isMenu, seq, parentId, templateId);

        return cs.update(category);
    }

    @GetMapping("findAll")
    public List<Category> findAll() {
        return cs.findAll();
    }

    @GetMapping("findByParentId")
    public Object findByParentId(HttpServletRequest request) {
        String parentIds = request.getParameter("parentId");
        if (parentIds == null) {
            HashMap<String, Object> map = new HashMap<>(16);
            map.put("message", "缺少参数，请输入完整");
            return map;
        }
        int parentId = Integer.parseInt(parentIds);
        return cs.findByParentId(parentId);
    }

    @PostMapping("delete")
    public Map<String,String> delete(HttpServletRequest request){
        String idd = request.getParameter("id");
        Map<String,String> delete = new HashMap<>(16);
        if (idd==null){
            delete.put("code","1");
            delete.put("message","请输入id！");
            return delete;
        }
        Integer id=Integer.parseInt(idd);
        return cs.delete(id);
    }
}

