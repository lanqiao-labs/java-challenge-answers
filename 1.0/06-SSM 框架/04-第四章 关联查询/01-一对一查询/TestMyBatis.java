package org.lanqiao.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.lanqiao.entity.Employee;
import org.lanqiao.mapper.IEmployeeMapper;

public class TestMyBatis {
    @Test
    public void testQueryStudentByStuNoWithConverter() throws IOException{
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();
        IEmployeeMapper employeeMapper 
            = session.getMapper(IEmployeeMapper.class);
        List<Employee> employees 
            = employeeMapper.queryEmployeeAndDepartmentByDNoWithResultMap();

        for (Employee e : employees) {
            System.out.println("员工编号："+e.getENo()+",\t员工姓名："+e.getEName()+",\t岗位："+e.getJob()
            +",\t薪水："+e.getSalary()+",\t部门编号："+e.getDept().getDNo()+",\t部门名称："+e.getDept().getDName());
        }
        
        session.close();
    }
}