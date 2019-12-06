package com.cn.wanxi.mall.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cn.wanxi.mall.bean.Para;
import com.cn.wanxi.mall.bean.Template;
import com.cn.wanxi.mall.service.ParaService;
import com.cn.wanxi.mall.service.TemplateService;
import com.cn.wanxi.mall.dao.ParaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LiRui
 * @since 2019-11-22
 */
@Service
public class ParaServiceImpl extends ServiceImpl<ParaMapper, Para> implements ParaService {

    @Autowired
    TemplateService ts;
    /**
     * <p>
     * 添加参数
     * </p>
     *
     * @param para 参数对象
     * @return map信息
     */
    @Override
    public Map<String, String> add(Para para) {
        Map<String, String> m = new HashMap<>(16);
        EntityWrapper<Para> wrapper = new EntityWrapper<>();
        List<Para> templates = this.selectList(
                wrapper.eq("name", para.getName())
                        .eq("options", para.getOptions())
                        .eq("seq", para.getSeq())
                        .eq("template_id",para.getTemplateId()));
        if (templates.size()!=0) {
            //添加失败
            m.put("code", "1");
            m.put("message", "该模块名已存在！");
            return m;
        }
        boolean insert = this.insert(para);
        if (insert) {
            Template template = ts.selectById(para.getTemplateId());
            template.setSpecNum(template.getParaNum()+1);
            ts.update(template);
            //添加成功
            m.put("code", "0");
            m.put("message", "添加成功");
        }else {
            m.put("code", "1");
            m.put("message", "添加失败");
        }
        return m;
    }

    /**
     * <p>
     * 修改参数
     * </p>
     *
     * @param para 参数对象
     * @return map信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, String> update(Para para) {
        Map<String, String> m = new HashMap<>(16);
        Para para1 = this.selectById(para.getId());
        if (para1 == null) {
            m.put("code", "1");
            m.put("message", "该模版不存在！");
            return m;
        }
        para.setId(para1.getId());
        if (!para1.getTemplateId().equals(para.getTemplateId())){
            Template template = new Template();

            try {
                Template template1 = ts.selectById(para1.getTemplateId());
                Template template2 = ts.selectById(para.getTemplateId());

                template.setId(para1.getTemplateId());
                template.setParaNum(template1.getParaNum()-1);

                ts.updateById(template);

                template.setId(para.getTemplateId());
                template.setParaNum(template2.getParaNum()+1);

                ts.updateById(template);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        boolean b = this.updateById(para);
        if (b){
            m.put("code", "0");
            m.put("message", "修改成功");
        }else {
            m.put("code", "1");
            m.put("message", "修改失败");
        }
        return m;
    }

    /**
     * <p>
     * 删除参数
     * </p>
     *
     * @param id 参数id
     * @return map信息
     */
    @Override
    public Map<String, String> delete(Integer id) {
        boolean b = this.deleteById(id);
        Map<String, String> delete = new HashMap<>(16);
        Para para = this.selectById(id);
        if(para==null){
            delete.put("code", "1");
            delete.put("message", "删除失败,该参数不存在");
            return delete;
        }
        if (!b) {
            delete.put("code", "1");
            delete.put("message", "删除失败");
            return delete;
        }
        Template template = ts.selectById(para.getTemplateId());
        template.setSpecNum(template.getParaNum()-1);
        ts.update(template);
        delete.put("code", "0");
        delete.put("message", "删除成功");

        return delete;
    }

    /**
     * <p>
     * 查询所有
     * </p>
     *
     * @return 参数集合
     */
    @Override
    public List<Para> findAll() {
        return this.selectList(null);
    }

    /**
     * <p>
     * 分页
     * </p>
     *
     * @param name    参数名字
     * @param options 参数选项
     * @param page    起始页
     * @param size    每页数据
     * @return map信息
     */
    @Override
    public Map<String, Object> findCondPage(String name, String options, int page, int size) {
        Map<String, Object> find = new HashMap<>(16);

        Page<Para> page1 = new Page<>(page, size);
        EntityWrapper<Para> w = new EntityWrapper<>();
        Page<Para> name1;
        long count;
        if (name!=null) {
            name1 = this.selectPage(page1, w.eq("name", name).eq("options",options));
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
