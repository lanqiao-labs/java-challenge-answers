package org.lanqiao.entity;

public class UserSalary {
    private int id;
    private String name;
    private double salary;

    @Override
    public String toString() {
        return "UserSalary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public UserSalary() {
    }

    public UserSalary(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public UserSalary(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}