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
@TableName("wx_tab_order_config")
public class OrderConfig  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 正常订单超时时间（分）
     */
    private Integer orderTimeout;

    /**
     * 秒杀订单超时时间（分）
     */
    private Integer seckillTimeout;

    /**
     * 自动收货（天）
     */
    private Integer takeTimeout;

    /**
     * 售后期限
     */
    private Integer serviceTimeout;

    /**
     * 自动五星好评
     */
    private Integer commentTimeout;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getOrderTimeout() {
        return orderTimeout;
    }

    public void setOrderTimeout(Integer orderTimeout) {
        this.orderTimeout = orderTimeout;
    }
    public Integer getSeckillTimeout() {
        return seckillTimeout;
    }

    public void setSeckillTimeout(Integer seckillTimeout) {
        this.seckillTimeout = seckillTimeout;
    }
    public Integer getTakeTimeout() {
        return takeTimeout;
    }

    public void setTakeTimeout(Integer takeTimeout) {
        this.takeTimeout = takeTimeout;
    }
    public Integer getServiceTimeout() {
        return serviceTimeout;
    }

    public void setServiceTimeout(Integer serviceTimeout) {
        this.serviceTimeout = serviceTimeout;
    }
    public Integer getCommentTimeout() {
        return commentTimeout;
    }

    public void setCommentTimeout(Integer commentTimeout) {
        this.commentTimeout = commentTimeout;
    }


    @Override
    public String toString() {
        return "OrderConfig{" +
        "id=" + id +
        ", orderTimeout=" + orderTimeout +
        ", seckillTimeout=" + seckillTimeout +
        ", takeTimeout=" + takeTimeout +
        ", serviceTimeout=" + serviceTimeout +
        ", commentTimeout=" + commentTimeout +
        "}";
    }
}
