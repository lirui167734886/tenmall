package com.cn.wanxi.mall.controller;

import com.cn.wanxi.mall.bean.Admin;
import com.cn.wanxi.mall.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO 管理员表前端控制器
 * @ClassName: AdminController
 * @Author: Mr.WuGuo
 * @Date: 2019/12/2 16:18
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    /**
     * @Description: //TODO 登录接口
     * @Param: [admin]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 15:57 2019/12/5
     **/
    @PostMapping("/login")
    public Map<String,Object> adminLogin(@RequestBody Admin admin){
        return adminService.adminLogin(admin);
    }
    @GetMapping("/findAll")
    public Map<String,Object> adminFindAll(){
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    /**
     * @Description: //TODO 用户登出接口
     * @Param: []
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 16:04 2019/12/5
     **/
    @GetMapping("/logout")
    public Map<String,Object> adminLogout(){
        return adminService.adminLogout();
    }
}
