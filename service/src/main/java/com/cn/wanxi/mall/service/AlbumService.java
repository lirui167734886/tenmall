package com.cn.wanxi.mall.service;

import com.baomidou.mybatisplus.service.IService;
import com.cn.wanxi.mall.bean.Album;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiRui
 * @since 2019-11-22
 */
public interface AlbumService extends IService<Album> {

    /**
     * <p>
     *     相册添加
     * </p>
     * @param album 相册对象
     * @return map信息
     */
    Map<String, String> add(Album album);

    /**
     * <p>
     *     相册修改
     * </p>
     * @param album 相册对象
     * @return map信息
     */
    Map<String, String> update(Album album);

    /**
     * <p>
     *     相册删除
     * </p>
     * @param id id
     * @return map信息
     */
    Map<String, String> delete(Integer id);

    /**
     * <p>
     *     查询所有相册
     * </p>
     * @return 相册集合
     */
    List<Album> findAll();

    /**
     * <p>
     *     根据id查询
     * </p>
     * @param id id
     * @return 相册集合
     */
    Album findById(Long id);

    /**
     * <p>
     *     文件上传
     * </p>
     * @param files 文件数组
     * @param request 响应
     * @return map信息
     */
    Map<String, String> upload(MultipartFile[] files, HttpServletRequest request);
}
