package org.lanqiao.mapper;


import java.util.List;

import org.lanqiao.entity.Course;

public interface ICourseMapper {

    /**
     * 根据课程编号，查询课程信息
     * @param cNo
     * @return
     */
    public Course queryCourseNo(int cNo);

    /**
     * 查询所有课程的信息
     * @return
     */
    public List<Course> queryAllCourse();

    /**
     * 新增一门课程信息
     * @param course
     * @return
     */
    public void addCourse(Course course);

    /**
     * 根据课程编号，修改课程的信息
     * @param course
     * @return
     */
    public void updateCourse(Course course);

    /**
     * 根据课程编号删除课程信息
     * @param cNo
     * @return
     */
    public void deleteCourse(int cNo);
}