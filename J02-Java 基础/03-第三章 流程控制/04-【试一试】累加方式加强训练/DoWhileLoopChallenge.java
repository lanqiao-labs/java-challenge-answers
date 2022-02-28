import java.util.Scanner;
/**
 * 使用 do ... while 循环方式实现累加操作
 * @author 蓝桥
 */
public class DoWhileLoopChallenge {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.print("请输入剩余天数：");
         int times=0;
         //初始条件
         int start =1;
         //结束条件值
         int days=sc.nextInt();
                //条件判断
         do{
              //循环体
              times += start;
              //条件变化
              start++;
         }while (start<=days);
         System.out.println("共训练了"+times+"次");
    }
}