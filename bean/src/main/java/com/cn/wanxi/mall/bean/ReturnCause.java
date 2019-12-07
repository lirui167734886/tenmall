package com.cn.wanxi.mall.bean;



import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 车元朴
 * @since 2019-11-26
 */
@TableName("wx_tab_return_cause")
public class ReturnCause implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer id;

    /**
     * 原因
     */
    private String cause;

    /**
     * 排序
     */
    private Integer seq;

    /**
     * 是否启用
     */
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "ReturnCause{" +
        "id=" + id +
        ", cause=" + cause +
        ", seq=" + seq +
        ", status=" + status +
        "}";
    }
}
