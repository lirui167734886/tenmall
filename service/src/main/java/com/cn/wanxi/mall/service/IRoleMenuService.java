package com.cn.wanxi.mall.service;

import com.baomidou.mybatisplus.service.IService;
import com.cn.wanxi.mall.bean.RoleMenu;

import java.util.Map;

/**
 * <p>
 * 角色菜单中间表 服务类
 * </p>
 *
 * @author Mr.WuGuo
 * @since 2019-11-27
 */
public interface IRoleMenuService extends IService<RoleMenu> {

    /**
     * @Description: //TODO 角色与菜单关联新增
     * @Param: [roleId, menuId]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 9:36 2019/12/7
     **/
    Map<String, Object> roleMenuAdd(RoleMenu roleMenu);


    /**
     * @Description: //TODO 角色与菜单关联取消
     * @Param: [roleId, menuId]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 9:37 2019/12/7
     **/
    Map<String, Object> roleMenuRemove(RoleMenu roleMenu);
}
