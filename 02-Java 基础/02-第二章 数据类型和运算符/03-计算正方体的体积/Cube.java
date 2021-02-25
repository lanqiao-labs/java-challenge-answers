import java.util.Scanner;

public class Cube {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int v = a*a*a;
    System.out.println("该正方体的体积为："+v);
  }
}