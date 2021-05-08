package org.lanqiao.dao.daoimpl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lanqiao.dao.FileListDao;
import org.lanqiao.entity.FileList;
import org.lanqiao.util.DBUtil;
import java.sql.SQLException;
import java.util.List;


public class FileListDaoImpl implements FileListDao {

    QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSourceWithC3P0ByXML());

    // 获取数据总数
    public int getTotalCount(String fileName) {
        String sql=null;
        if(fileName==null || fileName.length()==0){
            sql =  "select count(*) from file_list";
        }else{
            String strName = "%"+fileName+"%";
            sql =  "select count(*) from file_list where file_name like '"+strName+"'";
        }
        Long result = -1L;
        try {
            result = queryRunner.query(sql,new ScalarHandler<Long>());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result.intValue();
    }

    // 获取 currentPage 页的全部文件信息（每页显示 pageSize 条数据）
    public List<FileList> getFileListForCurrentPage(int currentPage, int pageSize, String fileName) {
        // 在 mysql 中，分页查询我们是用 limit m,n
        // m 是起始行数下标，n 是每页数据条数
        String sql=null;
        Object[] os = null;
        if(fileName==null || fileName.length()==0){
            os= new Object[]{(currentPage - 1) * pageSize, pageSize};
             sql = "SELECT id,file_name fileName,file_suffix fileSuffix,create_time createTime,file_size fileSize,file_url fileUrl FROM file_list ORDER BY id DESC limit ?,? ";
        }else{
            os= new Object[]{"%"+fileName+"%",(currentPage - 1) * pageSize, pageSize};
             sql = "SELECT id,file_name fileName,file_suffix fileSuffix,create_time createTime,file_size fileSize,file_url fileUrl FROM file_list where file_name like ? ORDER BY id DESC limit ?,? ";
        }
        List<FileList> fileLists = null;
        try {
            fileLists = queryRunner.query(sql, new BeanListHandler<FileList>(FileList.class),os);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return fileLists;
    }

    public boolean addFile(FileList fl) {
        String sql = "INSERT INTO file_list(file_name,file_suffix,create_time,file_size,file_url) VALUE(?,?,?,?,?) ";
        Object[] os ={fl.getFileName(),fl.getFileSuffix(),fl.getCreateTime(),fl.getFileSize(),fl.getFileUrl()};
        int execute = -1;
        try {
            execute = queryRunner.execute(sql, os);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(execute==-1){
            return false;
        }else{
            return true;
        }

    }
}