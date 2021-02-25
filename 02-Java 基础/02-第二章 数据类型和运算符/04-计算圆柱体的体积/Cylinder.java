import java.util.Scanner;

public class Cylinder {
public static void main(String[] args) {
    // 定义圆周率为 3.14
    double pi = 3.14;
    // 定义输入对象
    Scanner scanner = new Scanner(System.in);
    // 接收半径 r
    int r = scanner.nextInt();
    // 接收高 h
    int h = scanner.nextInt();
    // 计算体积，由于平方属于未学知识因此采用两个 r 相乘的方法。
    double v = pi*(r*r)*h;
    // 输出体积
    System.out.println("该圆柱体的体积为："+v);
  }
}