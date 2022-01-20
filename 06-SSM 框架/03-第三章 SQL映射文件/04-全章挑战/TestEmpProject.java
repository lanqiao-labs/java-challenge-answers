package org.lanqiao.test;

import java.io.Reader;
import java.util.ArrayList;
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
    public void testQueryAllEmpAndDeptByEname() throws Exception{
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
    public void testInsertEmp() throws Exception{
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
    public void testUpdateEmpWithProcedure() throws Exception{
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

    @Test
    public void testQueryAllEmps() throws Exception{
        String config = "mybatis-config.xml";
        Reader resource = Resources.getResourceAsReader(config);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = employeeMapper.queryAllEmps();
        System.out.println(employees);
        sqlSession.close();
    }


    @Test
    public void testQueryEmpWithLike() throws Exception{
        String config = "mybatis-config.xml";
        Reader resource = Resources.getResourceAsReader(config);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = employeeMapper.queryEmpWithLike("刘");
        System.out.println(employees);
        sqlSession.close();
    }

    @Test
    public void testUpdateEmpWithSet() throws Exception{
        String config = "mybatis-config.xml";
        Reader resource = Resources.getResourceAsReader(config);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        employee.setEmpNo(1010);
        employee.setSal(13000);
        employeeMapper.updateEmpWithSet(employee);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertEmpWithForeach() throws Exception{
        String config = "mybatis-config.xml";
        Reader resource = Resources.getResourceAsReader(config);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Employee> employees = new ArrayList<Employee>();

        for(int i = 5;i<=10 ;i++){
            Employee employee = new Employee();
            employee.setEmpNo(1010+i);
            employee.setEName("张三"+i);
            employee.setSal(13000);
            employee.setJob("销售员"+i);
            employee.setMgr(1006);
            employee.setHireDate(new Date());
            employee.setSal(2000);
            employee.setComm(500);
            employee.setDeptNo(30);
            employees.add(employee);
        }
        
        employeeMapper.insertEmpWithForeach(employees);
        sqlSession.commit();
        sqlSession.close();
    }
}