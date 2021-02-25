package com.tz.test;
public class Circle {
    private int radius;  //定义圆的半径 私有属性 int 型
    public double s;   //定义面积 double 型

    //get()、set()方法
    public int getRadius(){
        return radius;
    }
    public  void setRadius(int radius){
        this.radius=radius;
    }
    
    
    public void show(){
        s=Math.PI * Math.pow(radius, 2);  //调用Math类里面的 PI 和Math.pow()方法计算圆的面积
        System.out.println("半径为 2 的圆的面积是：" + s);
    }

}