package org.lanqiao.mapper;

import java.util.HashMap;
import java.util.List;

import org.lanqiao.entity.Employee;

public interface EmployeeMapper {
    List<Employee> queryAllEmpAndDeptByEname(String eName);

    public void insertEmp(Employee employee);

    public void deleteEmpByEmpNo(int empNo);

    public void updateEmpWithProcedure(HashMap<String,Object> param);
}