package com.cn.wanxi.mall.service;

import com.baomidou.mybatisplus.service.IService;
import com.cn.wanxi.mall.bean.Menu;
import com.cn.wanxi.mall.bean.vo.CondPageVo;

import java.util.Map;

/**
 * @Description: TODO 菜单表服务类
 * @ClassName: IMenuService
 * @Author: Mr.WuGuo
 * @Date: 2019/12/2 16:23
 */
public interface IMenuService extends IService<Menu> {

    /**
     * @Description: //TODO 获取条件菜单列表
     * @Param: [condPage]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 17:05 2019/12/5
     **/
    Map<String, Object> findCondPage(CondPageVo condPage);

    /**
     * @Description: //TODO 菜单新增
     * @Param: [menu]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 17:06 2019/12/5
     **/
    Map<String, Object> menuAdd(Menu menu);

    /**
     * @Description: //TODO 菜单修改
     * @Param: [menu]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 17:33 2019/12/5
     **/
    Map<String, Object> menuUpdate(Menu menu);

    /**
     * @Description: //TODO 菜单删除
     * @Param: [menu]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 17:45 2019/12/5
     **/
    Map<String, Object> menuRemove(Menu menu);

    /**
     * @Description: //TODO 获取所有菜单信息
     * @Param: [menu]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 14:12 2019/12/7
     **/
    Map<String, Object> menuFindAll(Menu menu);

}
