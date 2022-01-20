import java.util.Scanner;
/**
 * 使用 while 循环方式实现累加操作
 * @author 蓝桥
 */
public class WhileLoopChallenge {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.print("请输入剩余天数：");
         int times=0;
         //初始条件
         int days=sc.nextInt();
                //条件判断
         while (days>0){
              //循环体
              times += days;
              //条件变化
              days--;
         }
         System.out.println("共训练了"+times+"次");
    }
}