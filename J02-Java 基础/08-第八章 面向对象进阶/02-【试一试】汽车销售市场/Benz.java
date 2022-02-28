package org.lanqiao.entity;
/**
 * 奔驰车类 - 子类
 */
public class Benz extends Car{
    @Override
    public void info() {
        System.out.println("BENZ");
    }
    /**
     * 提供车配
     */
    public void carConfig(){
        System.out.println("车配可选：");
        System.out.println("5座");
        System.out.println("7座");
        System.out.println("15座");
    }
}