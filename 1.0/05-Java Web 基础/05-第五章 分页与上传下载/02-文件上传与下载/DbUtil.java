package org.lanqiao.jdbc;
import java.sql.*;

public class DbUtil {
    //省略属性定义及初始化赋值
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/file_system?useUnicode=true&characterEncoding=utf8&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PWD = "";
    static Connection conn = null;
    static PreparedStatement pstmt = null;
    //通用的，获取数据库连接对象的方法
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, USERNAME, PWD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    //通用的，获取PreparedStatement对象的方法
    public static PreparedStatement createPreparedStatement(String sql, Object[] os) {
        try {
            pstmt = getConnection().prepareStatement(sql);
            if (os != null) {
                for (int i = 0; i < os.length; i++) {
                    pstmt.setObject(i + 1, os[i]);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pstmt;
    }

    //通用的，关闭访问数据库相关对象的方法（注意PreparedStatement继承自Statement）
    public static void closeAll(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //通用的，增加、删除、修改方法
    public static boolean execute(String sql, Object[] os) {
        // flag用来标记是否增加成功，若增加成功则返回true，若增加失败则返回false
        boolean flag = true;

        try {
            //获取Statement对象
            pstmt = createPreparedStatement(sql, os);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        } finally {
            closeAll(null, pstmt, conn);
        }
        return flag;
    }

    //通用的查询方法，返回查询的结果集ResultSet对象
    public static ResultSet query(String sql, Object[] os) {
        ResultSet rs = null;
        try {
            pstmt = createPreparedStatement(sql, os);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("SQLException：" + e);
        } catch (Exception e) {
            System.out.println("查询发生异常：" + e);
        }
        return rs;
    }

    // 查询数据总数
    public static int getTotalCount(String sql){
        int count = -1;
        ResultSet rs = null;
        try {
            pstmt = createPreparedStatement(sql,null);
            rs = pstmt.executeQuery();
            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(rs,pstmt,conn);
        }
        return count;
    }
}