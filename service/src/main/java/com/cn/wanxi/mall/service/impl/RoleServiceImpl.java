package com.cn.wanxi.mall.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cn.wanxi.mall.bean.Role;
import com.cn.wanxi.mall.dao.RoleMapper;
import com.cn.wanxi.mall.service.IRoleService;
import com.cn.wanxi.mall.utils.ReplyMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description: TODO 角色表服务实现类
 * @ClassName: RoleServiceImpl
 * @Author: Mr.WuGuo
 * @Date: 2019/12/2 16:23
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private ReplyMapUtil replyMap;

    /**
     * @Description: //TODO 角色列表全获取实现
     * @Param: []
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 18:05 2019/12/5
     **/
    @Override
    public Map<String, Object> getRoleAll() {
        List<Role> roles = baseMapper.selectList(null);
        return replyMap.getReply("获取成功", 0, roles);
    }

    /**
     * @Description: //TODO 角色新增实现
     * @Param: [role]
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 18:20 2019/12/5
     **/
    @Override
    public Map<String, Object> roleAdd(Role role) {
        Integer insert = baseMapper.insert(role);
        if (insert == 1) {
            return replyMap.getReply("新增成功", 0);
        } else {
            return replyMap.getReply("新增失败", 1);
        }
    }

    /**
     * @Description: //TODO 角色修改实现
     * @Param: [role]
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 18:34 2019/12/5
     **/
    @Override
    public Map<String, Object> roleUpdate(Role role) {
        Integer integer = baseMapper.updateById(role);
        if (integer == 1) {
            return replyMap.getReply("修改成功", 0);
        } else {
            return replyMap.getReply("修改失败", 1);
        }
    }

    /**
     * @Description: //TODO 角色删除实现
     * @Param: [role]
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 18:34 2019/12/5
     **/
    @Override
    public Map<String, Object> roleRemove(Role role) {
        Integer integer = baseMapper.deleteById(role);
        if (integer == 1) {
            return replyMap.getReply("修改成功", 0);
        } else {
            return replyMap.getReply("修改失败", 1);
        }
    }
}
