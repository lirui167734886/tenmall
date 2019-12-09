package com.cn.wanxi.mall.exception;

/**
 * @Author: LucioWade
 * @Date: 9:47 2019/12/9
 */
public class FileException extends RuntimeException {

    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }

}
