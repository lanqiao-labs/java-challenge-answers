package org.lanqiao.mapper;

import java.util.List;

import org.lanqiao.entity.Course;

public interface ICourseMapper {
    /**
     * 向课程表中批量插入数据
     * @param courses
     */
   public void insertBatchCourse(List<Course> courses);
}