package com.cn.wanxi.mall.bean.vo;

/**
 * @Description: TODO 条件菜单列表实体“其实我也不知道是什么鬼”
 * @ClassName: CondPageVo
 * @Author: Mr.WuGuo
 * @Date: 2019/12/5 16:23
 */
public class CondPageVo {

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 页码
     */
    private Integer page;

    /**
     * 每页记录数
     */
    private Integer size;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
