package org.lanqiao.customer;

import java.util.Scanner;

import org.lanqiao.entity.Benz;
import org.lanqiao.entity.Bmw;
import org.lanqiao.entity.Car;
import org.lanqiao.factory.CarFactory;
/**
 * 用户类
 */
public class Customer {
    /**
     * 根据不同的汽车对象，获取不同的汽车信息。
     * @param car 汽车对象
     */
    public void selectCar(Car car){
        if(car != null){
            car.info();
            if(car instanceof Bmw){
                Bmw b = (Bmw) car;
                b.carModel();
            }else if(car instanceof Benz){
                Benz b = (Benz) car;
                b.carConfig();
            }
        }else{
            System.out.println("无对应车辆信息");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请选择车辆品牌：Bmw 或 Benz");
        new Customer().selectCar(CarFactory.getCar(input.next()));
        input.close();
    }
}