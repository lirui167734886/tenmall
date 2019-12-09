package com.cn.wanxi.mall.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 管理员角色用户中间表
 * </p>
 *
 * @author Mht
 * @since 2019-12-02
 */
@TableName("wx_tab_admin_role")
public class AdminRole extends Model<AdminRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 中间表ID
     */
    @TableId("admin_role_id")
    private Integer adminRoleId;

    /**
     * 管理员ID
     */
    @TableField("admin_id")
    private Integer adminId;

    /**
     * 角色ID
     */
    @TableField("role_id")
    private Integer roleId;

    public Integer getAdminRoleId() {
        return adminRoleId;
    }

    public void setAdminRoleId(Integer adminRoleId) {
        this.adminRoleId = adminRoleId;
    }
    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    protected Serializable pkVal() {
        return this.adminRoleId;
    }

    @Override
    public String toString() {
        return "AdminRole{" +
        "adminRoleId=" + adminRoleId +
        ", adminId=" + adminId +
        ", roleId=" + roleId +
        "}";
    }
}
