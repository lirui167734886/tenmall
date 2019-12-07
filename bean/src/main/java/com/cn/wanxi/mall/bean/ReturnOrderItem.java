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
 * @author 车元朴
 * @since 2019-11-26
 */
@TableName("wx_tab_return_order_item")
public class ReturnOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 分布式id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 分类ID
     */

    private Integer categoryId;

    /**
     * SPU_ID
     */

    private String spuId;

    /**
     * SKU_ID
     */

    private String skuId;

    /**
     * 订单ID
     */

    private String orderId;

    /**
     * 订单明细ID
     */

    private String orderItemId;

    /**
     * 退货订单ID
     */

    private String returnOrderId;

    /**
     * 标题
     */
    private String title;

    /**
     * 单价
     */
    private Integer price;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 总金额
     */
    private Integer money;

    /**
     * 支付金额
     */

    private Integer payMoney;

    /**
     * 图片地址
     */
    private String image;

    /**
     * 重量
     */
    private Integer weight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public String getSpuId() {
        return spuId;
    }

    public void setSpuId(String spuId) {
        this.spuId = spuId;
    }
    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }
    public String getReturnOrderId() {
        return returnOrderId;
    }

    public void setReturnOrderId(String returnOrderId) {
        this.returnOrderId = returnOrderId;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ReturnOrderItem{" +
        "id=" + id +
        ", categoryId=" + categoryId +
        ", spuId=" + spuId +
        ", skuId=" + skuId +
        ", orderId=" + orderId +
        ", orderItemId=" + orderItemId +
        ", returnOrderId=" + returnOrderId +
        ", title=" + title +
        ", price=" + price +
        ", num=" + num +
        ", money=" + money +
        ", payMoney=" + payMoney +
        ", image=" + image +
        ", weight=" + weight +
        "}";
    }
}
