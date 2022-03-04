package org.lanqiao.entity;

public class Student extends Person{
    // 年级属性
    private String grade;

    public String getGrade() {
        //获得年级
        return grade;
    }

    public void setGrade(String grade) {
        //修改年级
        this.grade = grade;
    }

    // 无参构造
    public Student() {

    }

    // 全参构造
    public Student(String name, String phone, String grade) {
        super(name,phone);
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{name="+getName()+"，phone="+getPhone()+"，grade="+getGrade()+"}";
    }
}