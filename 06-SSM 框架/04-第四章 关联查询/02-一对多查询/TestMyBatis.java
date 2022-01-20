package org.lanqiao.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.lanqiao.entity.Department;
import org.lanqiao.mapper.IEmployeeMapper;

public class TestMyBatis {
    @Test
    public void testQueryStudentByStuNoWithConverter() throws IOException{
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();
        IEmployeeMapper employeeMapper = session.getMapper(IEmployeeMapper.class);

        Department department = employeeMapper.queryDepartmentAndEmployeesByDNo(10);

        System.out.println("部门编号："+department.getDNo()+",\t部门名称："+department.getDName()
        +",\t部门下所有员工："+department.getEmployees());
        session.close();
    }
}