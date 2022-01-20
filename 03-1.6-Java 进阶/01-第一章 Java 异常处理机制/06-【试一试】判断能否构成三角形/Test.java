package org.lanqiao.test;

import java.util.Scanner;

import org.lanqiao.exception.TriangleException;

public class Test {

    public static void main(String[] args) {
        // 创建控制台输入对象
        Scanner scanner = new Scanner(System.in);
        // 接收控制台输入的数字
        System.out.println("请输入第一条边长：");
        int a = scanner.nextInt();
        System.out.println("请输入第二条边长：");
        int b = scanner.nextInt();
        System.out.println("请输入第三条边长：");
        int c = scanner.nextInt();
        // 调用方法处理异常
        try {
            isTriangle(a,b,c);
        } catch (Exception e) {
            System.out.println("不能构成三角形");
        }

    }

    private static void isTriangle(int a, int b, int c) {
        //三条边都不能是负数
        if (a < 0 || b < 0 || c < 0) {
            System.out.println("三条边不能是负数");
        }
        //判断是否构成三角形
        if (a + b > c && a + c > b && b + c > a) {
            System.out.println("三角形的边长分别为" + "a=" + a + " " + "b=" + b + " "    + "c=" + " " + c);
        } else {
            throw new TriangleException(a + "," + b + "," + c + "不能构成三角形！");
        }
    }
}