package com.cn.wanxi.mall.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cn.wanxi.mall.bean.Album;
import com.cn.wanxi.mall.service.AlbumService;
import com.cn.wanxi.mall.utils.Document;
import com.cn.wanxi.mall.dao.AlbumMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LiRui
 * @since 2019-11-22
 */
@Service
public class AlbumServiceImpl extends ServiceImpl<AlbumMapper, Album> implements AlbumService {

    /**
     * <p>
     * 相册添加
     * </p>
     *
     * @param album 相册对象
     * @return map信息
     */
    @Override
    public Map<String, String> add(Album album) {
        Map<String, String> add = new HashMap<>(16);
        List<Album> albums = this.selectList(
                new EntityWrapper<Album>().eq("title", album.getTitle())
        );
        if (albums.size() != 0) {
            add.put("code", "1");
            add.put("message", "添加的相册已存在");
            return add;
        }
        boolean insert = this.insert(album);
        if (insert) {
            add.put("code", "0");
            add.put("message", "添加相册成功");
            return add;
        }
        add.put("code", "1");
        add.put("message", "添加相册失败");
        return add;
    }

    /**
     * <p>
     * 相册修改
     * </p>
     *
     * @param album 相册对象
     * @return map信息
     */
    @Override
    public Map<String, String> update(Album album) {
        Map<String, String> update = new HashMap<>(16);
        Album album1 = this.selectById(album.getId());
        if (album1 == null) {
            update.put("code", "1");
            update.put("message", "修改的相册不存在");
            return update;
        }

        boolean id = this.update(album, new EntityWrapper<Album>().eq("id", album.getId()));
        if (id) {
            update.put("code", "0");
            update.put("message", "修改相册成功");
            return update;
        }
        update.put("code", "1");
        update.put("message", "修改相册失败");
        return update;
    }

    /**
     * <p>
     * 相册删除
     * </p>
     *
     * @param id id
     * @return map信息
     */
    @Override
    public Map<String, String> delete(Integer id) {
        boolean b = this.deleteById(id);
        Map<String, String> delete = new HashMap<>(16);
        if (!b) {
            delete.put("code", "1");
            delete.put("message", "删除失败");
            return delete;
        }
        delete.put("code", "0");
        delete.put("message", "删除成功");

        return delete;
    }

    /**
     * <p>
     * 查询所有相册
     * </p>
     *
     * @return 相册集合
     */
    @Override
    public List<Album> findAll() {
        return this.selectList(null);
    }

    /**
     * <p>
     * 根据id查询
     * </p>
     *
     * @param id id
     * @return 相册对象
     */
    @Override
    public Album findById(Long id) {
        return this.selectById(id);
    }

    /**
     * <p>
     * 文件上传
     * </p>
     *
     * @param files   文件数组
     * @param request 响应
     * @return map信息
     */
    @Override
    public Map<String, String> upload(MultipartFile[] files, HttpServletRequest request) {
        Map<String, String> map = new HashMap<>(16);
        StringBuffer realPath = new StringBuffer();
        Document document = new Document();
        if (files.length == 1) {
            Map<String, Object> file = document.getFile(files[0], request.getServletContext());
            boolean b =(boolean) file.get("boolean");
            if ("true".equals(b)) {
                map.put("message", "上传成功");
                String downPath = (String)file.get("downPath");
                map.put("Image", downPath);
                return map;
            } else {
                map.put("message", "上传失败");
                return map;
            }
        }
        for (MultipartFile f : files) {
            Map<String, Object> file = document.getFile(f, request.getServletContext());
            boolean b = (boolean)file.get("boolean");
            if (!"true".equals(b)) {
                map.put("message", f.getName() + "上传失败");
                map.put("imageItems", realPath.toString());
                return map;
            }
            map.put("message", f.getName() + "上传成功");
            realPath.append(file.get("downPath")).append(";");
        }
        map.put("imageItems", realPath.toString());
        return map;
    }

}
