package com.cn.wanxi.mall.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cn.wanxi.mall.bean.Sku;
import com.cn.wanxi.mall.bean.Spu;
import com.cn.wanxi.mall.dao.SpuMapper;
import com.cn.wanxi.mall.service.BrandService;
import com.cn.wanxi.mall.service.SkuService;
import com.cn.wanxi.mall.service.SpuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LiRui
 * @since 2019-11-22
 */
@Service
public class SpuServiceImpl extends ServiceImpl<SpuMapper, Spu> implements SpuService {

    @Resource
    private SkuService sks;

    @Resource
    private BrandService bs;

    /**
     * <p>
     * 添加spu
     * </p>
     *
     * @param spu spu对象
     * @return map信息
     */
    @Override
    public Map<String, String> add(Spu spu) {
        Map<String, String> map = new HashMap<>(16);
        List<Spu> sn = this.selectList(new EntityWrapper<Spu>().eq("sn", spu.getSn()).eq("name", spu.getName()));
        if (sn.size() != 0) {
            map.put("code", "1");
            map.put("message", "添加的商品已存在");
            return map;
        }
        boolean insert = this.insert(spu);
        if (insert) {
            map.put("code", "0");
            map.put("message", "添加商品成功");
            return map;
        }
        map.put("code", "1");
        map.put("message", "添加的商品已存在");
        return map;
    }

    /**
     * <p>
     * spu修改
     * </p>
     *
     * @param spu spu对象
     * @return map信息
     */
    @Override
    public Map<String, String> update(Spu spu) {
        Map<String, String> update = new HashMap<>(16);
        Spu spu1 = this.selectById(spu.getId());
        if (spu1 == null) {
            update.put("code", "1");
            update.put("message", "修改的spu不存在");
            return update;
        }
        boolean b = this.updateById(spu);
        if (b) {
            update.put("code", "0");
            update.put("message", "修改成功");
            return update;
        }
        update.put("code", "1");
        update.put("message", "修改失败");
        return update;
    }

    /**
     * <p>
     * 根据id删除
     * </p>
     *
     * @param id spu删除
     * @return map信息
     */
    @Override
    public Map<String, String> delete(Integer id) {
        Map<String, String> delete = new HashMap<>(16);
        EntityWrapper<Sku> wrapper = new EntityWrapper<>();
        boolean sku = sks.delete(wrapper.eq("spu_id", id));
        if (sku) {
            boolean b = this.deleteById(id);
            if (b) {
                delete.put("code", "0");
                delete.put("message", "删除成功");
                return delete;
            }
        }
        delete.put("code", "1");
        delete.put("message", "删除失败");
        return delete;
    }

    /**
     * <p>
     * 根据id查询
     * </p>
     *
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> findById(Integer id) {
        Map<String, Object> map = new HashMap<>(16);
        Spu spu = this.selectById(id);
        if (spu == null) {
            map.put("message", "没有这个id");
        }
        List<Sku> skus = sks.selectList(new EntityWrapper<Sku>().eq("spu_id", id));
        spu.setSkuList(skus);
        map.put("sku", spu);
        return map;
    }

    /**
     * <p>
     * 根据spu查所有sku
     * </p>
     *
     * @param spu
     * @param page
     * @param size
     * @return
     */
    @Override
    public Map<String, Object> findPage(Spu spu, Integer page, Integer size) {
        Map<String, Object> map = new HashMap<>(16);
        Page<Sku> skuPage = new Page<Sku>(page, size);
        Page<Sku> skus = null;
        EntityWrapper<Spu> wrapper = new EntityWrapper<>();
        EntityWrapper<Sku> wrapper1 = new EntityWrapper<>();
        List<Spu> spus = null;
        if (spu.getName() != null || spu.getSn() != null || spu.getId() != null) {
            spus = this.selectList(wrapper.ne(spu.getName() == null, "name", spu.getName())
                    .ne(spu.getSn() == null, "sn", spu.getSn())
                    .ne(spu.getId() == null, "id", spu.getId()));

            if (spus.size() != 0) {
                skus = sks.selectPage(skuPage,
                        wrapper1.eq("spu_id",
                                spus.stream().map(Spu::getId).collect(Collectors.toList())
                        ));
                map.put("rows", skus.getRecords());
                map.put("total", skus.getTotal());
                return map;
            }
        }
        skus = sks.selectPage(skuPage);
        map.put("rows", skus.getRecords());
        map.put("total", skus.getTotal());
        return map;
    }

    /**
     * <p>
     * SPU分页
     * </p>
     *
     * @param spu
     * @param page
     * @param size
     * @param brandName
     * @return
     */
    @Override
    public Map<String, Object> findSpuPage(Spu spu, Integer page, Integer size, String brandName) {
        Map<String, Object> map = new HashMap<>(16);
        Page<Spu> spuPage = new Page<Spu>(page, size);
        EntityWrapper<Spu> wrapper = new EntityWrapper<>();
        Page<Spu> spus;
        if (brandName != null) {
            spu.setBrandId(bs.selectOneByName(brandName));
        }
        if (spu.getName() != null || spu.getCaption() != null || spu.getBrandId() != null) {
            spus = this.selectPage(spuPage, wrapper.ne(spu.getName() == null, "name", spu.getName())
                    .ne(spu.getCaption() == null, "caption", spu.getCaption())
                    .ne(spu.getBrandId() == null, "brand_id", spu.getBrandId()));
            map.put("rows", spus.getRecords());
            map.put("total", spus.getTotal());
            return map;
        }
        spus = this.selectPage(spuPage);
        map.put("rows", spus.getRecords());
        map.put("total", spus.getTotal());
        return map;
    }

    /**
     * <p>
     * 审核
     * </p>
     *
     * @param id
     * @return
     */
    @Override
    public Map<String, String> submitReq(Integer id) {
        Map<String, String> map = new HashMap<>(16);
        Spu spu = this.selectById(id);
        spu.setStatus("9");
        boolean b = this.updateById(spu);
        if (b) {
            map.put("code", "0");
            map.put("message", "提交审核成功");
            return map;
        }
        map.put("code", "1");
        map.put("message", "提交审核失败");
        return map;
    }

    /**
     * <p>
     * 查看审核列表
     * </p>
     *
     * @param status
     * @param page
     * @param size
     * @return
     */
    @Override
    public Map<String, Object> findAuditALL(String status, Integer page, Integer size) {
        Map<String, Object> map = new HashMap<>(16);
        Page<Spu> spuPage = new Page<>(page, size);
        Page<Spu> spus = this.selectPage(spuPage, new EntityWrapper<Spu>().eq("status", status));
        map.put("rows", spus.getRecords());
        map.put("total", spus.getTotal());
        return map;
    }

    /**
     * <p>
     * 审核成功
     * </p>
     *
     * @param id
     * @return
     */
    @Override
    public Map<String, String> auditReq(Integer id) {
        Map<String, String> map = new HashMap<>(16);
        Spu spu = this.selectById(id);
        if (spu == null) {
            map.put("code", "1");
            map.put("message", "审核失败，没id");
            return map;
        }
        spu.setStatus("1");
        List<Sku> skus = sks.selectList(new EntityWrapper<Sku>().eq("spu_id", spu.getId()));
        List<Sku> skus1 = null;
        for (Sku s : skus) {
            s.setStatus("1");
            skus1.add(s);
        }
        boolean b = true;
        if (skus1 != null) {
            b = sks.updateAllColumnBatchById(skus1);
        }
        boolean b1 = this.updateById(spu);
        if (b && b1) {
            map.put("code", "0");
            map.put("message", "审核成功");
            return map;
        }
        map.put("code", "1");
        map.put("message", "审核失败");
        return map;
    }

    /**
     * <p>
     * 下架
     * </p>
     *
     * @param id
     * @return
     */
    @Override
    public Map<String, String> pullReq(Integer id) {
        Map<String, String> map = new HashMap<>(16);
        Sku sku = sks.selectById(id);
        if (sku == null) {
            map.put("code", "1");
            map.put("message", "下架失败，没id");
            return map;
        }
        sku.setStatus("3");
        boolean b = sks.updateById(sku);
        if (b) {
            map.put("code", "0");
            map.put("message", "下架成功");
            return map;
        }
        map.put("code", "1");
        map.put("message", "下架失败");
        return map;

    }

    /**
     * <p>
     * 上架
     * </p>
     *
     * @param id
     * @return
     */
    @Override
    public Map<String, String> shelvesReq(Integer id) {
        Map<String, String> map = new HashMap<>(16);
        Sku sku = sks.selectById(id);
        if (sku == null) {
            map.put("code", "1");
            map.put("message", "上架失败，没id");
            return map;
        }
        sku.setStatus("1");
        boolean b = sks.updateById(sku);
        if (b) {
            map.put("code", "0");
            map.put("message", "上架成功");
            return map;
        }
        map.put("code", "1");
        map.put("message", "上架失败");
        return map;
    }

    /**
     * <p>
     * 批量上架
     * </p>
     *
     * @param strings id的string集合
     * @return
     */
    @Override
    public Map<String, String> batchShelvesReq(List<String> strings) {
        Map<String, String> map = new HashMap<>(16);
        Integer id;
        for (String id0:strings) {
            id=Integer.parseInt(id0);
            Sku sku = sks.selectById(id);
            if (sku == null) {
                map.put("code", "1");
                map.put("message", id+"上架失败，没这个id");
                return map;
            }
            sku.setStatus("1");
            boolean b = sks.updateById(sku);
            if (!b) {
                map.put("code", "1");
                map.put("message", id+"上架失败");
                return map;
            }
            map.put("message", id+"上架成功");
        }
        map.put("code", "0");
        map.put("message", "全部上架成功");
        return map;
    }

    /**
     * <p>
     * 批量下架
     * </p>
     *
     * @param strings id的string集合
     * @return
     */
    @Override
    public Map<String, String> batchPullReq(List<String> strings) {
        Map<String, String> map = new HashMap<>(16);
        Integer id;
        for (String id0:strings) {
            id=Integer.parseInt(id0);
            Sku sku = sks.selectById(id);
            if (sku == null) {
                map.put("code", "1");
                map.put("message", id+"下架失败，没这个id");
                return map;
            }
            sku.setStatus("1");
            boolean b = sks.updateById(sku);
            if (!b) {
                map.put("code", "1");
                map.put("message", id+"下架失败");
                return map;
            }
            map.put("message", id+"下架成功");
        }
        map.put("code", "0");
        map.put("message", "全部下架成功");
        return map;
    }


}
