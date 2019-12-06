package com.cn.wanxi.mall.bean;

import java.io.Serializable;

/**
 * @Author: LucioWade
 * @Date: 17:42 2019/11/26
 */

public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String image;

    private Character letter;

    private Integer seq;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Character getLetter() {
        return letter;
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
