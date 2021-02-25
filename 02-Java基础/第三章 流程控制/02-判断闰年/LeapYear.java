import java.util.Scanner;

public class LeapYear {
  public static void main(String[] args) {
      // 创建键盘录入需要的对象
      Scanner scanner = new Scanner(System.in);
      System.out.println("请输入需要判断的年份：");
      // 接收从控制台输入的年份
      int year = scanner.nextInt();
      // 根据闰年的规则判断当前年份是否属于闰年
      if((year%4==0&&year%100!=0)||year%400==0){
          System.out.println(year+"是闰年！");
      }else{
          System.out.println(year+"是平年");
      }
  }
}