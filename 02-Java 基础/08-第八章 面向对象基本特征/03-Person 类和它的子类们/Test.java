package org.lanqiao.test;


import org.lanqiao.entity.Employee;
import org.lanqiao.entity.Person;
import org.lanqiao.entity.Student;

public class Test {

    public static void main(String[] args) {
        // 创建对象
        Person person = new Person("小蓝","16655557777");
        Student student = new Student("小红","15588885555","大一");
        Employee employee = new Employee("小白","17676765656",4000);
        // 输出对象
        System.out.println(person);
        System.out.println(student);
        System.out.println(employee);
    }
}