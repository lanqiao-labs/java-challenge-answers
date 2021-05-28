package org.lanqiao.test;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.lanqiao.entity.Course;
import org.lanqiao.mapper.CourseMapper;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import tk.mybatis.mapper.mapperhelper.MapperHelper;


public class TestMyBatis {
    
    @Test
    public void testRunGeneratorConfig() throws Exception{
        List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(
				Resources.getResourceAsStream("generatorConfig.xml"));
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		for (String warning : warnings) {
			System.out.println(warning);
		}
    }

    @Test
    public void testInsertCourse() throws Exception{
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        //创建一个MapperHelper
		MapperHelper mapperHelper = new MapperHelper();
		//截获属于通用mapper的方法进行处理			
		mapperHelper.processConfiguration(session.getConfiguration());
        CourseMapper courseMapper = session.getMapper(CourseMapper.class);
    
        Course course = new Course();
        course.setCname("Python");
        course.setTeacher("张三");
        
        courseMapper.insertSelective(course);
        session.commit();
        session.close();
    }

    @Test
    public void testUpdateCourseByCNo() throws Exception{
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        //创建一个MapperHelper
		MapperHelper mapperHelper = new MapperHelper();
		//截获属于通用mapper的方法进行处理			
		mapperHelper.processConfiguration(session.getConfiguration());
        CourseMapper courseMapper = session.getMapper(CourseMapper.class);
    
        Course course = new Course();
        course.setCno(1);
        course.setCname("web前端");
        course.setTeacher("李四");
        
        courseMapper.updateByPrimaryKey(course);
        session.commit();
        session.close();
    }
}