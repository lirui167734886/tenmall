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
 * @since 2019-11-21
 */
@TableName("wx_tab_template")
public class Template implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 模版id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 模版名称
     */
    private String name;
    /**
     * 规格数量
     */
    private Integer specNum;
    /**
     * 参数数量
     */
    private Integer paraNum;


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

    public Integer getSpecNum() {
        return specNum;
    }

    public void setSpecNum(Integer specNum) {
        this.specNum = specNum;
    }

    public Integer getParaNum() {
        return paraNum;
    }

    public void setParaNum(Integer paraNum) {
        this.paraNum = paraNum;
    }

    @Override
    public String toString() {
        return "Template{" +
                "id=" + id +
        ", name=" + name +
        ", specNum=" + specNum +
        ", paraNum=" + paraNum +
        "}";
    }
}
