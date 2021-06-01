package org.lanqiao.test;

import java.io.Reader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.lanqiao.entity.Employee;
import org.lanqiao.mapper.EmployeeMapper;
import org.junit.Test;

public class TestEmpProject{

    @Test
    public void testqueryAllEmpAndDeptByEname() throws Exception{
        String config = "mybatis-config.xml";
        Reader resource = Resources.getResourceAsReader(config);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = employeeMapper.queryAllEmpAndDeptByEname("庞统");
        System.out.println(employees);
        sqlSession.close();
    }

    @Test
    public void testinsertEmp() throws Exception{
        String config = "mybatis-config.xml";
        Reader resource = Resources.getResourceAsReader(config);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setEmpNo(1015);
        employee.setEName("张无忌");
        employee.setJob("董事长秘书");
        employee.setMgr(1009);
        employee.setSal(30000);
        employee.setHireDate(new Date());
        employee.setDeptNo(20);

        employeeMapper.insertEmp(employee);
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testDeleteEmpByEmpNo() throws Exception{
        String config = "mybatis-config.xml";
        Reader resource = Resources.getResourceAsReader(config);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        employeeMapper.deleteEmpByEmpNo(1001);
        
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testupdateEmpWithProcedure() throws Exception{
        String config = "mybatis-config.xml";
        Reader resource = Resources.getResourceAsReader(config);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        HashMap<String,Object> param = new HashMap<String,Object>();
        param.put("empNo", 1014);
        param.put("job1", "助理1");
        param.put("salary", 2000);

        employeeMapper.updateEmpWithProcedure(param);
        
        
        sqlSession.commit();

        sqlSession.close();
    }
}