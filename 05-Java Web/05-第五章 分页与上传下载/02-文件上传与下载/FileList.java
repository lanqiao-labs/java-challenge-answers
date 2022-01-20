package org.lanqiao.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class FileList implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 后缀名
     */
    private String fileSuffix;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 文件大小
     */
    private String fileSize;
    /**
     * 文件路径
     */
    private String fileUrl;


    public FileList(Long id, String fileName, String fileSuffix, Timestamp createTime, String fileSize, String fileUrl) {
        this.id = id;
        this.fileName = fileName;
        this.fileSuffix = fileSuffix;
        this.createTime = createTime;
        this.fileSize = fileSize;
        this.fileUrl = fileUrl;
    }
    //获取格式化的时间
    public String getCreateDataTimeString(){
        String tsStr = "";
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            // 方法一
            return sdf.format(this.createTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public Timestamp getCreateTime() {return createTime; }

    public void setCreateTime(Timestamp createTime) { this.createTime = createTime; }

    public String getFileUrl() {  return fileUrl; }

    public void setFileUrl(String fileUrl) {  this.fileUrl = fileUrl; }


}