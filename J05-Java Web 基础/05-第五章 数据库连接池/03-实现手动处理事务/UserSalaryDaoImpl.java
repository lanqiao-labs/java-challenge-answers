package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.lanqiao.dao.UserSalaryDao;
import org.lanqiao.entity.UserSalary;
import org.lanqiao.util.JDBCUtil;

import java.sql.SQLException;

public class UserSalaryDaoImpl implements UserSalaryDao {
    QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
    
    public void addSalary(int userId,double salary) throws SQLException {
        String sql = "update user_salary set salary = ? where id = ?";
        queryRunner.update(sql, salary, userId);
    }

    
    public void subtractSalary(double salary) throws SQLException {
        String sql = "update user_salary set salary = ? where id = 1";
        queryRunner.update(sql, salary);
    }

    
    public UserSalary selectManager(int id) throws SQLException {
        String sql = "select id,name,salary from user_salary where id = ?";
        UserSalary userSalary = queryRunner.query(sql,new BeanHandler<UserSalary>(UserSalary.class),id);
        return userSalary;
    }


}