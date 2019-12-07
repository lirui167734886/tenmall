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
@TableName("wx_tab_return_order")
public class ReturnOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 服务单号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 申请时间
     */
    private LocalDateTime applyTime;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 联系人
     */
    private String linkman;

    /**
     * 联系人手机
     */
    private String linkmanMobile;

    /**
     * 1.退货 2.退款
     */
    private String 联系人手机;

    /**
     * 退款金额
     */
    private Integer returnMoney;

    /**
     * 是否退运费
     */
    private String isReturnFreight;

    /**
     * 申请状态 0：申请 1同意 2驳回
     */
    private String status;

    /**
     * 处理时间
     */
    private LocalDateTime disposeTime;

    /**
     * 退货退款原因
     */
    private String returnCause;

    /**
     * 凭证图片
     */
    private String evidence;

    /**
     * 问题描述
     */
    private String description;

    /**
     * 处理备注
     */
    private String remark;

    /**
     * 管理员id
     */
    private Integer adminId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public LocalDateTime getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(LocalDateTime applyTime) {
        this.applyTime = applyTime;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }
    public String getLinkmanMobile() {
        return linkmanMobile;
    }

    public void setLinkmanMobile(String linkmanMobile) {
        this.linkmanMobile = linkmanMobile;
    }
    public String get联系人手机() {
        return 联系人手机;
    }

    public void set联系人手机(String 联系人手机) {
        this.联系人手机 = 联系人手机;
    }
    public Integer getReturnMoney() {
        return returnMoney;
    }

    public void setReturnMoney(Integer returnMoney) {
        this.returnMoney = returnMoney;
    }
    public String getIsReturnFreight() {
        return isReturnFreight;
    }

    public void setIsReturnFreight(String isReturnFreight) {
        this.isReturnFreight = isReturnFreight;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDateTime getDisposeTime() {
        return disposeTime;
    }

    public void setDisposeTime(LocalDateTime disposeTime) {
        this.disposeTime = disposeTime;
    }
    public String getReturnCause() {
        return returnCause;
    }

    public void setReturnCause(String returnCause) {
        this.returnCause = returnCause;
    }
    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }


    @Override
    public String toString() {
        return "ReturnOrder{" +
        "id=" + id +
        ", orderId=" + orderId +
        ", applyTime=" + applyTime +
        ", userId=" + userId +
        ", userAccount=" + userAccount +
        ", linkman=" + linkman +
        ", linkmanMobile=" + linkmanMobile +
        ", 联系人手机=" + 联系人手机 +
        ", returnMoney=" + returnMoney +
        ", isReturnFreight=" + isReturnFreight +
        ", status=" + status +
        ", disposeTime=" + disposeTime +
        ", returnCause=" + returnCause +
        ", evidence=" + evidence +
        ", description=" + description +
        ", remark=" + remark +
        ", adminId=" + adminId +
        "}";
    }
}
