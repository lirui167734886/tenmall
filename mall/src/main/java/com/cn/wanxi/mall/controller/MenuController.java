package com.cn.wanxi.mall.controller;

import com.cn.wanxi.mall.bean.Menu;
import com.cn.wanxi.mall.bean.vo.CondPageVo;
import com.cn.wanxi.mall.service.IMenuService;
import com.cn.wanxi.mall.utils.ReplyMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Description: TODO 菜单表前端控制器
 * @ClassName: MenuController
 * @Author: Mr.WuGuo
 * @Date: 2019/12/2 16:23
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @Autowired
    private ReplyMapUtil replyMap;

    /**
     * @Description: //TODO 获取所有菜单信息接口
     * @Param: []
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 15:19 2019/12/4
     **/
    @PostMapping("/findAll")
    public Map<String, Object> menuFindAll(@RequestBody Menu menu) {
        return menuService.menuFindAll(menu);
    }


    /**
     * @Description: //TODO 获取条件菜单列表接口
     * @Param: [condPage]
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 16:46 2019/12/5
     **/
    @PostMapping("/findCondPage")
    public Map<String, Object> findCondPage(@RequestBody CondPageVo condPage) {
        return menuService.findCondPage(condPage);
    }

    /**
     * @Description: //TODO 菜单新增接口
     * @Param: []
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 16:53 2019/12/5
     **/
    @PostMapping("/add")
    public Map<String, Object> menuAdd(@RequestBody Menu menu) {
        if (menu.getMenuName() != null) {
            return menuService.menuAdd(menu);
        } else {
            return replyMap.getReply("新增失败,菜单名不能为空", 1);
        }
    }

    /**
     * @Description: //TODO 菜单修改接口
     * @Param: [menu]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 17:33 2019/12/5
     **/
    @PostMapping("/update")
    public Map<String, Object> menuUpdate(@RequestBody Menu menu) {
        if (menu.getMenuName()!=null&&menu.getMenuId()!=null){
            return menuService.menuUpdate(menu);
        }else {
            return replyMap.getReply("修改失败,菜单名以及菜单ID不能为空", 1);
        }
    }
    
    /**
     * @Description: //TODO 菜单删除接口
     * @Param: [menu]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Mr.WuGuo
     * @Date: 17:46 2019/12/5
     **/
    @PostMapping("/delete")
    public Map<String, Object> menuRemove(@RequestBody Menu menu) {
        if (menu.getMenuId() != null) {
            return menuService.menuRemove(menu);
        } else {
            return replyMap.getReply("新增失败,ID不能为空", 1);
        }
    }
}
