package org.lanqiao.main;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import org.lanqiao.entity.Person;

public class CreateObject {

    public static void main(String[] args) {
        // 创建配置文件对应的 File 对象
        File f = new File("object.properties");
        // 创建输入流，读取文件
        InputStream is = null;
        try {
            is = new FileInputStream(f);
            // 创建 Properties 对象
            Properties cof = new Properties();
            // 将配置文件加载入 Properties 对象
            cof.load(is);
            // 读取数据创建 Class 对象
            Class c = Class.forName(cof.getProperty("className"));
            // 获取构造方法对象
            Constructor cs = c.getConstructor(int.class,String.class);
            // 使用构造方法对象创建对象，对象数据由配置文件读取
            Person p = (Person) cs.newInstance(Integer.parseInt(cof.getProperty("id")),new String(cof.getProperty("name").getBytes(),"UTF-8"));
            System.out.println(p);
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
       
}