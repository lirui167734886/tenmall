package com.cn.wanxi.mall.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cn.wanxi.mall.bean.Template;
import com.cn.wanxi.mall.dao.TemplateMapper;
import com.cn.wanxi.mall.service.TemplateService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LiRui
 * @since 2019-11-21
 */
@Service
public class TemplateServiceImpl extends ServiceImpl<TemplateMapper, Template> implements TemplateService {


    /**
     * <p>
     * 添加（模版名字必有）
     * </p>
     *
     * @param template 模版对象
     * @return map的key为code map的value数据库不存在这个模版名字；map的key为message1：存在
     */
    @Override
    public Map<String, String> add(Template template) {
        Map<String, String> m = new HashMap<>(16);
        EntityWrapper<Template> wrapper = new EntityWrapper<>();
        List<Template> templates = this.selectList(
                wrapper.eq("name", template.getName()));
        if (templates.size()!=0) {
            //添加失败
            m.put("code", "1");
            m.put("message", "该模块名已存在！");
            return m;
        }
        template.setSpecNum(0);
        template.setParaNum(0);
        boolean insert = this.insert(template);
        if (insert) {
            //添加成功
            m.put("code", "0");
            m.put("message", "添加成功");
        } else {
            m.put("code", "1");
            m.put("message", "添加失败");
        }
        return m;
    }

    /**
     * <p>
     * 修改（模版必有）
     * </p>
     *
     * @param template 模版对象
     * @return map信息
     */
    @Override
    public Map<String, String> update(Template template) {
        Map<String, String> m = new HashMap<>(16);
        Template template1 = this.selectById(template.getId());
        if (template1 == null) {
            m.put("code", "1");
            m.put("message", "该模版不存在！");
            return m;
        }
        if (template.getParaNum() == 0) {
            template.setParaNum(template1.getParaNum());
        }
        if (template.getSpecNum() == 0) {
            template.setSpecNum(template1.getSpecNum());
        }
        boolean b = this.updateById(template);
        if (b) {
            m.put("code", "0");
            m.put("message", "修改成功");
        }else {
            m.put("code", "1");
            m.put("message", "修改失败！");
            return m;
        }
        return m;
    }

    /**
     * <p>
     * 查询所有模版
     * </p>
     *
     * @return 所有集合
     */
    @Override
    public List<Template> findAll() {

        return this.selectList(null);
    }


    /**
     * <p>
     * 根据id删除
     * </p>
     *
     * @param id id
     * @return map信息
     */
    @Override
    public Map<String, String> delete(Integer id) {
        boolean b = this.deleteById(id);
        Map<String, String> delete = new HashMap<>(16);
        if (!b) {
            delete.put("code", "1");
            delete.put("message", "删除失败");
            return delete;
        }
        delete.put("code", "0");
        delete.put("message", "删除成功");

        return delete;
    }

    /**
     * <p>
     * 根据名字，页数，每页条数查询
     * </p>
     *
     * @param name 模版名字
     * @param page 当前页
     * @param size 每页条数
     * @return map信息
     */
    @Override
    public Map<String, Object> findCondPage(String name, int page, int size) {
        Map<String, Object> find = new HashMap<>(16);

        Page<Template> page1 = new Page<>(page, size);
        EntityWrapper<Template> w = new EntityWrapper<>();
        Page<Template> name1;
        long count;
        if (name!=null) {
            name1 = this.selectPage(page1, w.eq("name", name));
            count = name1.getTotal();
        }
        else {
            name1 = this.selectPage(page1);
            count = name1.getTotal();
        }
        find.put("total", count);
        find.put("rows", name1.getRecords());
        return find;
    }
}
