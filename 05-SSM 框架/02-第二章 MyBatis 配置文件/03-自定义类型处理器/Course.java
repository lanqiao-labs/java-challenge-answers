package org.lanqiao.entity;
public class Course {
    // 课程编号
    private int cNo;
    // 课程名称
    private String cName;
    // 任课老师
    private String teacher;
    //课程属性 true:必修课 1 false:选修课 0
    private Boolean cProperties;

    public Course() {
    }

    public Course(int cNo, String cName, String teacher, Boolean cProperties) {
        this.cNo = cNo;
        this.cName = cName;
        this.teacher = teacher;
        this.cProperties = cProperties;
    }

    public int getCNo() {
        return cNo;
    }

    public void setCNo(int cNo) {
        this.cNo = cNo;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Boolean getCProperties() {
        return cProperties;
    }

    public void setCProperties(Boolean cProperties) {
        this.cProperties = cProperties;
    }

    @Override
    public String toString() {
        return "课程编号：" + this.cNo + "\t课程名称：" + this.cName + "\t授课教师：" + this.teacher+"\t课程属性：" + this.cProperties;
    }
}