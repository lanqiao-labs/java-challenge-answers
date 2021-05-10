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
import org.lanqiao.mapper.ICourseMapper;

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
        
        ICourseMapper iCourseMapper = session.getMapper(ICourseMapper.class);

        List<Course> courses = iCourseMapper.queryAllCourse();

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

        Course course = new Course(8,"人工智能","王老七");

        ICourseMapper iCourseMapper = session.getMapper(ICourseMapper.class);

        iCourseMapper.addCourse(course);

        session.commit();

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
        String statement = "org.lanqiao.mapper.CourseMapper.updateCourse";

        Course course = new Course(1,"软件测试","李珍");

        ICourseMapper iCourseMapper = session.getMapper(ICourseMapper.class);

        iCourseMapper.updateCourse(course);

        session.commit();

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
        ICourseMapper iCourseMapper = session.getMapper(ICourseMapper.class);

        iCourseMapper.deleteCourse(8);

        session.commit();

        session.close();
    }
}