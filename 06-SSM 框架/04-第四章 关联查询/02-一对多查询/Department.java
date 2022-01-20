package org.lanqiao.entity;

import java.util.List;

public class Department {
    // 部门编号
    private int dNo;
    // 部门名称
    private String dName;

    //部门下的所有员工
    List<Employee> employees;

    public int getDNo() {
        return this.dNo;
    }

    public void setDNo(int dNo) {
        this.dNo = dNo;
    }

    public String getDName() {
        return this.dName;
    }

    public void setDName(String dName) {
        this.dName = dName;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}