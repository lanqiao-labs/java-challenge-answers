import java.util.Scanner;
/**
 * 采用 if 语句嵌套实现找出三个数中的最大值
 * @author 蓝桥
 */
public class IfChallenge2 {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
          System.out.print("请输入第一个数字：");
          int a =sc.nextInt();
          System.out.print("请输入第二个数字：");
          int b =sc.nextInt();
          System.out.print("请输入第三个数字：");
          int c =sc.nextInt();
          int max ;
          if(a>b){
            if(a>c){
                max =a;
            }else{
                max =c;
            }
          }else{
            if(b>c){
                max =b;
            }else{
                max =c;
            }
          }
          System.out.println("三个数字中最大的数字是:"+max);
          sc.close();
    }
}