package com.cn.wanxi.mall.service;

import com.baomidou.mybatisplus.service.IService;
import com.cn.wanxi.mall.bean.Admin;

import java.util.Map;

/**
 * @Description: TODO 管理员表服务类
 * @ClassName: IAdminService
 * @Author: Mr.WuGuo
 * @Date: 2019/12/2 16:23
 */
public interface IAdminService extends IService<Admin> {
    /**
     * @Description: TODO:管理员登录方法
     * @Param: [admin]
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 17:26 2019/12/2
     **/
    Map<String, Object> adminLogin(Admin admin);

    /**
     * @Description: //TODO 管理员登出方法
     * @Param: []
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 16:01 2019/12/5
     **/
    Map<String, Object> adminLogout();
}
