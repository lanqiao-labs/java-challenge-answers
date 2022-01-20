package org.lanqiao.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.lanqiao.entity.Course;

public class TestMyBatis {
    @Test
    public void testSel() throws IOException{
        String resource = "mybatis-config.xml";
        //加载 MyBatis 的配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        //创建 SqlSession 的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能够执行 SQL 映射文件中 SQL 语句的 SqlSession 对象
        SqlSession session = sessionFactory.openSession();
        //指定 SQL 语句对应的标识字符串：namespace+id
        String statement = "org.lanqian.mapper.CourseMapper.queryAllCourse";
        //执行查询，返回所有的 Course 对象
        List<Course> courses = session.selectList(statement);
        System.out.println(courses);
        session.close();
    }

    @Test
    public void testIns() throws IOException{
        String resource = "mybatis-config.xml";
        //加载 MyBatis 的配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        //创建 SqlSession 的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能够执行 SQL 映射文件中 SQL 语句的 SqlSession 对象
        SqlSession session = sessionFactory.openSession();
        //指定 SQL 语句对应的标识字符串：namespace+id
        String statement = "org.lanqian.mapper.CourseMapper.addCourse";

        Course course = new Course(8,"人工智能","王老七");

        int i = session.insert(statement, course);

        session.commit();

        System.out.println("影响的行数：" + i);

        session.close();
    }

    @Test
    public void testUpd() throws IOException{
        String resource = "mybatis-config.xml";
        //加载 MyBatis 的配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        //创建 SqlSession 的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能够执行 SQL 映射文件中 SQL 语句的 SqlSession 对象
        SqlSession session = sessionFactory.openSession();
        //指定 SQL 语句对应的标识字符串：namespace+id
        String statement = "org.lanqian.mapper.CourseMapper.updateCourse";

        Course course = new Course(1,"软件测试","李珍");

        int i = session.update(statement, course);

        session.commit();

        System.out.println("影响的行数：" + i);

        session.close();
    }
    
    @Test
    public void testDEl() throws IOException{
        String resource = "mybatis-config.xml";
        //加载 MyBatis 的配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        //创建 SqlSession 的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能够执行 SQL 映射文件中 SQL 语句的 SqlSession 对象
        SqlSession session = sessionFactory.openSession();
        //指定 SQL 语句对应的标识字符串：namespace+id
        String statement = "org.lanqian.mapper.CourseMapper.deleteCourse";

        int i = session.delete(statement, 8);

        session.commit();

        System.out.println("影响的行数：" + i);

        session.close();
    }
}