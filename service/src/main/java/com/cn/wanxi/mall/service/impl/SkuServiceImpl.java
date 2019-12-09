package com.cn.wanxi.mall.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cn.wanxi.mall.bean.Sku;
import com.cn.wanxi.mall.dao.SkuMapper;
import com.cn.wanxi.mall.service.SkuService;
import org.springframework.stereotype.Service;

import java.util.Date;
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
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements SkuService {

    /**
     * <p>
     * 添加sku
     * </p>
     *
     * @param sku sku对象
     * @return map信息
     */
    @Override
    public Map<String, String> add(Sku sku) {
        Map<String, String> map = new HashMap<>(16);
        List<Sku> skus = this.selectList(new EntityWrapper<Sku>().eq("sn", sku.getSn()).eq("name", sku.getName()));
        if (skus.size() != 0) {
            map.put("code", "1");
            map.put("message", "添加的sku已存在");
            return map;
        }
        sku.setCreateTime(new Date());
        sku.setUpdateTime(new Date());
        sku.setSaleNum(0);
        sku.setCommentNum(0);
        boolean insert = this.insert(sku);
        if (insert) {
            map.put("code", "0");
            map.put("message", "添加成功");
            return map;
        }
        map.put("code", "1");
        map.put("message", "添加失败");
        return map;
    }

    /**
     * <p>
     * 修改sku
     * </p>
     *
     * @param sku sku对象
     * @return map信息
     */
    @Override
    public Map<String, String> update(Sku sku) {
        Map<String, String> map = new HashMap<>(16);
        Sku sku1 = this.selectById(sku.getId());
        if (sku1 == null) {
            map.put("code", "1");
            map.put("message", "修改的sku不存在");
            return map;
        }
        boolean b = this.updateById(sku);
        if (b) {
            map.put("code", "0");
            map.put("message", "修改成功");
            return map;
        }
        map.put("code", "1");
        map.put("message", "修改失败");
        return map;
    }

    /**
     * <p>
     * 删除sku
     * </p>
     *
     * @param id
     * @return
     */
    @Override
    public Map<String, String> delete(Integer id) {
        Map<String, String> delete = new HashMap<>(16);
        EntityWrapper<Sku> wrapper = new EntityWrapper<>();
        Sku sku = this.selectById(id);
        if (sku == null) {
            delete.put("code", "1");
            delete.put("message", "删除的sku不存在");
            return delete;
        }
        boolean b = this.deleteById(id);
        if (b){
            delete.put("code", "0");
            delete.put("message", "删除成功");
            return delete;
        }
        delete.put("code","1");
        delete.put("message","删除失败");
        return delete;
}

    /**
     * <p>
     * 根据id查询sku
     * </p>
     *
     * @param id id
     * @return map信息
     */
    @Override
    public Map<String, Object> findById(Integer id) {
        Map<String, Object> map = new HashMap<>(16);
        Sku sku = this.selectById(id);
        if (sku==null){
            map.put("message","没有这个id");
        }
        map.put("sku",sku);
        return map;
    }
}
