package com.cn.wanxi.mall.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cn.wanxi.mall.bean.Spec;
import com.cn.wanxi.mall.bean.Template;
import com.cn.wanxi.mall.dao.SpecMapper;
import com.cn.wanxi.mall.service.SpecService;
import com.cn.wanxi.mall.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LiRui
 * @since 2019-11-22
 */
@Service
public class SpecServiceImpl extends ServiceImpl<SpecMapper, Spec> implements SpecService {

    @Autowired
    TemplateService ts;

    /**
     * <p>
     * 根据名字查询规格参数
     * </p>
     *
     * @param spec 规格参数对象
     * @return 规格参数集合
     */
    @Override
    public List<Spec> selectBySpec(Spec spec) {
        EntityWrapper<Spec> wrapper = new EntityWrapper<>();
        List<Spec> specs = this.selectList(wrapper
                .eq("name", spec.getName())
                .eq("options", spec.getOptions())
                .eq("seq", spec.getSeq())
                .eq("template_id", spec.getTemplateId()));
        return specs;
    }

    /**
     * <p>
     * 规格参数添加
     * </p>
     *
     * @param spec 规格参数对象
     * @return map信息
     */
    @Override
    public Map<String, String> add(Spec spec) {
        Map<String, String> map = new HashMap<>(16);
        List<Spec> specs = this.selectBySpec(spec);
        if (specs.size() != 0) {
            map.put("code", "1");
            map.put("message", "添加规格失败,已存在");
            return map;
        }
        boolean insert = this.insert(spec);
        if (insert) {
            Template template = ts.selectById(spec.getTemplateId());
            template.setSpecNum(template.getSpecNum() + 1);
            ts.update(template);
            map.put("code", "0");
            map.put("message", "添加规格成功！");
            return map;
        }
        map.put("code", "1");
        map.put("message", "添加规格失败");

        return map;
    }


    /**
     * <p>
     * 规格参数修改
     * </p>
     *
     * @param spec 规格参数对象
     * @return map信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, String> update(Spec spec) {
        Map<String, String> map = new HashMap<>(16);
        Spec spec1 = this.selectById(spec.getId());
        if (spec1 == null) {
            map.put("code", "1");
            map.put("message", "修改失败，没有该规格参数");
            return map;
        }
        if (!spec1.getTemplateId().equals(spec.getTemplateId())) {
            Template template = new Template();
            try {
                Template template1 = ts.selectById(spec1.getTemplateId());
                Template template2 = ts.selectById(spec.getTemplateId());

                template.setId(spec1.getTemplateId());
                template.setSpecNum(template1.getSpecNum() - 1);

                ts.updateById(template);

                template.setId(spec.getTemplateId());
                template.setSpecNum(template2.getSpecNum() + 1);
                ts.updateById(template);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        EntityWrapper<Spec> wrapper = new EntityWrapper<>();
        boolean update = this.update(spec, wrapper.eq("id", spec.getId()));
        if (update) {
            map.put("code", "0");
            map.put("message", "修改成功");
            return map;
        }
        map.put("code", "1");
        map.put("message", "修改失败，没有该规格参数");
        return map;
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
        Map<String, String> map = new HashMap<>(16);
        Spec spec = this.selectById(id);
        if (spec == null) {
            map.put("code", "1");
            map.put("message", "删除的规格不存在！");
            return map;
        }
        EntityWrapper<Spec> wrapper = new EntityWrapper<>();
        boolean id1 = this.delete(wrapper.eq("id", id));
        if (!id1) {
            map.put("code", "1");
            map.put("message", "删除失败！");
            return map;
        }
        Template template = ts.selectById(spec.getTemplateId());
        template.setSpecNum(template.getSpecNum() - 1);
        ts.update(template);
        map.put("code", "0");
        map.put("message", "删除成功！");
        return map;
    }

    /**
     * <p>
     * 查询所有
     * </p>
     *
     * @return 规格
     */
    @Override
    public List<Spec> findAll() {
        return this.selectList(null);
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
    public Map<String, Object> findCondPage(String name, String options, int page, int size) {
        Map<String, Object> find = new HashMap<>(16);

        Page<Spec> page1 = new Page<>(page, size);
        EntityWrapper<Spec> w = new EntityWrapper<>();
        Page<Spec> name1;
        long count;
        name1 = this.selectPage(page1, w.eq("name", name).eq("options", options));
        count = name1.getTotal();
        find.put("total", "" + count);
        find.put("rows", name1.getRecords());
        return find;
    }

}
