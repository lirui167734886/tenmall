package com.cn.wanxi.mall.bean;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;

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
@TableName("wx_tab_order_log")
public class OrderLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 操作员
     */
    private String operater;

    /**
     * 操作时间
     */
    private LocalDateTime operateTime;

    /**
     * 订单ID
     */
    private String orderId;

    private String orderStatus;

    private String payStatus;

    private String consignStatus;

    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getOperater() {
        return operater;
    }

    public void setOperater(String operater) {
        this.operater = operater;
    }
    public LocalDateTime getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(LocalDateTime operateTime) {
        this.operateTime = operateTime;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }
    public String getConsignStatus() {
        return consignStatus;
    }

    public void setConsignStatus(String consignStatus) {
        this.consignStatus = consignStatus;
    }
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }



    @Override
    public String toString() {
        return "OrderLog{" +
        "id=" + id +
        ", operater=" + operater +
        ", operateTime=" + operateTime +
        ", orderId=" + orderId +
        ", orderStatus=" + orderStatus +
        ", payStatus=" + payStatus +
        ", consignStatus=" + consignStatus +
        ", remarks=" + remarks +
        "}";
    }
}
