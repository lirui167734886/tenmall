package com.cn.wanxi.mall.controller;


import com.cn.wanxi.mall.bean.RoleMenu;
import com.cn.wanxi.mall.service.IRoleMenuService;
import com.cn.wanxi.mall.utils.ReplyMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * <p>
 * 角色菜单中间表 前端控制器
 * </p>
 *
 * @author Mht
 * @since 2019-12-02
 */
@Controller
@RequestMapping("/roleMenu")
public class RoleMenuController {

    @Autowired
    private IRoleMenuService menuService;

    @Autowired
    private ReplyMapUtil replyMap;

    /**
     * @Description: //TODO 角色与菜单关联新增接口
     * @Param: [roleMenu]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 9:45 2019/12/7
     **/
    public Map<String, Object> roleMenuAdd(@RequestBody RoleMenu roleMenu) {
        if (roleMenu.getMenuId() != null && roleMenu.getRoleId() != null) {
            return menuService.roleMenuAdd(roleMenu.getRoleId(), roleMenu.getMenuId());

        } else {
            return replyMap.getReply("角色ID和商品ID均不能为空",0);
        }

    }

}
