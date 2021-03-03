package org.lanqiao.entity;

public class Employee extends Person{
    // 工资
    private double salary;



    public double getSalary() {
        // 获得工资
        return salary;
    }

    public void setSalary(double salary) {
        // 设置工资
        this.salary = salary;
    }

    // 无参构造
    public Employee() {

    }

    // 全参构造
    public Employee(String name, String phone, double salary) {
        super(name,phone);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{name="+getName()+"，phone="+getPhone()+"，salary=" + getSalary() +"}";
    }
}