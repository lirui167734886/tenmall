package com.cn.wanxi.mall.bean.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: LucioWade
 * @Date: 9:45 2019/12/9
 */
public class PageDTO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<T> rows;

    private Integer total;

    public PageDTO() {
    }

    public PageDTO(List<T> rows, Integer total) {
        this.rows = rows;
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PageDTO{" +
                "rows=" + rows +
                ", total=" + total +
                '}';
    }
}
