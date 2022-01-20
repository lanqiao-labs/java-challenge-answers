import java.util.Scanner;
/**
 * 使用流程控制语句实现斐波那契数列
 * @author 蓝桥
 */
public class HomeWork1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("请输入要查找的斐波那契数列的位置：");
            int index = sc.nextInt();
            int result = 0;
            // 第一项
            int a = 0;
            // 第二项
            int b = 1;
            if (index == 1) {
                result = a;
            } else if (index == 2) {
                result = b;
            } else if (index >= 3) {
                for (int i = 3; i <= index; i++) {
                    // 保存a + b 的值
                    result = a + b;
                    // 将b 的值给 a
                    a = b;
                    // 将result的值给b
                    b = result;
                }
            } else {
                System.out.println("请输入正整数");
            }
            System.out.println("第" + index + "个位置是" + result);
        }
    }
}