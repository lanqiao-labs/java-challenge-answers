import java.util.Scanner;
/**
 * 计算圆柱体的体积
 * @author 小桃子
 */
public class Cylinder {
    public static void main(String[] args) {
        // 定义圆周率为 3.14
        final float PI = 3.14f;
        // 定义输入对象
        Scanner input = new Scanner(System.in);
        // 接收半径 r
        System.out.println("请输入圆柱底面半径：");
        int r = input.nextInt();
        // 接收高 h
        System.out.println("请输入圆柱的高：");
        int h = input.nextInt();
        // 根据公式计算柱体的体积
        float s= PI * (r * r) ;
        float v = s * h;
        // 输出体积
        System.out.println("该圆柱体的体积为："+ v);
        // 资源释放
        input.close();
    }
}
