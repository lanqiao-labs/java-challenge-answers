package org.lanqiao.dao;

import org.lanqiao.entity.UserSalary;

import java.sql.SQLException;

public interface UserSalaryDao {

    void addSalary(int userId,double salary) throws SQLException;

    void subtractSalary(double salary) throws SQLException;

    UserSalary selectManager(int id) throws SQLException;
}