package org.lanqiao.test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
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
    public void testQueryStudentByStuNoWithConverter() throws IOException{
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();
        ICourseMapper courseMapper = session.getMapper(ICourseMapper.class);

        List<Course> courses = new ArrayList<>();
        courses.add(new Course(8, "Golang语言", "王五"));
        courses.add(new Course(9, "Oracle", "薛仁贵"));
        courses.add(new Course(10, "大数据", "刘邦"));

        courseMapper.insertBatchCourse(courses);
        session.commit();
        session.close();
    }
}