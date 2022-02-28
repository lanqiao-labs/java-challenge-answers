package org.lanqiao.entity;

public class Employee {
    // 工号
    private int employeeId;
    // 姓名
    private String employeeName;
    // 性别
    private int employeeGender;
    // 电话
    private String employeePhone;
    // 邮箱
    private String employeeEmail;
    // 地址
    private String employeeAddr;

    public Employee(int employeeId, String employeeName, int employeeGender, String employeePhone, String employeeEmail, String employeeAddr) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeGender = employeeGender;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddr = employeeAddr;
    }

    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(int employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddr() {
        return employeeAddr;
    }

    public void setEmployeeAddr(String employeeAddr) {
        this.employeeAddr = employeeAddr;
    }
}