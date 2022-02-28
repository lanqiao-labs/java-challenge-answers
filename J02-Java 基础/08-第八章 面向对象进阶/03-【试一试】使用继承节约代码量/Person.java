package org.lanqiao.entity;
/**
 * 父类
 */
public class Person {
    // 姓名属性
    private String name;
    // 电话属性
    private String phone;
  
    // 无参构造
    public Person() {
    }
    // 全参构造
    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{name="+getName()+ ", phone=" +getPhone()+"}";
    }
}