package org.lanqiao.mapper;

import java.util.HashMap;
import java.util.List;

import org.lanqiao.entity.Course;

public interface ICourseMapper {
   List<Course> queryCourseWithLikeTeacherByOrderByCNo(HashMap map);
}