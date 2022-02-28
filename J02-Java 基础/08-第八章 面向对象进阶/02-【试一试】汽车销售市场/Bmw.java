package org.lanqiao.entity;
/**
 * 宝马车类 - 子类
 */
public class Bmw extends Car{
    @Override
    public void info() {
        System.out.println("BMW");
    }
    /**
     * 提供车型
     */
    public void carModel(){
        System.out.println("车型可选：");
        System.out.println("宝马 3 系列");
        System.out.println("宝马 5 系列");
        System.out.println("宝马 7 系列");
    }
}