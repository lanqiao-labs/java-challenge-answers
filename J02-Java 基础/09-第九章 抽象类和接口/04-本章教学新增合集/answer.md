# **回文字符串答案**

```java
public class Palindrome{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String next = sc.next();
        //将String转换成StringBuilder
        StringBuilder stringBuilder = new StringBuilder(next);
        StringBuilder reverse = stringBuilder.reverse();
        if (reverse.toString().equals(next)){
            System.out.println("是一个回文字符串");
        }else {
            System.out.println("不是一个回文字符串");
        }
	}
}

```

# **拼接字符串答案**

```java
public class Splicing{
	public static void main(String[] args) {
        int[] arr = {1,2,3};
        spliceArr(arr);
        /**
         * 需求:定义一个方法，把int数组中的数据按照指定的格式拼接成一个字符串返回
         * 调用该方法，并在控制台输出结果。
         * 例如：数组为int[] arr = {1,2,3};
         * 执行方法后的输出结果为：[1,2,3]
         */
    }
    public static void spliceArr(int[] arr){
        StringBuilder sb = new StringBuilder("[");
        //思路:先把数据里面的数据遍历出来到StringBuilder里面去
        //通过for循环把它遍历成这个样式[1,2,
        for (int i = 0;i<arr.length-1;i++){
            sb.append(arr[i]+",");
        }
        //最后的格式需要特殊处理
        //arr.length = 3;
        //arr.length - 1 = 2
        //arr[2] = 3;
        //arr[arr.length - 1] = 3
        //3]
        //再把3]去做拼接
        sb.append(arr[arr.length-1]+"]");
        System.out.println(sb);//[1,2,3]
    }
}

```

# **编写带有抽象类的标准JavaBean类答案**

FootballPlayer

```
public abstract class FootballPlayer {
    private String name;
    private int number;

    public abstract void drink();
    public FootballPlayer(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public FootballPlayer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "FootballPlayer{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
```

Forward

```
public class Forward extends FootballPlayer{

    public Forward(String name, int number) {
        super(name, number);
    }

    public Forward() {
    }

    @Override
    public void drink() {
        System.out.println("前锋"+getName()+"正在喝水");
    }
    public void goal(){
        System.out.println("前锋"+getName()+"进球啦");
    }
}
```

Goalkeeper

```
public class Goalkeeper extends FootballPlayer{
    public Goalkeeper(String name, int number) {
        super(name, number);
    }

    public Goalkeeper() {
    }

    @Override
    public void drink() {
        System.out.println("守门员"+getName()+"正在喝水");
    }
    public void saves(){
        System.out.println("守门员"+getName()+"做出了一个非常舒展的扑救");
    }
}
```

Midfielder

```
public class Midfielder extends FootballPlayer {
    public Midfielder(String name, int number) {
        super(name, number);
    }

    public Midfielder() {
    }

    @Override
    public void drink() {
        System.out.println("中场"+getName()+"正在喝水");
    }
    public void pass(){
        System.out.println("中场"+getName()+"做出了一个精准指导传球");
    }
}
```

TestFootBall

```
public class TestFootBall {
    public static void main(String[] args) {
        Forward forward = new Forward();
        forward.setName("Cristiano Ronaldo");
        forward.setNumber(7);
        Goalkeeper goalkeeper = new Goalkeeper("Buffon",1);
        Midfielder midfielder = new Midfielder("KaKa",22);
        forward.goal();
        forward.drink();
        goalkeeper.saves();
        goalkeeper.drink();
        midfielder.pass();
        midfielder.drink();
    }
}
```

# **实现形状类：矩形与圆形的面积和周长计算**

Circle

```
public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}
```

Rectangle

```
public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
}
```

Shape

```
public abstract class Shape {
    public abstract double calculateArea(); //计算面积
    public abstract double calculatePerimeter(); //计算周长
}
```

TestShape

```
public class TestShape {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(4.0, 5.0);
        Shape circle = new Circle(4.0);
        System.out.println("矩形面积: " + rectangle.calculateArea());
        System.out.println("矩形周长: " + rectangle.calculatePerimeter());

        System.out.println("圆的面积: " + String.format("%.2f", circle.calculateArea()));
        System.out.println("圆的周长: " + String.format("%.2f", circle.calculatePerimeter()));
    }
}
```

# **简单的接口实现**

Vehicle

```
public interface Vehicle {
    void start();
    void stop();
}
```

Car

```
public class Car implements Vehicle{
    @Override
    public void start() {
        System.out.println("汽车开始启动了");
    }

    @Override
    public void stop() {
        System.out.println("汽车停止了");
    }
}
```

Test

```
public class Test {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.start();
        myCar.stop();
    }
}
```

# **支付处理系统**

Payment

```
public interface Payment {
    boolean processPayment(double amount);//支付接口
}
```

AlipayPayment

```
public class AlipayPayment implements Payment{
    private String alipayNumber; //支付宝号码

    public AlipayPayment(String alipayNumber) {
        alipayNumber = alipayNumber;
    }

    public AlipayPayment() {
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.println("支付宝账号:"+alipayNumber+"支付宝支付: 金额:$" + amount);
        return true;
    }
}
```

CreditCardPayment

```
public class CreditCardPayment implements Payment{
    private String cardNumber; //信用卡号码

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public CreditCardPayment() {
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.println("信用卡账号:"+cardNumber+"信用卡支付: 金额:$" + amount);
        return true;
    }
}
```

TestPayment

```
public class TestPayment {
    public static void main(String[] args) {
        AlipayPayment alipayPayment = new AlipayPayment("18108391256");
        CreditCardPayment creditCardPayment = new CreditCardPayment("13212396864");
        if (alipayPayment.processPayment(50)){
            System.out.println("支付宝支付成功");
        }
        if (creditCardPayment.processPayment(100)){
            System.out.println("信用卡支付成功");
        }
    }
}
```

