package com.cn.wanxi.mall.bean.dto;

import java.io.Serializable;

/**
 * @Author: LucioWade
 * @Date: 9:46 2019/12/9
 */
public class ResultDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;

    private String message;

    public ResultDTO() {
    }

    public ResultDTO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultDTO success(String message) {
        return new ResultDTO(0, message);
    }

    public ResultDTO failure(String message) {
        return new ResultDTO(1, message);
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

}
