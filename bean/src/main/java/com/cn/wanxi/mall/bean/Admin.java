package com.cn.wanxi.mall.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * @Description: TODO 管理员表
 * @ClassName: Admin
 * @Author: Mr.WuGuo
 * @Date: 2019/12/2 16:23
 */
@TableName("wx_tab_admin")
public class Admin extends Model<Admin> {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员ID
     */
    @TableId(value = "admin_id",type= IdType.AUTO)
    private Integer adminId;

    /**
     * 用户名
     */
    @TableField("login_name")
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态,0正常,1冻结,2删除
     */
    private String status;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.adminId;
    }

    @Override
    public String toString() {
        return "Admin{" +
        "adminId=" + adminId +
        ", loginName=" + loginName +
        ", password=" + password +
        ", status=" + status +
        "}";
    }
}
