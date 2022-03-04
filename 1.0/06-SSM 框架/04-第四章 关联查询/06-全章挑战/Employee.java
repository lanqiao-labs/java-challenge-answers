package org.lanqiao.entity;

import java.util.Date;

public class Employee{
    // 员工编号
    private int empNo;
    //员工姓名
    private String eName;
    //岗位
    private String job;
    //直接上级
    private int mgr;
    //入职日期
    private Date hireDate;
    //工资
    private double sal;
    //奖金
    private double comm;
    //部门编号
    private int deptNo;
    //部门名称
    private String dName;
    
    //部门对象
    private Department department;

    public int getEmpNo() {
        return this.empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
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

    public int getMgr() {
        return this.mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public Date getHireDate() {
        return this.hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public double getSal() {
        return this.sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public double getComm() {
        return this.comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public int getDeptNo() {
        return this.deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getDName() {
        return this.dName;
    }

    public void setDName(String dName) {
        this.dName = dName;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    @Override
    public String toString() {
        return "{" +
            " empNo='" + getEmpNo() + "'" +
            ", eName='" + getEName() + "'" +
            ", job='" + getJob() + "'" +
            ", mgr='" + getMgr() + "'" +
            ", hireDate='" + getHireDate() + "'" +
            ", sal='" + getSal() + "'" +
            ", comm='" + getComm() + "'" +
            ", deptName='" + getDName() + "'" +
            "}";
    }
}