package org.lanqiao.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.lanqiao.mapper.StudentMapper;
import org.lanqiao.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAllStudent() {
        return studentMapper.selectList(null);
    }

    @Override
    public Student findStudentBySno(Integer sNo) {
        return studentMapper.selectById(sNo);
    }
    
}