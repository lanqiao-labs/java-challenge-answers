package org.lanqiao.test;

import org.lanqiao.entity.Figure;
import org.lanqiao.entity.Rectangle;
import org.lanqiao.entity.Triangle;

public class Test {

    public static void main(String[] args) {
        // 创建对象
        Figure rec = new Rectangle(2,4);
        Figure tri = new Triangle(2,3,4);
        // 调用并输出方法
        System.out.println("矩形的周长为："+rec.getPerimeter());
        System.out.println("矩形的面积为："+rec.getArea());
        System.out.println("三角形的周长为："+tri.getPerimeter());
        System.out.println("三角形的面积为："+tri.getArea());
    }
}
