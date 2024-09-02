##Java中的类_中
~~~java
public class Book{
    int id;
    private String name;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
~~~

##Java中的类_高
~~~java
public class Book{
    private int id;
    private String name;
    private double price;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
~~~

##构造方法_简单
~~~java
public class Stock{
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    public Stock() {
        
    }
    
    public Stock(String symbol, String name, double previousClosingPrice, double currentPrice) {
        this.symbol = symbol;
        this.name = name;
        this.previousClosingPrice = previousClosingPrice;
        this.currentPrice = currentPrice;
    }  
}
~~~

##构造方法_中
~~~java
public class Stock{
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    public Stock() {
        System.out.println("今日收盘价是" + this.currentPrice);
    }
    
    public Stock(String symbol, String name, double previousClosingPrice, double currentPrice) {
        this.symbol = symbol;
        this.name = name;
        this.previousClosingPrice = previousClosingPrice;
        this.currentPrice = currentPrice;
        System.out.println("今日收盘价是" + this.currentPrice);
    }  
}


public class TestStock{
    public static void main(String[] args){
        Stock s1 = new Stock();
        Stock s2 = new Stock("ORCL","Oracle Corporation",35,36);
    }
}
~~~

##方法重载_简单
~~~java
public class Score{
    public void setScore(int num){
        System.out.println("成绩按整数显示设置成功");
    }
    
    public void setScore(char c){
        System.out.println("成绩按等级显示设置成功");
    }
    
    public void setScore(int num,int sort){
        System.out.println("成绩按整数和排名显示设置成功");
    }
}
~~~

##方法重载_中等
~~~java
public class StringProcessor {
    public void processStrings(String s){
        System.out.println("输出结果：" + s.toUpperCase());
    }

    public void processStrings(String s, int index){
        String s1 = s.substring(0, index);
        String s2 = s.substring(index + 1);

        System.out.println("输出结果：" + s1 + s2);
    }

    public void processStrings(String s, int start, int end){
        System.out.println("输出结果：" + s.substring(start, end));
    }
}


import java.util.Scanner;

public class TestStringProcessor{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringProcessor s = new StringProcessor();

        System.out.print("请输入一个字符串：");
        String s1 = sc.next();
        
        s.processStrings(s1);

        System.out.print("请输入一个字符串和一个整数：");

        String s2 = sc.next();
        int index = sc.nextInt();
        
        s.processStrings(s2, index);

        System.out.print("请输入一个字符串和两个整数：");
        String s3 = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();

        s.processStrings(s3, start, end);
    }
}
~~~
