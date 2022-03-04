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
    public void testQueryStudentByStuNoWithConverter() throws IOException{
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();
        ICourseMapper courseMapper = session.getMapper(ICourseMapper.class);

        List<Course> courses = courseMapper.queryCoursesAndStudents();

        for (Course course : courses) {
            System.out.println(course+"\n"+course.getStudents());
        }
        session.close();
    }
}