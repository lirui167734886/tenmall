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
 * @author LiRui
 * @since 2019-11-22
 */
@TableName("wx_tab_album")
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 相册id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 相册名称
     */
    private String title;
    /**
     * 相册封面
     */
    private String image;
    /**
     * 图片列表
     */
    private String imageItems;

    public Album(Long id, String title, String image, String imageItems) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.imageItems = imageItems;
    }

    public Album(String title, String image, String imageItems) {
        this.title = title;
        this.image = image;
        this.imageItems = imageItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageItems() {
        return imageItems;
    }

    public void setImageItems(String imageItems) {
        this.imageItems = imageItems;
    }

    @Override
    public String toString() {
        return "Album{" +
        "id=" + id +
        ", title=" + title +
        ", image=" + image +
        ", imageItems=" + imageItems +
        "}";
    }
}
