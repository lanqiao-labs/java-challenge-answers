package org.lanqiao.test;

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
    public void testQueryCoursesWithSecondCache() throws Exception{
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        
        //创建第一个SqlSession对象
        SqlSession session1 = sqlSessionFactory.openSession();
        ICourseMapper courseMapper1 = session1.getMapper(ICourseMapper.class);
        //第一次查询所有课程信息
        List<Course> courses1 = courseMapper1.queryCourses();
        System.out.println(courses1);
        session1.close();

        //创建第二个SqlSession对象
        SqlSession session2 = sqlSessionFactory.openSession();
        ICourseMapper courseMapper2 = session2.getMapper(ICourseMapper.class);
        //第二次查询所有课程信息
        List<Course> courses2 = courseMapper2.queryCourses();
        System.out.println(courses2);
        session2.close();
    }
}