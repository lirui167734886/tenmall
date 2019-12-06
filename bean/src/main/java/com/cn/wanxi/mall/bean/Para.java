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
@TableName("wx_tab_para")
public class Para implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 参数id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 参数名称
     */
    private String name;
    /**
     * 参数选项
     */
    private String options;
    /**
     * 参数排序
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
        return "Para{" +
        "id=" + id +
        ", name=" + name +
        ", options=" + options +
        ", seq=" + seq +
        ", templateId=" + templateId +
        "}";
    }

    public Para(String name, String options, Integer seq, Integer templateId) {
        this.name = name;
        this.options = options;
        this.seq = seq;
        this.templateId = templateId;
    }

    public Para(Integer id, String name, String options, Integer seq, Integer templateId) {
        this.id = id;
        this.name = name;
        this.options = options;
        this.seq = seq;
        this.templateId = templateId;
    }
}
