package org.lanqiao.entity;
public class Employee{
    //员工编号
    private int eNo;
    //员工姓名
    private String eName;
    //岗位
    private String job;
    //薪水
    private double salary;

    //添加部门
    private Department dept;

    public int getENo() {
        return this.eNo;
    }

    public void setENo(int eNo) {
        this.eNo = eNo;
    }

    public String getEName() {
        return this.eName;
    }

    public void setEName(String eName) {
        this.eName = eName;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDept() {
        return this.dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "{" +
            " eNo='" + getENo() + "'" +
            ", eName='" + getEName() + "'" +
            ", job='" + getJob() + "'" +
            ", salary='" + getSalary() + "'" +
            "}";
    }
}