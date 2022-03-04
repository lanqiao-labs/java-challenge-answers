package org.lanqiao.dao.daoimpl;

import org.lanqiao.dao.UserDao;
import org.lanqiao.entity.User;
import org.lanqiao.jdbc.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    // 获取数据总数
    public int getTotalCount() {
        String sql = "select count(*) from users";
        return DbUtil.getTotalCount(sql);
    }

    // 获取 currentPage 页的全部学生信息（每页显示 pageSize 条数据）
    public List<User> getStudentsListForCurrentPage(int currentPage, int pageSize) {
          // 在 mysql 中，分页查询我们是用 limit m,n
        // m 是起始行数下标，n 是每页数据条数
        String sql = "select user_id,user_name,user_gender,user_age,user_nation,user_email,user_phone,user_addr from users limit ?,?";
        Object[] os = {(currentPage-1)*pageSize,pageSize};
        List<User> users = new ArrayList<User>();
        try {
            ResultSet rs = DbUtil.query(sql, os);
            while (rs.next()) {
                int uId = rs.getInt("user_id");
                String uName = rs.getString("user_name");
                int uGender = rs.getInt("user_gender");
                int uAge = rs.getInt("user_age");
                String uNation = rs.getString("user_nation");
                String uEmail = rs.getString("user_email");
                String uPhone = rs.getString("user_phone");
                String uAddr = rs.getString("user_addr");
                // 将查询到的用户信息封装到 user 对象中
                User user = new User(uId, uName, uGender, uAge,uNation,uEmail,uPhone,uAddr);
                // 将封装好的 user 对象存放到 List 集合中
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}