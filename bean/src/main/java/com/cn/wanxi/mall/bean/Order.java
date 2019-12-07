package com.cn.wanxi.mall.bean;



import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

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
@TableName("wx_tab_order")
public class Order  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 数量合计
     */

    private Integer totalNum;

    /**
     * 金额合计
     */

    private Integer totalMoney;

    /**
     * 优惠金额
     */

    private Integer preMoney;

    /**
     * 邮费
     */

    private Integer postFee;

    /**
     * 实付金额
     */

    private Integer payMoney;

    /**
     * 0、货到付款 1、微信支付，
     */

    private String payType;

    /**
     * 订单创建时间
     */

    private LocalDateTime createTime;

    /**
     * 订单更新时间
     */

    private LocalDateTime updateTime;

    /**
     * 付款时间
     */

    private LocalDateTime payTime;

    /**
     * 发货时间
     */

    private LocalDateTime consignTime;

    /**
     * 交易完成时间
     */

    private LocalDateTime endTime;

    /**
     * 交易关闭时间
     */

    private LocalDateTime closeTime;

    /**
     * 物流名称
     */

    private String shippingName;

    /**
     * 物流单号
     */

    private String shippingCode;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 买家留言
     */

    private String buyerMessage;

    /**
     * 是否评价
     */

    private String buyerRate;

    /**
     * 收货人
     */

    private String receiverContact;

    /**
     * 收货人手机
     */

    private String receiverMobile;

    /**
     * 收货人地址
     */

    private String receiverAddress;

    /**
     * 1:web，2：app，3：微信公众号，4：微信小程序 5 H5手机页面
     */

    private String sourceType;

    /**
     * 交易流水号
     */

    private String transactionId;

    /**
     * 0待付款、1待发货、2已发货、3已完成、4已关闭
     */
    private String orderStatus;

    /**
     * 0未支付、1已支付、2已退款
     */
    private String payStatus;

    /**
     * 0未发货、1已发货
     */
    private String consignStatus;

    /**
     * 0：未删除 1：已删除
     */
    private String isDelete;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }
    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }
    public Integer getPreMoney() {
        return preMoney;
    }

    public void setPreMoney(Integer preMoney) {
        this.preMoney = preMoney;
    }
    public Integer getPostFee() {
        return postFee;
    }

    public void setPostFee(Integer postFee) {
        this.postFee = postFee;
    }
    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }
    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    public LocalDateTime getPayTime() {
        return payTime;
    }

    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
    }
    public LocalDateTime getConsignTime() {
        return consignTime;
    }

    public void setConsignTime(LocalDateTime consignTime) {
        this.consignTime = consignTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public LocalDateTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalDateTime closeTime) {
        this.closeTime = closeTime;
    }
    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }
    public String getShippingCode() {
        return shippingCode;
    }

    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage;
    }
    public String getBuyerRate() {
        return buyerRate;
    }

    public void setBuyerRate(String buyerRate) {
        this.buyerRate = buyerRate;
    }
    public String getReceiverContact() {
        return receiverContact;
    }

    public void setReceiverContact(String receiverContact) {
        this.receiverContact = receiverContact;
    }
    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }
    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }
    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
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
    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }



    @Override
    public String toString() {
        return "Order{" +
        "id=" + id +
        ", totalNum=" + totalNum +
        ", totalMoney=" + totalMoney +
        ", preMoney=" + preMoney +
        ", postFee=" + postFee +
        ", payMoney=" + payMoney +
        ", payType=" + payType +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", payTime=" + payTime +
        ", consignTime=" + consignTime +
        ", endTime=" + endTime +
        ", closeTime=" + closeTime +
        ", shippingName=" + shippingName +
        ", shippingCode=" + shippingCode +
        ", username=" + username +
        ", buyerMessage=" + buyerMessage +
        ", buyerRate=" + buyerRate +
        ", receiverContact=" + receiverContact +
        ", receiverMobile=" + receiverMobile +
        ", receiverAddress=" + receiverAddress +
        ", sourceType=" + sourceType +
        ", transactionId=" + transactionId +
        ", orderStatus=" + orderStatus +
        ", payStatus=" + payStatus +
        ", consignStatus=" + consignStatus +
        ", isDelete=" + isDelete +
        "}";
    }
}
