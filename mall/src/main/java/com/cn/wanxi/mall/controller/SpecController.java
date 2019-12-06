package com.cn.wanxi.mall.controller;

import com.cn.wanxi.mall.bean.Spec;
import com.cn.wanxi.mall.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/spec")
public class SpecController {
    @Autowired
    private SpecService ss;

    @PostMapping("add")
    public Map<String, String> add(ModelMap m, HttpServletResponse response, HttpServletRequest request) {
        String name = request.getParameter("name");
        String options = request.getParameter("options");
        String seq1 = request.getParameter("seq");
        String templateId1 = request.getParameter("template_id");
        Map<String, String> h = new HashMap<>(16);
        if (name == null || options == null || seq1 == null || templateId1 == null) {
            h.put("code", "1");
            h.put("message", "请完整添加规格参数！");
            return h;
        }
        Integer seq = Integer.parseInt(seq1);
        Integer templateId = Integer.parseInt(templateId1);
        Spec spec = new Spec();
        spec.setName(name);
        spec.setOptions(options);
        spec.setSeq(seq);
        spec.setTemplateId(templateId);

        return ss.add(spec);
    }

    @PostMapping("update")
    public Map<String, String> update(HttpServletRequest request) {
        String name = request.getParameter("name");
        String options = request.getParameter("options");
        String seq1 = request.getParameter("seq");
        String templateId1 = request.getParameter("template_id");
        String ids = request.getParameter("Id");
        Map<String, String> h = new HashMap<>(16);
        System.out.println(name + "__" + options + "__" + seq1 + "__" + templateId1 + "__" + ids);
        if (name == null || ids == null || seq1 == null || templateId1 == null || options == null) {
            h.put("code", "1");
            h.put("message", "请完整添加规格参数！");
            return h;
        }
        Spec spec = new Spec();
        Integer id = Integer.parseInt(ids);
        spec.setId(id);
        spec.setName(name);
        spec.setOptions(options);
        Integer seq = Integer.parseInt(seq1);
        spec.setSeq(seq);
        Integer templateId = Integer.parseInt(templateId1);
        spec.setTemplateId(templateId);

        return ss.update(spec);
    }

    @PostMapping("delete")
    public Map<String, String> delete(HttpServletRequest request) {
        Map<String, String> delete = new HashMap<>(16);
        String ids = request.getParameter("id");
        if (ids == null) {
            delete.put("code", "1");
            delete.put("message", "删除失败，没选id");
            return delete;
        }
        int id = Integer.parseInt(ids);

        return ss.delete(id);
    }

    @GetMapping("findAll")
    public List<Spec> findAll() {
        return ss.findAll();
    }

    @GetMapping("findCondPage")
    public Map<String, Object> findCondPage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String pages = request.getParameter("page");
        String sizes = request.getParameter("size");
        String options = request.getParameter("options");
        if (name == null || options == null) {
            HashMap<String, Object> map = new HashMap<>(16);
            map.put("message", "缺少参数，请输入完整");
            return map;
        }
        int page = pages == null ? 1 : Integer.parseInt(pages);
        int size = sizes == null ? 4 : Integer.parseInt(sizes);
        return ss.findCondPage(name, options, page, size);
    }
}
