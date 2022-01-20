package org.lanqiao.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.lanqiao.entity.Department;
import org.lanqiao.mapper.IDepartmentMapper;

public class TestMyBatis {
    @Test
    public void testQueryStudentByStuNoWithConverter() throws IOException{
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();
        IDepartmentMapper departmentMapper = session.getMapper(IDepartmentMapper.class);

        List<Department> departments = departmentMapper.queryDepartments();

        for(Department d:departments){
            System.out.println(d);
            //按需加载
            System.out.println(d.getEmployees());
        }
        session.close();
    }
}