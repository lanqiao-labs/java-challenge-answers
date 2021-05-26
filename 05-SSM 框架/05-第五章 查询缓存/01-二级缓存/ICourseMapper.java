package org.lanqiao.mapper;

import java.util.List;

import org.lanqiao.entity.Course;

public interface ICourseMapper {
    /**
     * 查询所有的课程信息
     * @return
     */
   List<Course> queryCourses();
}