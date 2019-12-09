package com.cn.wanxi.mall.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cn.wanxi.mall.bean.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: TODO 管理员表 Mapper 接口
 * @ClassName: AdminMapper
 * @Author: Mr.WuGuo
 * @Date: 2019/12/2 16:23
 */
public interface AdminMapper extends BaseMapper<Admin> {
//    Admin adminLogin(@Param("name") String name,@Param("pw")String password);
}
