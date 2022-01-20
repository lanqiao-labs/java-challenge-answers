import java.util.Scanner;
/**
 * 实现每月有多少天的功能
 * @author 蓝桥
 */
public class SwitchChallenge3{
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.print("请输入年份：");
            int year = sc.nextInt();
            System.out.print("请输入月份：");
            int month = sc.nextInt();
            switch(month){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    System.out.println(month +"月是大月，有 31 天");
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    System.out.println(month +"月是小月，有 30 天");
                    break;
                case 2:
                    if((year %4 == 0 && year %100 !=0)||(year %100 == 0 && year %400 ==0)){
                        System.out.print(year + "年是闰年，"+month +"月是闰月，有 29 天");
                    }else{
                        System.out.println(month +"月是平月，有 28 天");
                    }
                    break;
                default:
                    System.out.println(month +"月不存在，数值在 1 -- 12 之间");
            }
    }
}