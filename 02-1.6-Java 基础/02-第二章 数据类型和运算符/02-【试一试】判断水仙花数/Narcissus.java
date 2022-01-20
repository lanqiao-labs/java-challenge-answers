import java.util.Scanner;
/**
 * 判断水仙花数
 * @author 小桃子
 */
public class Narcissus {
  public static void main(String[] args) {
    // 接收控制台输入的三位数
    Scanner input = new Scanner(System.in);
    System.out.print("请输入一个三位整数：");
    int num = input.nextInt();
    // 取出个位
    int units = num % 10;
    // 取出十位
    int tens  = (num / 10) % 10;
    // 取出百位
    int hundreds = num / 100;
    // 计算每位立方和
    int sum = units * units * units + tens * tens * tens + hundreds * hundreds * hundreds;
    // 输出结果
    System.out.println(num + (num == sum ? "是水仙花数" : "不是水仙花数"));
    // 资源释放
    input.close();
  }
}