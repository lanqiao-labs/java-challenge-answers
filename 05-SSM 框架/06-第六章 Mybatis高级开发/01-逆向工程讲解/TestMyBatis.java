package org.lanqiao.test;

import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
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

public class TestMyBatis {
    
    /**
     * 逆向工程生成代码
     * @throws Exception
     */
    @Test
    public void testRunGeneratorConfig() throws Exception{
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        String resources = "generatorConfig.xml";
        Reader re = Resources.getResourceAsReader(resources);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(re);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    /**
     * 批量插入数据
     * @throws Exception
     */
    @Test
    public void testBatchInsertCourse() throws Exception{
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        
        //传入参数 ExecutorType.BATCH
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH);
        
        CourseMapper courseMapper = session.getMapper(CourseMapper.class);
        //插入Course 记录
        for(int i = 1; i < 20; i++){
            Course course = new Course();
            course.setCname("Python"+i);
            course.setTeacher("李四"+i);
            courseMapper.insert(course);
        }
        session.commit();
        session.close();
    }

    /**
     * 批量插入数据
     * @throws Exception
     */
    @Test
    public void testInsertCourseForeach() throws Exception{
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        
        //传入参数 ExecutorType.BATCH
        SqlSession session = sqlSessionFactory.openSession();
        
        CourseMapper courseMapper = session.getMapper(CourseMapper.class);
        //插入Course 记录
        List<Course> courses = new ArrayList<>();
        for(int i = 1; i < 20; i++){
            Course course = new Course();
            course.setCname("Python"+i);
            course.setTeacher("李四"+i);
            courses.add(course);
        }
        courseMapper.insertForeach(courses);
        session.commit();
        session.close();
    }

    @Test
    public void testQueryHomeWorkWithPageHelper() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        PageHelper.startPage(2, 5);
        List<Course> clist = courseMapper.selectAll();
        PageInfo<Course> page = new PageInfo<Course>(clist);
        for (Course course : clist) {
            System.out.println(course.getCno() + "\t" + course.getCname() + "\t" + course.getTeacher());
        }
        System.out.println("记录总数：" + page.getTotal() + 
					"\t总页数：" + page.getPages() + 
					"\t当前页码" + page.getPageNum());
        sqlSession.close();
    }
}