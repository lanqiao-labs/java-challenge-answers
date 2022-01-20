package org.lanqiao.mapper;

import org.lanqiao.entity.Department;

public interface IEmployeeMapper {
    /**
     * 根据部门编号查询部门下所有的员工信息
     * @param dNo
     * @return
     */
    Department queryDepartmentAndEmployeesByDNo(int dNo);
}