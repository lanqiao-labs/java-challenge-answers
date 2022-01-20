import java.util.Scanner;

/**
 * 计算正方体的体积
 * @author 小桃子
 */
public class Cube {
    public static void main(String[] args) {
        // 从键盘输入正方形边长
        Scanner input = new Scanner(System.in);
        System.out.print("请输入正方体的边长：");
        int a = input.nextInt();
        // 根据公式计算正方体体积
        int v = a * a * a;
        System.out.println("该正方体的体积为：" + v);
        // 资源释放
        input.close();
    }
}