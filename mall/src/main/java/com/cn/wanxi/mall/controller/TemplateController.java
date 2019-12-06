package com.cn.wanxi.mall.controller;


import com.cn.wanxi.mall.bean.Template;
import com.cn.wanxi.mall.service.TemplateService;
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
 * @since 2019-11-21
 */
@RestController
@RequestMapping("/template")
public class TemplateController {

    @Resource
    private TemplateService ts;

    @PostMapping("add")
    public Map<String, String> add(ModelMap m, HttpServletResponse response, HttpServletRequest request) {
        String name = request.getParameter("name");
        Map<String, String> h = new HashMap<>(16);
        if (name == null) {
            h.put("code", "1");
            h.put("message", "请输入模版名字！");
            return h;
        }
//        String spec_num = request.getParameter("spec_num");
//        String para_num = request.getParameter("para_num");
//        Integer specNum = spec_num == null ? 0 : Integer.parseInt(spec_num);
//        Integer paraNum = para_num == null ? 0 : Integer.parseInt(para_num);
        Template template = new Template();
        template.setName(name);
//        template.setSpecNum(specNum);
//        template.setParaNum(paraNum);
        return ts.add(template);
    }

    @PostMapping("update")
    public Map<String,String> update(ModelMap m, HttpServletResponse response, HttpServletRequest request) {
        String name = request.getParameter("name");
        String ids = request.getParameter("id");
        Map<String, String> h = new HashMap<>(16);
        if (name == null||ids==null) {
            h.put("code", "1");
            h.put("message", "请输入模版名字或选择修改的模版！");
            return h;
        }
        String spec_num = request.getParameter("spec_num");
        String para_num = request.getParameter("para_num");
        Integer specNum = spec_num == null ? 0 : Integer.parseInt(spec_num);
        Integer paraNum = para_num == null ? 0 : Integer.parseInt(para_num);
        Integer id=Integer.parseInt(ids);

        Template template = new Template();
        template.setId(id);
        template.setName(name);
        template.setSpecNum(specNum);
        template.setParaNum(paraNum);
        return ts.update(template);
    }

    @GetMapping("findAll")
    public List<Template> findAll() {
        return ts.findAll();
    }

    @GetMapping("findCondPage")
    public Map<String,Object> findCondPage(HttpServletRequest request){
        String name = request.getParameter("name");
        String pages = request.getParameter("page");
        String sizes = request.getParameter("size");
//        if (name==null){
//            HashMap<String, Object> map = new HashMap<>(16);
//            map.put("message","缺少参数，请输入完整");
//            return map;
//        }
        int page=pages==null?1:Integer.parseInt(pages);
        int size=sizes==null?4:Integer.parseInt(sizes);
        return ts.findCondPage(name,page,size);
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
        return ts.delete(id);
    }

}

