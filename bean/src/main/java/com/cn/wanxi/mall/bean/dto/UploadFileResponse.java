package com.cn.wanxi.mall.bean.dto;

import java.io.Serializable;

/**
 * @Author: LucioWade
 * @Date: 9:48 2019/12/9
 */
public class UploadFileResponse implements Serializable {

    private static final long serialVersionUID = 1L;

//    private String fileName;
//
//    private String fileDownloadUri;
//
//    private String fileType;
//
//    private long size;
//
//    public UploadFileResponse(String fileName, String fileDownloadUri, String fileType, long size) {
//        this.fileName = fileName;
//        this.fileDownloadUri = fileDownloadUri;
//        this.fileType = fileType;
//        this.size = size;
//    }
//
//    public String getFileName() {
//        return fileName;
//    }
//
//    public void setFileName(String fileName) {
//        this.fileName = fileName;
//    }
//
//    public String getFileDownloadUri() {
//        return fileDownloadUri;
//    }
//
//    public void setFileDownloadUri(String fileDownloadUri) {
//        this.fileDownloadUri = fileDownloadUri;
//    }
//
//    public String getFileType() {
//        return fileType;
//    }
//
//    public void setFileType(String fileType) {
//        this.fileType = fileType;
//    }
//
//    public long getSize() {
//        return size;
//    }
//
//    public void setSize(long size) {
//        this.size = size;
//    }

    private Integer code;

    private String filepath;

    public UploadFileResponse() {}

    public UploadFileResponse(Integer code, String filepath) {
        this.code = code;
        this.filepath = filepath;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public String toString() {
        return "UploadFileResponse{" +
                "code=" + code +
                ", filepath='" + filepath + '\'' +
                '}';
    }
}
