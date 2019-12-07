package com.cn.wanxi.mall.bean;



import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author 车元朴
 * @since 2019-11-26
 */
@TableName("wx_tab_category_report")
public class CategoryReport implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("category_id1")
    private Integer categoryId1;

    /**
     * 主键
     */

    private Integer categoryId2;

    /**
     * 主键
     */

    private Integer categoryId3;

    /**
     * 统计日期
     */

    private LocalDateTime countDate;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 金额
     */
    private Integer money;

    public Integer getCategoryId1() {
        return categoryId1;
    }

    public void setCategoryId1(Integer categoryId1) {
        this.categoryId1 = categoryId1;
    }
    public Integer getCategoryId2() {
        return categoryId2;
    }

    public void setCategoryId2(Integer categoryId2) {
        this.categoryId2 = categoryId2;
    }
    public Integer getCategoryId3() {
        return categoryId3;
    }

    public void setCategoryId3(Integer categoryId3) {
        this.categoryId3 = categoryId3;
    }
    public LocalDateTime getCountDate() {
        return countDate;
    }

    public void setCountDate(LocalDateTime countDate) {
        this.countDate = countDate;
    }
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }


    @Override
    public String toString() {
        return "CategoryReport{" +
        "categoryId1=" + categoryId1 +
        ", categoryId2=" + categoryId2 +
        ", categoryId3=" + categoryId3 +
        ", countDate=" + countDate +
        ", num=" + num +
        ", money=" + money +
        "}";
    }
}
