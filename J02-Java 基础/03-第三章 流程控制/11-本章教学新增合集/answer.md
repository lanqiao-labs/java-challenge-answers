
# 挑战源码




## 选择游戏位置




  ```java
  import java.util.Scanner;

public class PlayerPosition{
    public static void main(String[] args) {
        //初始化键盘
        Scanner sc = new Scanner(System.in);
        //输出提示语
        System.out.println("请输入您的游戏位置:");
        //键盘接收
        int index = sc.nextInt();
        
        //判断位置
        switch (index) {
            case 1:
                System.out.println("您已选择坦克位置");
                break;
            case 2:
                System.out.println("您已选择打野位置");
                break; 
            case 3:
                System.out.println("您已选择法师位置");
                break;  
            case 4:
                System.out.println("您已选择射手位置");
                break; 
            case 5:
                System.out.println("您已选择辅助位置");
                break;
        
            default:
                System.out.println("请输入1-5范围内的数字");
                break;
        }
        
		//关闭资源
		sc.close();
        
    }
}
  ```



## 根据等级加分

 ```
 import java.util.Scanner;

public class AddGrade{
    public static void main(String[] args) {
        //初始化键盘
        Scanner sc = new Scanner(System.in);
        //声明初始平时成绩
        int grade = 60;
        //提示语句
        System.out.println("请输入学生等级:");
        String level = sc.nextLine();
        
        //判断加分
        switch (level) {
            case "A":
                grade+=10;
                break;
            case "B":
                grade+=5;
                break;
            case "C":
                grade+=3;
                break;
            case "D":
                
                break;
            default:
                System.out.println("请输入正确的等级（A、B、C、D）");
                break;
        }

        //输出结果
        System.out.println("最终的平时成绩为："+grade);
        //关闭资源
        sc.close();


    }
}
```
##计算偶数和
```
public class Even{
    public static void main(String[] args) {
        //声明一个变量作为和
        int sum = 0;
        for (int i = 0; i <=50; i=i+2) {
            //累加计算
            sum+=i;
        }
        //输出结果
        System.out.println("0-50的偶数和为："+sum);
    }
}
```
##计算小组平均分
```
import java.util.Scanner;

public class Average{
    
    public static void main(String[] args) {
        //初始化键盘录入
        Scanner sc = new Scanner(System.in);
        //声明sum
        double sum = 0;
        double avg =0;
    
        for(int i =1;i<=5;i++){
            System.out.println("请输入第"+i+"位同学的成绩");
            double score = sc.nextDouble();
            //成绩相加
            sum+=score;
        }
        //计算平均分
        avg = sum/5;
        System.out.println("该小组平均分为:"+avg);
        //关闭资源
        sc.close();

    }
}
```
##逢七过
```
public class Game{
    public static void main(String[] args) {
        for (int i = 1; i <=50; i++) {
            //判断是否是7的倍数或者含有7
            if(i%7==0 || (i-7)%10==0){
            	//跳过当前数字
                continue;
            }
            //输出结果
            System.out.println(i);
            
        }
    }
}
```
