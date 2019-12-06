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
@TableName("wx_tab_spec")
public class Spec implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 规格id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 规格名称
     */
    private String name;
    /**
     * 规格选项
     */
    private String options;
    /**
     * 规格排序
     */
    private Integer seq;
    /**
     * 模版id
     */
    private Integer templateId;


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

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    @Override
    public String toString() {
        return "Spec{"+
        "id=" + id +
        ", name=" + name +
        ", options=" + options +
        ", seq=" + seq +
        ", templateId=" + templateId +
        "}";
    }
}
