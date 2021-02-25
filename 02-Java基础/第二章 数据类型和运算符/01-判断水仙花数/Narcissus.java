import java.util.Scanner;

public class Narcissus {
  public static void main(String[] args) {
      // 接收控制台输入的三位数
      Scanner scanner = new Scanner(System.in);
      int num = scanner.nextInt();
      // 取出个位
      int units = num%10;
      // 取出十位
      int tens  = (num/10)%10;
      // 取出百位
      int hundreds = num/100;
      // 计算每位立方和
      int sum = units*units*units+tens*tens*tens+hundreds*hundreds*hundreds;
      // 输出结果
      System.out.println(num+(num==sum?"是水仙花数":"不是水仙花数"));
  }
}