import java.util.Scanner;

/**
 * 计算任意半径的圆的面积
 * @author 小桃子
 */
public class Circle {
    public static void main(String[] args) {
        // 声明半径变量 r
        int r = 0;
        // 声明圆周率常量 PI
        final float PI=3.14f;
        // 声明面积变量 s
        float s;
        // 接收键入输入的半径信息
        Scanner input = new Scanner(System.in);
        System.out.print("请输入圆的半径：");
        r = input.nextInt();
        // 根据公式计算圆面积
        s = PI * r * r;
        System.out.print("圆的面积为："+s);
        // 资源释放
        input.close();
    }
}