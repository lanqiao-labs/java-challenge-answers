import java.util.Scanner;
/**
 * 使用流程控制语句解决鸡兔同笼问题
 * @author 蓝桥
 */
public class HomeWork2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入头的总数：");
        int heads =sc.nextInt();
        System.out.print("请输入脚的总数：");
        int foots =sc.nextInt();
        // 鸡
        int j=0;
         //兔
        int t=0;
        for(j=0;j<=heads;j++) {
           //兔的只数等于总数 - 鸡的数
            t=heads-j;
            //如果鸡和兔的脚总数是脚的总数 就找到正确答案
            if(2*j+4*t==foots) {
                System.out.println("鸡有"+j+"只，兔有"+t+"只");
            }
        }
    }
}