package org.lanqiao.util;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class DBUtil {
    // 初始化赋值
    static Connection conn = null;
    static PreparedStatement pstmt = null;

    //获取 C3P0 数据源对象
    public static DataSource getDataSourceWithC3P0ByXML (){
        ComboPooledDataSource cpds = new ComboPooledDataSource("lanqiao");
        return cpds ;
    }
}