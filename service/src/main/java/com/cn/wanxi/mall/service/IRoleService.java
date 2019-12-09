package com.cn.wanxi.mall.service;

import com.baomidou.mybatisplus.service.IService;
import com.cn.wanxi.mall.bean.Role;

import java.util.Map;

/**
 * @Description: TODO 角色表服务类
 * @ClassName: IRoleService
 * @Author: Mr.WuGuo
 * @Date: 2019/12/2 16:23
 */
public interface IRoleService extends IService<Role> {

    /**
     * @Description: //TODO 角色列表全获取
     * @Param: []
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 18:04 2019/12/5
     **/
    Map<String, Object> getRoleAll();

    /**
     * @Description: //TODO 角色新增
     * @Param: [role]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 18:23 2019/12/5
     **/
    Map<String, Object> roleAdd(Role role);

    /**
     * @Description: //TODO 角色修改
     * @Param: [role]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 18:33 2019/12/5
     **/
    Map<String, Object> roleUpdate(Role role);

    /**
     * @Description: //TODO 角色删除
     * @Param: [role]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 18:34 2019/12/5
     **/
    Map<String, Object> roleRemove(Role role);
}
