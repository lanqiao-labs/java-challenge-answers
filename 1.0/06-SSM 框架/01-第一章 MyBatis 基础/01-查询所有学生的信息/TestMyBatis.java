package org.lanqiao.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.lanqiao.entity.Student;

public class TestMyBatis {
    @Test
    public void testStudent() throws IOException {
        String resource = "mybatis-config.xml";
        //加载 MyBatis 的配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        //创建 SqlSession 的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能够执行 SQL 映射文件中 SQL 语句的 SqlSession 对象
        SqlSession session = sessionFactory.openSession();
        //指定 SQL 语句对应的标识字符串：namespace+id
        String statement = "org.lanqiao.mapper.StudentMapper.queryStudentByNo";
        //执行查询，返回一个学号为 32 的 Student 对象
        Student student = session.selectOne(statement, 32);
        System.out.println(student);
        session.close();
    }

    @Test
    public void testAllStudent() throws IOException {
        String resource = "mybatis-config.xml";
        //加载 MyBatis 的配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        //创建 SqlSession 的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能够执行 SQL 映射文件中 SQL 语句的 SqlSession 对象
        SqlSession session = sessionFactory.openSession();
        //指定 SQL 语句对应的标识字符串：namespace+id
        String statement = "org.lanqiao.mapper.StudentMapper.queryAllStudent";
        //执行查询，返回一个学号为 32 的 Student 对象
        List<Student> students = session.selectList(statement);
        System.out.println(students);
        session.close();
    }
}