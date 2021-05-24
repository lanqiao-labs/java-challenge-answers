package org.lanqiao.mapper;

import java.util.List;

import org.lanqiao.entity.Department;

public interface IDepartmentMapper {
    /**
     * 查询部门信息
     * @return
     */
    List<Department> queryDepartments();
}