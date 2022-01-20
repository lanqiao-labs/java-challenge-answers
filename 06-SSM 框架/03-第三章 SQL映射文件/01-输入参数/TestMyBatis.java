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
    public void testQueryByName() throws IOException{
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        // 使用Mapper动态代理方式查询
        ICourseMapper courseMapper = session.getMapper(ICourseMapper.class);
        // 执行查询，传入String类型的“张”
        HashMap<String,String> map = new HashMap<>();
        map.put("teacher", "张");
        map.put("cNo", "cNo");
        List<Course> course = courseMapper.queryCourseWithLikeTeacherByOrderByCNo(map);
        System.out.println(course);
        session.close();
    }
}