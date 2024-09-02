## 【试一试】输出收银小票
~~~java
import java.util.Scanner;

public class Answer1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入商品总价：");
        double price = sc.nextDouble();
        System.out.print("请输入收银员姓名：");
        String name = sc.next();
        System.out.print("请输入收银日期:");
        String date = sc.next();

        price = price>70?price*0.8:price;
        System.out.println("--------蓝桥超市收银小票--------");
        System.out.println("|价格: "+price+"             ");
        System.out.println("|                           ");
        System.out.println("|收银员: "+name+"            ");
        System.out.println("|                           ");
        System.out.println("|收银日期: "+date+"           ");
        System.out.println("-----------------------------");
    }
}
~~~

## 【试一试】帮小蓝修改代码错误
~~~java
public class Person {
    private String name;
    private int age;

    public void eat(String food){
        System.out.println("eat "+food);
    }

    public Person(){

    }

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
}


public class Student extends Person{

    private double score;// 学生成绩
    int studyCount;// 学习次数

    public void study(){
        System.out.println("学习了"+(++studyCount)+"次！");
    }

    public void eat(String food){
        System.out.println("吃"+food);
    }

    public Student(String name,int age,double score){
        super(name,age);
        this.score = score;
    }

    public static void main(String[] args) {
        Student s1 = new Student("小蓝",18,98.9);
        s1.study();
        s1.eat("薯条");
    }

}
~~~

## 【试一试】数组合并
~~~java

import java.util.Random;

public class Challenge {
    static int[] arr1 = null;
    static int[] arr2 = null;
    static int[] arr3 = null;

    public static int[] generateArray(){
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0;i<arr.length;i++){
            arr[i] = random.nextInt();
        }
        return arr;
    }

    /**
     * 在这个方法中补充合并数组的代码
     * @param arr1 数组一
     * @param arr2 数组二
     * @return 合并后的数组
     */
    public static int[] merge(int[] arr1,int[] arr2){
        int[] arr3  = new int[arr1.length+arr2.length];
        int index = 0;
        for (int i = 0; i < arr1.length; i++) {
            arr3[index] = arr1[i];
            index++;
        }
        for (int i = 0; i < arr2.length; i++) {
            arr3[index] = arr2[i];
            index++;
        }

        return arr3;
    }

    public static void outputArray(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 为第一个数组赋值
        arr1 = generateArray();
        // 为第二个数组赋值
        arr2 = generateArray();
        // 合并两个数组并赋值给第三个数组
        arr3 = merge(arr1,arr2);
        //以下为输出
        System.out.print("第一个数组：");
        outputArray(arr1);
        System.out.print("第二个数组：");
        outputArray(arr2);
        if(arr3!=null){
            System.out.print("合并后的数组：");
            outputArray(arr3);
        }
    }
}
~~~

## 【试一试】递归实现斐波那契数列

~~~java
import java.util.Scanner;

public class Fibonacci {


    // 递归函数，计算斐波那契数列的第n项
    public static long fibonacci(int n){
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入需要打印的项数：");
        int N = scanner.nextInt();
        System.out.print("斐波那契数列的前"+N+"项是：");
        for (int i = 0; i < N; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}
~~~

##【试一试】找出乘积最大的两个数

~~~java
import java.util.Random;

public class MaxProductPair {

    // 调用该方法可以拿到一个长度 20 的随机数组
    public static int[] generateArray(){
        int[] arr = new int[20];
        Random random = new Random();
        for (int i = 0;i<arr.length;i++){
            arr[i] = random.nextInt(2001) - 1000;
        }
        return arr;
    }

    /**
     * 查找整数数组中两个不同元素的最大乘积。
     *
     * @param arr 包含至少两个整数的输入数组。
     * @return 乘积最大的两个数字所在数组。
     */
    public static int[] findMaxProductPair(int[] arr) {
        // 初始化最大值和次大值
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        // 初始化最小值和次小值
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        // 遍历数组
        for (int num : arr) {
            // 更新最大值和次大值
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }

            // 更新最小值和次小值
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        // 计算最大两个正数的乘积
        int maxProduct = max1 * max2;

        // 计算最小两个负数的乘积
        int minProduct = min1 * min2;

        if(maxProduct>minProduct){
            return new int[]{max1,max2};
        }else{
            return new int[]{min1,min2};
        }

    }

    public static void main(String[] args) {
        int[] ints = generateArray();
        System.out.print("原数组是：");
        for(int i:ints){
            System.out.print(i+" ");
        }
        int[] maxProductPair = findMaxProductPair(ints);
        System.out.println();
        System.out.println("乘积最大的两个数字是："+maxProductPair[0]+","+maxProductPair[1]);
        System.out.println("乘积为："+maxProductPair[0]*maxProductPair[1]);
    }
}
~~~

##【试一试】找出指定的成绩

~~~java
import java.util.Scanner;

public class Score {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取学生数量
        System.out.print("请输入学生数量：");
        int n = scanner.nextInt();
        Student[] students = new Student[n];

        // 读取每个学生的姓名和成绩
        for (int i = 0; i < n; i++) {
            System.out.print("请输入第 " + (i + 1) + " 位学生的姓名：");
            String name = scanner.next();  // 如果姓名可能包含空格，使用scanner.nextLine()
            System.out.print("请输入第 " + (i + 1) + " 位学生的成绩：");
            double score = scanner.nextDouble();
            students[i] = new Student();
            students[i].name = name;
            students[i].score = score;
        }

        // 读取要查询的排名
        System.out.print("请输入要查询的排名：");
        int rank = scanner.nextInt();

        // 调用排序和查找方法
        Student student = findAndSortScoreByRank(students, rank);

        // 在main方法中打印找到的学生信息
        if (student != null) {
            System.out.println("排名第 " + rank + " 的学生信息为：");
            System.out.println("姓名： " + student.name);
            System.out.println("成绩： " + student.score);
        } else {
            System.out.println("无效的排名！");
        }

        scanner.close();
    }

    // 冒泡排序学生数组并查找指定排名的学生
    public static Student findAndSortScoreByRank(Student[] students, int rank) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (students[j].score < students[j + 1].score) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        if (rank >= 1 && rank <= n) {
            return students[rank - 1]; // 返回指定排名的学生对象
        } else {
            return null; // 返回null表示无效的排名
        }
    }
}


public class Student {
    public String name;
    public double score;
}
~~~
