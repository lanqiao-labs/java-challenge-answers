package org.lanqiao.dao;

import org.lanqiao.entity.User;
import org.lanqiao.jdbc.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public User getUser(int user_id){
        String sql = "select * from users where user_id = ?";
        User user = new User();
        try {
            ResultSet rs = DBUtil.query(sql);
            while (rs.next()) {
                // 将查询到的用户信息封装到 user 对象中
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setUserGender(rs.getInt("user_gender"));
                user.setUserAge(rs.getInt("user_age"));
                user.setUserNation(rs.getString("user_nation"));
                user.setUserEmail(rs.getString("user_email"));
                user.setUserPhone(rs.getString("user_phone"));
                user.setUserAddr(rs.getString("user_addr"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public void updateUser(User user){
        String sql = "update users set user_name = ?,user_gender = ?,user_age = ?,user_nation = ?,user_email = ?,user_phone = ?,user_addr = ? where user_id = ?";
        boolean flag = DBUtil.execute(sql, user.getUserName(), user.getUserGender(), user.getUserAge(), user.getUserNation(), user.getUserEmail(), user.getUserPhone(), user.getUserAddr(), user.getUserId());
        if(flag){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }

    public void deleteUser(int userId){
        String sql = "delete from users where user_id = ?";
        boolean flag = DBUtil.execute(sql, userId);
        if(flag){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }

    }

    public void inserUser(User user){
        String sql = "insert into users values(null,?,?,?,?,?,?,?)";
        boolean flag = DBUtil.execute(sql, user.getUserName(), user.getUserGender(), user.getUserAge(), user.getUserNation(), user.getUserEmail(), user.getUserPhone(), user.getUserAddr());
        if(flag){
            System.out.println("新增成功");
        }else{
            System.out.println("新增失败");
        }
    }
}