package org.lanqiao.service;

import org.apache.commons.fileupload.FileItem;
import org.lanqiao.entity.FileList;
import org.lanqiao.entity.Page;

import javax.servlet.http.HttpServletRequest;

public interface FileListService {
    // 获取数据总数
    int getTotalCount(String fileName);

    //获取分页后的文件列表
    Page<FileList> getFileListForCurrentPage(String curPage, String fileName);
    //保存文件到本地和数据库
    boolean saveFile(HttpServletRequest request, boolean isMultipart, String uploadFilePath);
    //保存文件到本地
    boolean saveFileInLocal(String uploadFilePath, FileItem item);
    // 根据 id 删除文件

}