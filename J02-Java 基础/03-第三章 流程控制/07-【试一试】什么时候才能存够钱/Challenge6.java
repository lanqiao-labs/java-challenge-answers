import java.util.Scanner;
/**
 * 使用循环和跳转语句实现功能效果
 * @author 蓝桥
 */
public class Challenge6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请指定每天的生活费：");
        int dayMoney = sc.nextInt();
        //存钱的初始化值是0
        int daySum = 0;
        //从第一天开始存储
        int dayCount = 1;
        System.out.print("请指定存款目标：");
        int target = sc.nextInt();
         //每隔五天需要花费的金额
         System.out.print("请指定每隔五天需要花费的金额：");
         int paid = sc.nextInt();
        //因为不确定次数，使用 while 。为了方便使用死循环
        while(true) {
            //累加钱
            daySum += dayMoney;
            //存款超过目标值立即结束。
            if(daySum >= target) {
                System.out.println("共花了"+dayCount+"天存储了"+target+"元，攒够了，先去买手机");
                break;
            }
            if(dayCount%5 == 0) {
                //每隔五天扣除花销
                daySum -= paid;
            }
            //天数变化
            dayCount++;
        }
    }
}