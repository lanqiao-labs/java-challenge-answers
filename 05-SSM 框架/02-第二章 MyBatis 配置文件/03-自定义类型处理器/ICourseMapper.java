package org.lanqiao.mapper;

import org.lanqiao.entity.Course;

public interface ICourseMapper {
    Course queryCourseByCNoWithConverter(int cNo);

    public void updateCourseWithConverter(Course course);
}