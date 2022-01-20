package org.lanqiao.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DBUtil {

    public Connection getConn(){
        // 创建数据源对象
        DataSource dataSource = null;
        // 创建数据源配置对象
        Properties properties = new Properties();
        // 创建连接对象
        Connection conn = null;
        // 通过当前类的 class 对象获取资源文件
        InputStream is = DBUtil.class.getResourceAsStream("/druid.properties");
        try {
            properties.load(is);
            // 返回的是 DataSource，不是 DruidDataSource
            dataSource = DruidDataSourceFactory.createDataSource(properties);
            // 返回连接对象
            conn = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}