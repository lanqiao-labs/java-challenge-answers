package org.lanqiao.mapper;

import java.util.HashMap;
import java.util.List;

import org.lanqiao.entity.Course;

public interface ICourseMapper {
    /**
     * 查询所有的课程信息
     * @return
     */
   public List<Course> queryAllCourse();

   /**
    * 通过课程编号查询课程信息
    * @param no
    * @return
    */
   public HashMap<String,Object> queryCourseByCNo(int no);
}