package org.lanqiao.controller;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboReference;
import org.lanqiao.pojo.Student;
import org.lanqiao.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/consumer")
@RestController
public class StudentController {
    
    @DubboReference
    private StudentService studentService;

    /**
     * 查询所有学生的信息
     * @return
     */
    @GetMapping("/selectAllStudent")
    public List<Student> selectAllStudent(){
        return studentService.findAllStudent();
    }

    /**
     * 查询所有学生的信息
     * @param sNo 学生编号
     * @return
     */
    @GetMapping("/selectStudentBySno")
    public Student selectStudentBySno(Integer sNo){
        return studentService.findStudentBySno(sNo);
    }
}