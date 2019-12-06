package com.cn.wanxi.mall.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author LiRui
 * @since 2019-11-22
 */
@TableName("wx_tab_category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品分类id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 商品数量
     */
    private Integer goodsNum;
    /**
     * 是否显示（一个字符）
     */
    private String isShow;
    /**
     * 是否导航（一个字符）
     */
    private String isMenu;
    /**
     * 排序
     */
    private Integer seq;
    /**
     * 上级ID
     */
    private Integer parentId;
    /**
     * 模版id
     */
    private Integer templateId;

    public Category(String name, Integer goodsNum, String isShow, String isMenu, Integer seq, Integer parentId, Integer templateId) {
        this.name = name;
        this.goodsNum = goodsNum;
        this.isShow = isShow;
        this.isMenu = isMenu;
        this.seq = seq;
        this.parentId = parentId;
        this.templateId = templateId;
    }


    public Category(Integer id, String name, Integer goodsNum, String isShow, String isMenu, Integer seq, Integer parentId, Integer templateId) {
        this.id = id;
        this.name = name;
        this.goodsNum = goodsNum;
        this.isShow = isShow;
        this.isMenu = isMenu;
        this.seq = seq;
        this.parentId = parentId;
        this.templateId = templateId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(String isMenu) {
        this.isMenu = isMenu;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    @Override
    public String toString() {
        return "Category{" +
        "id=" + id +
        ", name=" + name +
        ", goodsNum=" + goodsNum +
        ", isShow=" + isShow +
        ", isMenu=" + isMenu +
        ", seq=" + seq +
        ", parentId=" + parentId +
        ", templateId=" + templateId +
        "}";
    }
}
