package org.lanqiao.control;

import org.lanqiao.entity.User;

import java.sql.*;

public class LoginControl {

    public User Login(User user){

        try {
            // 加载 jdbc 驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取链接
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
            // 准备 sql 语句
            String sql = "select * from users where userName=? and userPwd = ?";
            // 获取 prepareStatement 对象
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 填充占位符
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getUserPwd());
            // 运行 sql 获取结果集
            ResultSet resultSet = preparedStatement.executeQuery();
            // 处理结果集,并将查询结果封装并返回出去
            User loginUser = null;
            while (resultSet.next()){
                String userName = resultSet.getString(1);
                String userPwd = resultSet.getString(2);
                String nickName = resultSet.getString(3);
                loginUser = new User(userName,userPwd,nickName);
            }
            return loginUser;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}