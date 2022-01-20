package org.lanqiao.dao;

import org.lanqiao.entity.FileList;

import java.util.List;

public interface FileListDao {

    // 获取数据总数
    int getTotalCount(String fileName);

    //获取分页后的文件列表
    List<FileList> getFileListForCurrentPage(int currentPage, int pageSize, String fileName);
    //添加文件
    boolean addFile(FileList fileList);

}