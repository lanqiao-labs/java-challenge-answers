package org.lanqiao.service.impl;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.lanqiao.dao.FileListDao;
import org.lanqiao.dao.impl.FileListDaoImpl;
import org.lanqiao.entity.FileList;
import org.lanqiao.service.FileListService;
import org.lanqiao.util.Page;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

public class FileListServiceImpl implements FileListService {
    // 业务逻辑层依赖于数据访问层
    FileListDao fileListDao = new FileListDaoImpl();

    @Override
    public int getTotalCount(String fileName) {
        return fileListDao.getTotalCount(fileName);
    }

    @Override
    public Page<FileList> getFileListForCurrentPage(String curPage, String fileName) {
        //如果 curPage 值为 null ,说明是第一次进入分页查询，则将 curPage 设为1
        if(curPage == null){
            curPage = "1";
        }
        int currentPageNo =  Integer.parseInt(curPage);
        //获得数据总数
        int totalCount = this.getTotalCount(fileName);
        //获取分页帮助类
        Page pages = new Page();
        //设置页面大小，即每页显示的条数(本案例，假设每页显示4条数据)
        pages.setPageSize(4);
        //设置数据总条数
        pages.setTotalCount(totalCount);
        //获取总页数
        int totalPages = pages.getTotalPage();
        //对首页与末页进行控制：页数不能小于1，也不能大于最后一页的页数
        if(currentPageNo<1){
            currentPageNo = 1;
        }else if(currentPageNo>totalPages){
            currentPageNo = totalPages;
        }
        //设置当前页的页码
        pages.setCurrentPage(currentPageNo);
        pages.setParm(fileName);
        //获取列表
        List<FileList> fileListForCurrent = fileListDao.getFileListForCurrentPage(pages.getCurrentPage(), pages.getPageSize(),fileName);
        //将获取的文件列表放到 page 对象
        pages.setList(fileListForCurrent);
        return pages;
    }

    /**
     * 保存文件
     * @param request
     * @param isMultipart
     * @param uploadFilePath
     * @return
     */
    public boolean saveFile(HttpServletRequest request, boolean isMultipart, String uploadFilePath) {
        try {
            if (isMultipart) {
                // 限制文件上传的大小
                DiskFileItemFactory factory = new DiskFileItemFactory();
                // 创建临时文件目录路径:这里在 webapp 下创建新文件夹 temp
                File tempPath = new File("/home/project/FileSystem/src/main/webapp/temp");
                // 设置缓冲区大小为 5KB
                factory.setSizeThreshold(1024*100*10000);
                // 设置上传文件到临时文件存放路径
                factory.setRepository(tempPath);
                // 通过 FileItemFactory 对象，产生 ServletFileUpload 对象
                ServletFileUpload upload = new ServletFileUpload(factory);
                // 设置上传单个文件的最大值是 10M
                upload.setSizeMax(1024*100*10000);
                // 解析 form 表单中所有字段元素
                List<FileItem> items = null;
                try {
                    items = upload.parseRequest(request);
                } catch (FileUploadBase.FileSizeLimitExceededException e) {
                    e.printStackTrace();
                } catch (FileUploadException e) {
                    e.printStackTrace();
                }
                // 遍历 form 表单的每个字段元素
                Iterator<FileItem> iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    if (saveFileInLocal(uploadFilePath, item)) {
                        String fileName = item.getName();
                        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
                        FileList fileList = new FileList(null, fileName, ext, new Timestamp(System.currentTimeMillis()), this.getSize(item.getSize()), "/upload/" + fileName);
                        return fileListDao.addFile(fileList);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean deleteFileById(Long id, String uploadFilePath) {
        FileList file = fileListDao.findFileById(id);
        if(file!=null){
            // 调用数据访问层的方法，实现删除操作
            boolean isDelete = fileListDao.deleteFileById(id);
            if(isDelete){
                this.delFile(uploadFilePath+"/"+file.getFileName());
            }
            return isDelete;
        }
        return false;
    }

    /**
     * 给文件添加大小单位
     * @param size
     * @return
     */
    String getSize(long size){
        if(size>=1024*1024*1024){
            return new Long(size/1073741824L)+"G";
        }else if(size>=1024*1024){
            return new Long(size/1048576L)+"M";
        }else if(size>=1024){
            return new Long(size/1024)+"K";
        }else
            return size+"B";
    }

    /**
     * 删除文件
     * @param filePathAndName 指定得路径
     */
    public  void delFile(String filePathAndName) {
        try {
            String filePath = filePathAndName;
            filePath = filePath.toString();
            java.io.File myDelFile = new java.io.File(filePath);
            myDelFile.delete();
        } catch (Exception e) {
            System.out.println("删除文件操作出错");
            e.printStackTrace();
        }
    }

    /**
     * 将文件保存到本地
     * @param uploadFilePath
     * @param item
     * @return true 保存成功 false 保存失败
     */
    public boolean saveFileInLocal(String uploadFilePath, FileItem item) {
        // 获取正在上传的文件名
        String fileName = item.getName();
        if (fileName != null && !fileName.equals("")) {
            File saveFile = new File(uploadFilePath, fileName);
            try {
                item.write(saveFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
}