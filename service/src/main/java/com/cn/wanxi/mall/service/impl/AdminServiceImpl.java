package com.cn.wanxi.mall.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cn.wanxi.mall.bean.Admin;
import com.cn.wanxi.mall.dao.AdminMapper;
import com.cn.wanxi.mall.service.IAdminService;
import com.cn.wanxi.mall.utils.ReplyMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description: TODO 管理员表服务实现类
 * @ClassName: AdminServiceImpl
 * @Author: Mr.WuGuo
 * @Date: 2019/12/2 16:23
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {


    @Autowired
    private ReplyMapUtil replyMap;
    /**
     * @Description: //TODO 管理员登录验证实现方法
     * @Param: [admin]
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 17:28 2019/12/2
     **/
    @Override
    public Map<String, Object> adminLogin(Admin admin) {
        EntityWrapper<Admin> wrapper = new EntityWrapper<>();
        List<Admin> adminList = this.selectList(wrapper.eq("login_name", admin.getLoginName())
                .eq("password", admin.getPassword()).where("status!=2"));
        if (adminList.size()>0){
            if (adminList.get(0).getStatus().equals("0")){
                Map<String, Object> reply = replyMap.getReply("登录成功", 0, adminList.get(0));
                return reply;
            }else {
                Map<String, Object> reply = replyMap.getReply("登录失败,用户被冻结", 1, adminList.get(0));
                return reply;
            }
        }else {
            Map<String, Object> reply = replyMap.getReply("登录失败,用户或密码错误", 1);
            return reply;
        }


    }

    @Override
    public Map<String, Object> adminLogout() {
        return replyMap.getReply("退出成功",0);
    }
}
