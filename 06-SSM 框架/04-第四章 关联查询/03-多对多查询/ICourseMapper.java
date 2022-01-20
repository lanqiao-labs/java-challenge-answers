package org.lanqiao.mapper;

import java.util.List;

import org.lanqiao.entity.Course;

public interface ICourseMapper {
    /**
     * 查询学习每门课的学生信息
     * @return
     */
    List<Course> queryCoursesAndStudents();
}