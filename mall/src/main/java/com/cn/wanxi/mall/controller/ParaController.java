package com.cn.wanxi.mall.controller;


import com.cn.wanxi.mall.bean.Para;
import com.cn.wanxi.mall.service.ParaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LiRui
 * @since 2019-11-22
 */
@RestController
@RequestMapping("/para")
public class ParaController {

    @Autowired
    private ParaService ps;

    @PostMapping("add")
    public Map<String,String> add(HttpServletRequest request){
        String name = request.getParameter("name");
        String options = request.getParameter("options");
        String seq1 = request.getParameter("seq");
        String templateId1 = request.getParameter("templateId");
        Map<String, String> add = new HashMap<>(16);
        if (name==null||options==null||seq1==null||templateId1==null){
            add.put("code","1");
            add.put("message","请填写完整参数");
            return add;
        }
        int seq = Integer.parseInt(seq1);
        int templateId = Integer.parseInt(templateId1);
        Para para = new Para(name,options,seq,templateId);
        return ps.add(para);
    }

    @PostMapping("update")
    public Map<String,String> update(HttpServletRequest request){
        Map<String, String> update = new HashMap<>(16);
        String name = request.getParameter("name");
        String options = request.getParameter("options");
        String seq1 = request.getParameter("seq");
        String templateId1 = request.getParameter("template_id");
        String ids = request.getParameter("id");
        Map<String, String> add = new HashMap<>(16);
        if (name==null||options==null||seq1==null||templateId1==null||ids==null){
            add.put("code","1");
            add.put("message","请填写完整参数");
            return add;
        }
        int seq = Integer.parseInt(seq1);
        int templateId = Integer.parseInt(templateId1);
        int id = Integer.parseInt(ids);
        Para para = new Para(id, name, options, seq, templateId);
        return ps.update(para);
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
        return ps.delete(id);
    }

    @GetMapping("findAll")
    public List<Para> findAll() {
        return ps.findAll();
    }

    @GetMapping("findCondPage")
    public Map<String,Object> findCondPage(HttpServletRequest request){
        String name = request.getParameter("name");
        String options = request.getParameter("options");
        String pages = request.getParameter("page");
        String sizes = request.getParameter("size");
        if (name==null||options==null){
            HashMap<String, Object> map = new HashMap<>(16);
            map.put("message","缺少参数，请输入完整");
            return map;
        }
        int page=pages==null?1:Integer.parseInt(pages);
        int size=sizes==null?4:Integer.parseInt(sizes);
        return ps.findCondPage(name,options,page,size);
    }
}

