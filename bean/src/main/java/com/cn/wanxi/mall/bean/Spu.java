package com.cn.wanxi.mall.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author LiRui
 * @since 2019-11-22
 */
@TableName("wx_tab_spu")
public class Spu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * SPU的ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 货号
     */
    private String sn;
    /**
     * SPU名
     */
    private String name;
    /**
     * 副标题
     */
    private String caption;
    /**
     * 品牌id
     */
    private Integer brandId;
    /**
     * 一级分类
     */
    private Integer category1Id;
    /**
     * 二级分类
     */
    private Integer category2Id;
    /**
     * 三级分类
     */
    private Integer category3Id;
    /**
     * 模版id
     */
    private Integer templateId;
    /**
     * 运费模版id
     */
    private Integer freightId;
    /**
     * 图片
     */
    private String image;
    /**
     * 图片列表
     */
    private String images;
    /**
     * 售后服务
     */
    private String saleService;
    /**
     * 介绍
     */
    private String introduction;
    /**
     * 规格列表
     */
    private String specItems;
    /**
     * 参数列表
     */
    private String paraItems;
    /**
     * 销量
     */
    private Integer saleNum;
    /**
     * 评论数
     */
    private Integer commentNum;
    /**
     * 是否上架（一个字符）
     */
    private String isMarketable;
    /**
     * 是否启用规格（一个字符）
     */
    private String isEnableSpec;
    /**
     * 是否删除（一个字符）
     */
    private String isDelete;
    /**
     * 审核状态（一个字符）
     */
    private String status;

    /**
     * sku列表
     */
    @TableField(exist = false)
    private List<Sku> skuList;

    public Spu() {
    }

    public Spu(String sn, String name, String caption,
               Integer brandId, Integer category1Id,
               Integer category2Id, Integer category3Id,
               Integer templateId, Integer freightId,
               String image, String images, String saleService,
               String introduction, String specItems, String paraItems,
               Integer saleNum, Integer commentNum, String isMarketable,
               String isEnableSpec, String isDelete, String status,
               List<Sku> skuList) {
        this.sn = sn;
        this.name = name;
        this.caption = caption;
        this.brandId = brandId;
        this.category1Id = category1Id;
        this.category2Id = category2Id;
        this.category3Id = category3Id;
        this.templateId = templateId;
        this.freightId = freightId;
        this.image = image;
        this.images = images;
        this.saleService = saleService;
        this.introduction = introduction;
        this.specItems = specItems;
        this.paraItems = paraItems;
        this.saleNum = saleNum;
        this.commentNum = commentNum;
        this.isMarketable = isMarketable;
        this.isEnableSpec = isEnableSpec;
        this.isDelete = isDelete;
        this.status = status;
        this.skuList=skuList;
    }

    public Spu(Integer id, String sn, String name, String caption, Integer brandId, Integer category1Id, Integer category2Id, Integer category3Id, Integer templateId, Integer freightId, String image, String images, String saleService, String introduction, String specItems, String paraItems, Integer saleNum, Integer commentNum, String isMarketable, String isEnableSpec, String isDelete, String status) {
        this.id = id;
        this.sn = sn;
        this.name = name;
        this.caption = caption;
        this.brandId = brandId;
        this.category1Id = category1Id;
        this.category2Id = category2Id;
        this.category3Id = category3Id;
        this.templateId = templateId;
        this.freightId = freightId;
        this.image = image;
        this.images = images;
        this.saleService = saleService;
        this.introduction = introduction;
        this.specItems = specItems;
        this.paraItems = paraItems;
        this.saleNum = saleNum;
        this.commentNum = commentNum;
        this.isMarketable = isMarketable;
        this.isEnableSpec = isEnableSpec;
        this.isDelete = isDelete;
        this.status = status;
    }

    public boolean getCID(Spu spu){
        if (spu.getSn()==null){
            return false;
        }
        if (spu.getName()==null){
            return false;
        }
        if (spu.getCaption()==null){
            return false;
        }
        if (spu.getImage()==null){
            return false;
        }
        if (spu.getImages()==null){
            return false;
        }
        if (spu.getIntroduction()==null){
            return false;
        }
        if (spu.getSkuList()==null){
            return false;
        }
        return true;
    }
    public boolean getAll(Spu spu){
        if (spu.getId()==null){
            return false;
        }
        if (spu.getSn()==null){
            return false;
        }
        if (spu.getName()==null){
            return false;
        }
        if (spu.getCaption()==null){
            return false;
        }
        if (spu.getImage()==null){
            return false;
        }
        if (spu.getImages()==null){
            return false;
        }
        if (spu.getIntroduction()==null){
            return false;
        }
        if (spu.getSkuList()==null){
            return false;
        }
        return true;
    }

    public List<Sku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<Sku> skuList) {
        this.skuList = skuList;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getCategory1Id() {
        return category1Id;
    }

    public void setCategory1Id(Integer category1Id) {
        this.category1Id = category1Id;
    }

    public Integer getCategory2Id() {
        return category2Id;
    }

    public void setCategory2Id(Integer category2Id) {
        this.category2Id = category2Id;
    }

    public Integer getCategory3Id() {
        return category3Id;
    }

    public void setCategory3Id(Integer category3Id) {
        this.category3Id = category3Id;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public Integer getFreightId() {
        return freightId;
    }

    public void setFreightId(Integer freightId) {
        this.freightId = freightId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getSaleService() {
        return saleService;
    }

    public void setSaleService(String saleService) {
        this.saleService = saleService;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getSpecItems() {
        return specItems;
    }

    public void setSpecItems(String specItems) {
        this.specItems = specItems;
    }

    public String getParaItems() {
        return paraItems;
    }

    public void setParaItems(String paraItems) {
        this.paraItems = paraItems;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public String getIsMarketable() {
        return isMarketable;
    }

    public void setIsMarketable(String isMarketable) {
        this.isMarketable = isMarketable;
    }

    public String getIsEnableSpec() {
        return isEnableSpec;
    }

    public void setIsEnableSpec(String isEnableSpec) {
        this.isEnableSpec = isEnableSpec;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Spu{" +
        "id=" + id +
        ", sn=" + sn +
        ", name=" + name +
        ", caption=" + caption +
        ", brandId=" + brandId +
        ", category1Id=" + category1Id +
        ", category2Id=" + category2Id +
        ", category3Id=" + category3Id +
        ", templateId=" + templateId +
        ", freightId=" + freightId +
        ", image=" + image +
        ", images=" + images +
        ", saleService=" + saleService +
        ", introduction=" + introduction +
        ", specItems=" + specItems +
        ", paraItems=" + paraItems +
        ", saleNum=" + saleNum +
        ", commentNum=" + commentNum +
        ", isMarketable=" + isMarketable +
        ", isEnableSpec=" + isEnableSpec +
        ", isDelete=" + isDelete +
        ", status=" + status +
        "}";
    }

    public static boolean isNull(Spu spu){
        if (spu!=null){
            return true;
        }
        return false;
    }
}
