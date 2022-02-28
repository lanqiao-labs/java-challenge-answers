package org.lanqiao.mapper;

import org.lanqiao.entity.Department;

public interface DepartmentMapper {
    public Department queryDepartmentByDNo(String deptNo);
}