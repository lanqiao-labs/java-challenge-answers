package org.lanqiao.main;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CreateObject {

    public static void main(String[] args) {
        try {
            // 获取 Person 的反射类
            Class c=Class.forName("org.lanqiao.entity.Person");
            //有参构造
            Constructor con2=c.getConstructor(int.class,String.class);
            //创建你对象
            Object obj= con2.newInstance(1,"小蓝");
            System.out.println(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}