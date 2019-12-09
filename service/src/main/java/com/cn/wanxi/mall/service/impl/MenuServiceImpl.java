package com.cn.wanxi.mall.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cn.wanxi.mall.bean.Menu;
import com.cn.wanxi.mall.bean.vo.CondPageVo;
import com.cn.wanxi.mall.dao.MenuMapper;
import com.cn.wanxi.mall.service.IMenuService;
import com.cn.wanxi.mall.utils.ReplyMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description: TODO 菜单表服务实现类
 * @ClassName: MenuServiceImpl
 * @Author: Mr.WuGuo
 * @Date: 2019/12/2 16:23
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private ReplyMapUtil replyMap;
    /**
     * @Description: //TODO 获取条件菜单列表实现
     * @Param: [condPage]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 17:05 2019/12/5
     **/
    @Override
    public Map<String, Object> findCondPage(CondPageVo condPage) {
        Page<Menu> page = new Page<>(condPage.getPage(), condPage.getSize());
        EntityWrapper<Menu> wrapper = new EntityWrapper<>();
        List<Menu> menuList = this.selectPage(page, wrapper.eq("menu_name", condPage.getName())).getRecords();
        return replyMap.getReply("获取成功",0,menuList);
    }

    /**
     * @Description: //TODO 菜单新增实现
     * @Param: [menu]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 17:06 2019/12/5
     **/
    @Override
    public Map<String, Object> menuAdd(Menu menu) {
        Integer insert = baseMapper.insert(menu);
        if (insert==1){
            return replyMap.getReply("保存成功",0);
        }else {
            return replyMap.getReply("保存失败",1);
        }
    }


    /**
     * @Description: //TODO 菜单修改功能实现
     * @Param: [menu]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 14:10 2019/12/7
     **/
    @Override
    public Map<String, Object> menuUpdate(Menu menu) {
        Integer integer = baseMapper.updateById(menu);
        if (integer==1){
            return replyMap.getReply("修改成功",0);
        }else {
            return replyMap.getReply("修改失败",1);
        }
    }

    /**
     * @Description: //TODO 菜单删除实现
     * @Param: [menu]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 17:46 2019/12/5
     **/
    @Override
    public Map<String, Object> menuRemove(Menu menu) {
        Integer integer = baseMapper.deleteById(menu);
        if (integer==1){
            return replyMap.getReply("删除成功",0);
        }else {
            return replyMap.getReply("删除失败",1);
        }
    }

    /**
     * @Description: //TODO 获取所有菜单实现
     * @Param: [menu]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 14:13 2019/12/7
     **/
    @Override
    public Map<String, Object> menuFindAll(Menu menu) {
        EntityWrapper<Menu> wrapper=new EntityWrapper<>();
        List<Menu> menuList = this.selectList(wrapper.eq("menu_name",menu.getMenuName()));
        return replyMap.getReply("获取成功",0,menuList);

    }
}
