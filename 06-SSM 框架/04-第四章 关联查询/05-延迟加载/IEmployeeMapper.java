package org.lanqiao.mapper;

import java.util.List;

import org.lanqiao.entity.Employee;

public interface IEmployeeMapper {
    /**
     * 根据部门编号查询部门员工信息
     * @param dNo
     * @return
     */
    List<Employee> queryEmployeeByDNo(int dNo);
}