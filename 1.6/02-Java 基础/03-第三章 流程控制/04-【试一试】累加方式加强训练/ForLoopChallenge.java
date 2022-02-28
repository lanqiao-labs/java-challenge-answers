import java.util.Scanner;
/**
 * 使用 for 循环方式实现累加操作
 * @author 蓝桥
 */
public class ForLoopChallenge {
        public static void main(String[] args) {
             Scanner sc = new Scanner(System.in);
             System.out.print("请输入剩余天数：");
             //训练总次数
             int times=0;
               //初始条件          //条件判断 //条件变化
             for(int days=sc.nextInt();days>0;days-- ){
                   //循环体
                   times += days;
             }
             System.out.println("共训练了"+times+"次");
        }
}