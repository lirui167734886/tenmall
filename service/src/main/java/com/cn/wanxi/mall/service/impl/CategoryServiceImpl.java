package com.cn.wanxi.mall.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cn.wanxi.mall.bean.Category;
import com.cn.wanxi.mall.service.CategoryService;
import com.cn.wanxi.mall.dao.CategoryMapper;
import org.springframework.stereotype.Service;

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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {


    /**
     * <p>
     * 添加商品分类
     * </p>
     *
     * @param category 分类实体
     * @return map信息
     */
    @Override
    public Map<String, String> add(Category category) {
        Map<String, String> m = new HashMap<>(16);
        EntityWrapper<Category> wrapper = new EntityWrapper<>();
        List<Category> templates = this.selectList(
                wrapper.eq("name", category.getName())
                        .eq("goods_num", category.getGoodsNum())
                        .eq("is_show", category.getIsShow())
                        .eq("is_menu",category.getIsMenu())
                        .eq("seq",category.getSeq())
                        .eq("parent_id",category.getParentId())
                        .eq("template_id",category.getTemplateId()));
        if (templates.size()!=0) {
            //添加失败
            m.put("code", "1");
            m.put("message", "该分类名已存在！");
            return m;
        }
        boolean insert = this.insert(category);
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
     * 修改商品分类
     * </p>
     *
     * @param category
     * @return
     */
    @Override
    public Map<String, String> update(Category category) {
        Map<String, String> m = new HashMap<>(16);
        Category category1 = this.selectById(category.getId());
        if (category1 == null) {
            m.put("code", "1");
            m.put("message", "该模版不存在！");
            return m;
        }
        boolean b = this.updateById(category);
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
     * 查询所有
     * </p>
     *
     * @return 分类集合
     */
    @Override
    public List<Category> findAll() {
        return this.selectList(null);
    }

    /**
     * <p>
     * 根据父级显示列表
     * </p>
     *
     * @param parentId 父级id
     * @return Category对象
     */
    @Override
    public Category findByParentId(int parentId) {
        return this.selectById(parentId);
    }

    /**
     * <p>
     * 根据id删除
     * </p>
     *
     * @param id
     * @return
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
}
