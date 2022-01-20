package org.lanqiao.dao;

import org.lanqiao.entity.User;
import org.lanqiao.jdbc.DbUtil;

public class UserDao {
   public boolean addUser(User user) {
       // 准备 sql
       String sql = "insert into users values(null,?,?,?,?,?,?,?)";
       // 调用 DbUtil 传入 sql 以及对象数据
       Object[] datas = {user.getUserName(),user.getUserGender(),user.getUserAge(),user.getUserNation(),user.getUserEmail(),user.getUserPhone(),user.getUserAddr()};
       return DbUtil.execute(sql, datas);
   }
}