**【试一试】创建一个矩形类【低】**
```
public class Rectangle{

    // 矩形的宽度
    double width;

    // 矩形的高度
    double height;

    // 计算矩形的面积
    double getArea(){
        return width*height;
    }

    // 计算矩形的周长
    double getPerimeter(){
        return 2*(width*height);
    }
}
```





**【试一试】创建一个电视类【中】**
```
public class TV{

    // 频道属性
    int channel;

    //电视的音量
    int volumeLevel;

    //电视的开关
    boolean on;

    // 打开电视
    void turnOn(){
        this.on=true;
    }

     // 关闭电视
     void turnOff(){
        this.on=false;
    }

    // 频道+1
    void channelUp(){
        this.channel++;
    }

    // 频道-1
    void channelDown(){
        this.channel--;
    }

}
```



**【试一试】定义不同作用域的变量【低】**

```
public class Rectangle{

    // 矩形的宽度，成员变量
    float width;

    // 矩形的高度，成员变量
    float height;


    public static void main(String[] args) {

        // 局部变量
        int num=100;
    }

}
```



**【试一试】定义不同作用域的变量【中】**

```
public class TV{

    // 电视的频道
    int channel=1;

    // 电视的音量
    int volumeLevel=25;

    // 电视的开关
    boolean on;

    public static void main(String[] args) {

        // 局部变量num1
        int num1=100;

        // 局部变量num2
        int num2=200;

        // 输出num1和num2的和
        System.out.println(num1+num2);
    }
}
```



**【试一试】定义不同作用域的变量【高】**

```
public class VariableExample{
    // 成员变量，每个实例拥有独立的副本
    int instanceVariable = 0;

    // 静态变量，类的所有实例共享此副本
    static int staticVariable = 0;

    VariableExample() {
        // 实例变量+1
        instanceVariable++;
        // 静态变量+1
        staticVariable++;
    }
    
    public static void main(String[] args) {
        // 1.创建第一个VariableExample 对象ve1
        VariableExample ve1=new VariableExample();
        // 2.输出ve1实例变量instanceVariable的值
        System.out.println("实例变量的值是："+ve1.instanceVariable);
        // 3.输出静态变量staticVariable的值
        System.out.println("静态变量的值是："+staticVariable);
        // 4.创建第二个VariableExample 对象ve2
        VariableExample ve2=new VariableExample();
        // 5.输出ve1实例变量instanceVariable的值
        System.out.println("实例变量的值是："+ve2.instanceVariable);
        // 6.输出静态变量staticVariable的值
        System.out.println("静态变量的值是："+staticVariable);
    }
}
```



**【试一试】创建一个圆形类【中】**

```
public class Circle{
    // 圆形的半径r
    double r;

    // 计算圆形的面积方法
    double getArea(){
        return 3.14*r*r;
    }
    
    // 计算圆形的周长方法
    double getPerimeter(){
        return 3.14*r*2;
    }

}

import java.util.Scanner;

public class TestCircle{

    public static void main(String[] args) {
        // 创建Scanner对象sc
        Scanner sc=new Scanner(System.in);
        // 创建对象
        Circle c1=new Circle();
        // 请输入圆形的半径
        System.out.println("请输入圆形的半径：");
        c1.r=sc.nextInt();
        // 调用方法输出圆形的面积和周长
        System.out.println("圆的面积为："+c1.getArea());
        System.out.println("圆的周长为："+c1.getPerimeter());
        // 释放资源
        sc.close();

    }
}
```



**【试一试】创建一个游客类【高】**

```
public class Visitor{

    // 游客姓名
    String name="张三";

    // 游客年龄
    int age=20;


    // 购票方法
    String buyTicket(){
        // 定义局部变量存储结果
        String result="";
        // 购票的判断
        if(this.age>=18 && this.age<=60){
            result= this.name+"年龄为"+this.age+"岁，门票20元";
        }else{
            result= this.name+"年龄为"+this.age+"岁，门票免费";
        }
        return result;
    }

}

public class TestVisitor{

    public static void main(String[] args) {
        // 创建游客对象
        Visitor visitor=new Visitor();

        // 输出购票信息
        System.out.println(visitor.buyTicket());

        // 修改游客的姓名
        visitor.name="李四";

        // 修改游客的年龄
        visitor.age=10;

        // 重新输出购票信息
        System.out.println(visitor.buyTicket());
    }
}
```

