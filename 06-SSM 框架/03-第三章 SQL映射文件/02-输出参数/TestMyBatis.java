package org.lanqiao.test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
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
    public void testQueryAllCourse() throws IOException{
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        // 使用Mapper动态代理方式查询
        ICourseMapper courseMapper = session.getMapper(ICourseMapper.class);
        //查询所有课程信息
        List<Course> course = courseMapper.queryAllCourse();
        System.out.println(course);
        session.close();
    }

    @Test
    public void testQueryCourseByCNo() throws IOException{
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        // 使用Mapper动态代理方式查询
        ICourseMapper courseMapper = session.getMapper(ICourseMapper.class);
        //查询所有课程信息
        HashMap<String,Object> map = courseMapper.queryCourseByCNo(1);
        System.out.println("课程编号："+map.get("no")+"\t课程名称："+map.get("name")+"\t授课老师："+map.get("tName"));
        session.close();
    }
}