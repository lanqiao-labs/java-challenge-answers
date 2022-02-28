package org.lanqiao.mapper;

import java.util.List;
import org.lanqiao.entity.Course;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer cno);

    int insert(Course record);

    Course selectByPrimaryKey(Integer cno);

    List<Course> selectAll();

    int updateByPrimaryKey(Course record);

    /**
     * 批量插入数据
     * @param courses
     * @return
     */
    int insertForeach(List<Course> courses);
}