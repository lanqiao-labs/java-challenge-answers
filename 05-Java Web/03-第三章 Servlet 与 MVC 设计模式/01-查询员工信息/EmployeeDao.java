package org.lanqiao.dao;

import org.lanqiao.entity.Employee;
import org.lanqiao.jdbc.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao {

   public Employee getEmployee(int employeeId){
       // 准备 sql
       String sql = "select * from employees where employee_id = ?";
       // 声明 Employee 对象
       Employee employee = null;
       // 获取数据库链接
       Connection conn = JdbcUtil.getConn();
       try {
           // 获取 PreparedStatement 对象
           PreparedStatement ps = conn.prepareStatement(sql);
           // 填充占位符
           ps.setInt(1,employeeId);
           // 执行 sql，获得结果集
           ResultSet resultSet = ps.executeQuery();
           // 分析结果集，为 Employee 对象赋值
           employee = new Employee();
           while (resultSet.next()){
               employee.setEmployeeId(resultSet.getInt(1));
               employee.setEmployeeName(resultSet.getString(2));
               employee.setEmployeeGender(resultSet.getInt(3));
               employee.setEmployeePhone(resultSet.getString(4));
               employee.setEmployeeEmail(resultSet.getString(5));
               employee.setEmployeeAddr(resultSet.getString(6));
           }
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
       return employee;
   }
}