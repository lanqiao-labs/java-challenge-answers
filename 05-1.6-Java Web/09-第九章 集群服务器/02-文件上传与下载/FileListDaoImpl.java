package org.lanqiao.dao.daoimpl;

import org.lanqiao.dao.FileListDao;
import org.lanqiao.entity.FileList;
import org.lanqiao.jdbc.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class FileListDaoImpl implements FileListDao {

    // 获取数据总数
    public int getTotalCount(String fileName) {
        String sql=null;
        if(fileName==null || fileName.length()==0){
            sql =  "select count(*) from file_list";
        }else{
            String strName = "%"+fileName+"%";
            sql =  "select count(*) from file_list where file_name like '"+strName+"'";
        }
        return DbUtil.getTotalCount(sql);
    }

    // 获取 currentPage 页的全部文件信息（每页显示 pageSize 条数据）
    public List<FileList> getFileListForCurrentPage(int currentPage, int pageSize, String fileName) {
        // 在 mysql 中，分页查询我们是用 limit m,n
        // m 是起始行数下标，n 是每页数据条数
        String sql=null;
        Object[] os = null;
        if(fileName==null || fileName.length()==0){
            os= new Object[]{(currentPage - 1) * pageSize, pageSize};
             sql = "SELECT id,file_name,file_suffix,create_time,file_size,file_url FROM file_list ORDER BY id DESC limit ?,? ";
        }else{
            os= new Object[]{"%"+fileName+"%",(currentPage - 1) * pageSize, pageSize};
             sql = "SELECT id,file_name,file_suffix,create_time,file_size,file_url FROM file_list where file_name like ? ORDER BY id DESC limit ?,? ";
        }
        List<FileList> fileLists = new ArrayList<FileList>();
        try {
            ResultSet rs = DbUtil.query(sql, os);
            if(rs==null)
                return fileLists;
            while (rs.next()) {
                Long id = rs.getLong("id");
                String file_name = rs.getString("file_name");
                String file_suffix = rs.getString("file_suffix");
                Timestamp dateTime = rs.getTimestamp("create_time");
                String file_size = rs.getString("file_size");
                String file_url = rs.getString("file_url");
                FileList fileList = new FileList(id, file_name, file_suffix, dateTime, file_size,  file_url);
                // 将封装好的对象存放到 List 集合中
                fileLists.add(fileList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileLists;
    }

    public boolean addFile(FileList fl) {
        String sql = "INSERT INTO file_list(file_name,file_suffix,create_time,file_size,file_url) VALUE(?,?,?,?,?) ";
        Object[] os ={fl.getFileName(),fl.getFileSuffix(),fl.getCreateTime(),fl.getFileSize(),fl.getFileUrl()};
        return DbUtil.execute(sql, os);
    }
}