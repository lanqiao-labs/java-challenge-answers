package org.lanqiao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
    /**
     *  获取数据库链接
     * @return 数据库链接
     */
    public static Connection getConn(){
        Connection conn = null;
        try {
            // 加载 jdbc 驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取链接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return conn;
    }
}