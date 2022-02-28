package org.lanqiao.factory;

import org.lanqiao.entity.Benz;
import org.lanqiao.entity.Bmw;
import org.lanqiao.entity.Car;

/**
 * 汽车工厂类
 */
public class CarFactory {
    /**
     * 根据名字，获取不同品牌的汽车对象
     * @param name 品牌名
     * @return Car 汽车对象
     */
    public static Car getCar(String name){
        if("Bmw".equalsIgnoreCase(name)){
            return new Bmw();
        }else if("Benz".equalsIgnoreCase(name)){
            return new Benz();
        }else{
            return null;
        }
    }
}