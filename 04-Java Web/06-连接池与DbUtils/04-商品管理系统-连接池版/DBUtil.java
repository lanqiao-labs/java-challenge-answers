package org.lanqiao.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

    public static DataSource getDataSource() {
//      获取数据源
        ComboPooledDataSource cpds = new ComboPooledDataSource();
//      创建 properties 类
        Properties config = new Properties();
        try {
//          加载配置文件
            config.load(DBUtil.class.getClassLoader().getResourceAsStream("config.properties"));
//          设置连接池信息
//          设置数据库用户名
            cpds.setUser(config.getProperty("userName"));
//          设置数据库密码
            cpds.setPassword(config.getProperty("password"));
//          设置数据库连接地址
            cpds.setJdbcUrl(config.getProperty("url"));
//          设置数据库驱动
            cpds.setDriverClass(config.getProperty("driver"));
//          设置连接池初始连接数
            cpds.setInitialPoolSize(Integer.parseInt(config.getProperty("init")));
//          设置连接池最大连接数
            cpds.setMaxPoolSize(Integer.parseInt(config.getProperty("max")));
        }catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cpds;
    }
}