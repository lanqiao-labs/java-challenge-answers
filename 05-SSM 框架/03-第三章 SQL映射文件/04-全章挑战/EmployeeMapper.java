package org.lanqiao.mapper;

import java.util.HashMap;
import java.util.List;

import org.lanqiao.entity.Employee;

public interface EmployeeMapper {
    List<Employee> queryAllEmpAndDeptByEname(String eName);

    public void insertEmp(Employee employee);

    public void deleteEmpByEmpNo(int empNo);

    public void updateEmpWithProcedure(HashMap<String,Object> param);

    public List<Employee> queryAllEmps();

    /**
     * 模糊查询
     * @return
     */
    public List<Employee> queryEmpWithLike(String eName);

    /**
     * 使用动态 SQL 进行修改
     * @param employee
     */
    public void updateEmpWithSet(Employee employee);

    /**
     * 批量插入数据
     * @param employees
     */
    public void insertEmpWithForeach(List<Employee> employees);
}