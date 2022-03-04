package org.lanqiao.main;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MethodAndField {
    public static void main(String[] args) {
        // 创建控制台输入对象
        Scanner sc = new Scanner(System.in);
        // 接受输入的全类名
        System.out.println("请输入一个类的全类名：");
        String className = sc.next();
        try {
            // 使用全类名获取 Class 对象
            Class c = Class.forName(className);
            // 获取所有的方法
            Method[] methods = c.getMethods();
            // 遍历输出所有的方法名
            for(Method m : methods){
                System.out.println("方法："+m.getName());
            }
            // 获取所有的属性
            Field[] fields = c.getFields();
            // 输出所有属性的属性名
            for(Field f : fields){
                System.out.println("属性："+f.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}