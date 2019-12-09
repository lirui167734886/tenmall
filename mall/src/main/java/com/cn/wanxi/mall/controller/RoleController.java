package com.cn.wanxi.mall.controller;


import com.cn.wanxi.mall.bean.Role;
import com.cn.wanxi.mall.service.IRoleService;
import com.cn.wanxi.mall.utils.ReplyMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * @Description: TODO 角色表 前端控制器
 * @ClassName: RoleController
 * @Author: Mr.WuGuo
 * @Date: 2019/12/2 16:23
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private ReplyMapUtil replyMap;

    /**
     * @Description: //TODO 角色列表接口
     * @Param: []
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 18:10 2019/12/5
     **/
    @PostMapping("/findAll")
    public Map<String,Object> roleFindAll(){
        return roleService.getRoleAll();
    }


    /**
     * @Description: //TODO 角色新增接口
     * @Param: [role]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 18:21 2019/12/5
     **/
    @PostMapping("/add")
    public Map<String,Object> roleAdd(@RequestBody Role role){
        if (role.getRoleName()!=null){
            return roleService.roleAdd(role);
        }else {
            return replyMap.getReply("新增失败,角色名不能为空", 1);
        }
    }

    /**
     * @Description: //TODO 角色修改接口
     * @Param: [role]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 18:33 2019/12/5
     **/
    @PostMapping("/update")
    public Map<String, Object> menuUpdate(@RequestBody Role role) {
        if (role.getRoleId()!=null&&role.getRoleName()!=null){
            return roleService.roleUpdate(role);
        }else {
            return replyMap.getReply("修改失败,角色名以及角色ID不能为空", 1);
        }
    }

    /**
     * @Description: //TODO 角色删除接口
     * @Param: [role]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 18:32 2019/12/5
     **/
    @PostMapping("/delete")
    public Map<String, Object> roleRemove(@RequestBody Role role) {
        if (role.getRoleId() != null) {
            return roleService.roleRemove(role);
        } else {
            return replyMap.getReply("删除失败,ID不能为空", 1);
        }
    }
}
