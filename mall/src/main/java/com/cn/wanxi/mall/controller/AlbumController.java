package com.cn.wanxi.mall.controller;


import com.cn.wanxi.mall.bean.Album;
import com.cn.wanxi.mall.service.AlbumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LiRui
 * @since 2019-11-22
 */
@RestController
@RequestMapping("/photoes")
public class AlbumController {

    @Resource
    private AlbumService as;

    @PostMapping("add")
    public Map<String,String> add(HttpServletRequest request){
        String title = request.getParameter("title");
        String image = request.getParameter("Image");
        String imageItems = request.getParameter("imageItems");
        if (title==null||image==null||imageItems==null) {
            Map<String, String> map = new HashMap<>(16);
            map.put("code","1");
            map.put("message","请上传完整参数");
            return map;
        }
        Album album = new Album(title,image,imageItems);
        return as.add(album);
    }

    @PostMapping("update")
    public Map<String,String> update(HttpServletRequest request){
        String title = request.getParameter("title");
        String image = request.getParameter("Image");
        String imageItems = request.getParameter("imageItems");
        String ids = request.getParameter("id");
        if (title==null||image==null||imageItems==null||ids==null) {
            Map<String, String> map = new HashMap<>(16);
            map.put("code","1");
            map.put("message","请上传完整参数");
            return map;
        }
        Long id = Long.parseLong(ids);
        Album album = new Album(id,title,image,imageItems);
        return as.update(album);
    }
    @PostMapping("delete")
    public Map<String,String> delete(HttpServletRequest request){
        String idd = request.getParameter("id");
        Map<String,String> delete = new HashMap<>(16);
        if (idd==null){
            delete.put("code","1");
            delete.put("message","请输入id！");
            return delete;
        }
        Integer id=Integer.parseInt(idd);
        return as.delete(id);
    }

    @GetMapping("findAll")
    public List<Album> findAll() {
        return as.findAll();
    }

    @GetMapping("findById")
    public Album findById(HttpServletRequest request){
        Long id =Long.parseLong(request.getParameter("id"));
        return as.findById(id);
    }

    @PostMapping("upload")
    public Map<String,String> upload(MultipartFile[] files,HttpServletRequest request){
        Map<String, String> map = new HashMap<>(16);
        if (files == null || files.length == 0) {
            map.put("message", "请上传图片");
            return map;
        }
        return as.upload(files, request);

    }


}

