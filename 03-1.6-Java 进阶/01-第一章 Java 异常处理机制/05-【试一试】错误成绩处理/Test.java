package org.lanqiao.test;

import java.util.Scanner;

import org.lanqiao.entity.Student;
import org.lanqiao.exception.ScoreException;

public class Test {
    public static void main(String[] args) {
        // 接收第一个对象的姓名和成绩
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个学生姓名：");
        String name1 = scanner.next();
        System.out.println("请输入第一个学生成绩：");
        double score1 = scanner.nextDouble();
        // 接收第二个对象的姓名和成绩
        System.out.println("请输入第二个学生姓名：");
        String name2 = scanner.next();
        System.out.println("请输入第二个学生成绩：");
        double score2 = scanner.nextDouble();
        // 使用接收到的属性创建对象
        Student s1 = new Student();
        Student s2 = new Student();
        try {
            // 创建给对象设置属性
            s1.setName(name1);
            s1.setScore(score1);
            s2.setName(name2);
            s2.setScore(score2);
        } catch (ScoreException e) {
            System.out.println(e.toString());
        }
        
    }
}

