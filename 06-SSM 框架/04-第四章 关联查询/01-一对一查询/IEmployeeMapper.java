package org.lanqiao.mapper;

import java.util.List;

import org.lanqiao.entity.Employee;

public interface IEmployeeMapper {
    List<Employee> queryEmployeeAndDepartmentByDNoWithResultMap();
}