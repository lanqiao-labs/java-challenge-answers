import java.util.Scanner;
/**
 * 采用 if 语句实现输入职业和入园月份获取票价信息
 * @author 蓝桥
 */
public class IfChallenge1 {
    public static void main(String[] args) {
            double price = 100;
            Scanner sc=new Scanner(System.in);
            System.out.print("请输入您的职业：");
            String job = sc.next();
            System.out.print("请输入您入园的月份：");
            int month = sc.nextInt();
            if(month ==1 ||month ==2 ||month ==6 ||month ==7 ||month ==8 ||month ==12){
                if(job.equals("学生")){
                    price=price*0.8*0.7;
                }else if(job.equals("教师")){
                    price=price*0.8*0.8;
                }else{
                    price=price*0.8;
                }
                System.out.println("您的门票价格为"+price);
            }else if(month ==3 ||month ==4 ||month ==5 ||month ==9 ||month ==10 ||month ==11){
                if(job.equals("学生")){
                    price=price*0.6*0.7;
                }else if(job.equals("教师")){
                    price=price*0.6*0.8;
                }else{
                    price=price*0.6;
                }
                System.out.println("您的门票价格为"+price);
            }else{
                  System.out.println("此月份不存在");
            }
            sc.close();
    }
}