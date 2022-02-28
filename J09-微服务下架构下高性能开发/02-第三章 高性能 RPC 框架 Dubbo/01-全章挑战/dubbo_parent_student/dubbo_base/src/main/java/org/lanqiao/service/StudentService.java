package org.lanqiao.service;

import java.util.List;

import org.lanqiao.pojo.Student;

public interface StudentService {
    
    /**
     * 查询所有学生的信息
     * @return
     */
    public List<Student> findAllStudent();

    /**
     * 根据学生编号查询学生信息
     * @param sNo 学生编号
     * @return
     */
    public Student findStudentBySno(Integer sNo);
}