package com.cn.wanxi.mall.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cn.wanxi.mall.bean.RoleMenu;
import com.cn.wanxi.mall.dao.RoleMenuMapper;
import com.cn.wanxi.mall.service.IRoleMenuService;
import com.cn.wanxi.mall.utils.ReplyMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 角色菜单中间表 服务实现类
 * </p>
 *
 * @author Mht
 * @since 2019-12-02
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

    @Autowired
    private ReplyMapUtil replyMap;
    /**
     * @Description: //TODO 角色与菜单关联新增实现
     * @Param: [roleId, menuId]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 9:37 2019/12/7
     **/
    @Override
    public Map<String, Object> roleMenuAdd(RoleMenu roleMenu) {
        Integer insert = baseMapper.insert(roleMenu);
        if (insert==1){
            return replyMap.getReply("添加成功",0);
        }
        else {
            return replyMap.getReply("添加失败",1);
        }
    }

    /**
     * @Description: //TODO 角色与菜单关联取消实现
     * @Param: [roleId, menuId]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 9:37 2019/12/7
     **/
    @Override
    public Map<String, Object> roleMenuRemove(RoleMenu roleMenu) {
        EntityWrapper<RoleMenu> wrapper = new EntityWrapper<>();
        Integer delete = baseMapper.delete(
                wrapper.eq("role_id", roleMenu.getMenuId())
                        .eq("menu_id", roleMenu.getMenuId()));
        if (delete==1){
            return replyMap.getReply("删除成功",0);
        }else {
            return replyMap.getReply("删除失败",1);
        }
    }
}
