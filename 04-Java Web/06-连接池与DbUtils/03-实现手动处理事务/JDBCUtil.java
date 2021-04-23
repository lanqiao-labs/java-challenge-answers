package org.lanqiao.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtil {
    // 定义 ThreadLocal 对象，用于存放 Connection 对象
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    // 定义数据源对象
    private static DataSource ds = new ComboPooledDataSource("lanqiao");
    // 获取 C3p0 数据源对象（从 c3p0-config.xml 中读取默认的数据源配置）
    public static DataSource getDataSource(){
        return ds;
    }
    // 从 C3p0 连接池中，获取 Connection 连接对象
    public static Connection getConnection(){
        Connection conn = tl.get();
        try {
            if(conn == null){
                conn = ds.getConnection();
            }
            tl.set(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    // 开启事务
    public static void begin(){
        Connection conn = getConnection();
        // 手动开始事务
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 提交事务
    public static void commit(){
        Connection conn = tl.get();
        try {
            if(conn != null){
                conn.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 回滚事务
    public static void rollback(){
        Connection conn = tl.get();
        try {
            if(conn != null){
                conn.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 关闭连接
    public static void close(){
        Connection conn = tl.get();
        try {
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 从集合中移除当前绑定的连接
            tl.remove();
            conn = null;
        }
    }
}