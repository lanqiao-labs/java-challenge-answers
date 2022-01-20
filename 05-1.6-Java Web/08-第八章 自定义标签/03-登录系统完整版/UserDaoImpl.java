package org.lanqiao.dao.daoimpl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.lanqiao.dao.UserDao;
import org.lanqiao.entity.User;
import org.lanqiao.util.DbUtil;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
  QueryRunner qr = new QueryRunner(DbUtil.getDataSource());

  @Override
  public User login(String userName, String userPwd) throws SQLException {
//      准备sql
      String sql = "select user_id userId,user_name userName,user_pwd userPwd,user_nickname userNiceName,user_phone userPhone,user_realname userRealName from users where user_name = ? and user_pwd = ?";
//      调用查询
      User loginUser = qr.query(sql, new BeanHandler<User>(User.class), userName, userPwd);
//      返回查询到的对象
      return loginUser;
  }
}