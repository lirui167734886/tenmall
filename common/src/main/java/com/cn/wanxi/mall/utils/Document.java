package com.cn.wanxi.mall.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: LiRui
 * @Date: 2019/12/5
 * @Time: 15:13
 */
public class Document {
    public Map<String,Object> getFile(MultipartFile file, ServletContext servletContext) {
        String downPath = "";
        String filename = file.getName(); // 要上传的文件名
        File filepath = creatdir(servletContext);
        filename = createname(filename);// 新文件名
        File file1 = new File(filepath, filename);// 要上传的最终路径
        downPath = file1.getAbsolutePath();
        boolean b = writeInFile(file, downPath);
        Map<String,Object> map = new HashMap<>(16);
        map.put("downPath",downPath);
        map.put("boolean", b);
        return map;
    }

    private boolean writeInFile(MultipartFile file, String downPath) {
        BufferedOutputStream os = null;
        BufferedInputStream is = null;
        try {
            os = new BufferedOutputStream(new FileOutputStream(new File(downPath)));
            is = new BufferedInputStream(file.getInputStream());
            int read;
            byte[] b = new byte[1024];
            while ((read = is.read(b)) != -1) {
                os.write(b, 0, read);

            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    // 从消息头中获取上传的文件名称
    private String getName(String header) {
        String[] arrays = header.split(";");
        String str = arrays[arrays.length - 1];
        int start = str.indexOf("\"");
        int end = str.lastIndexOf("\"");
        String string = str.substring(start + 1, end);
        int last = string.lastIndexOf("\\");
        return string.substring(last + 1);
    }

    // 创建目录---以日期，一天一个文件夹
    private File creatdir(ServletContext context) {
        String realpath = context.getRealPath("/upLoad");
        String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        File file = new File(realpath, date);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    // 创建文件名--区分同名文件,在文件名前加上当前的时间
    private String createname(String filename) {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()) + "_" + filename;
    }

}
