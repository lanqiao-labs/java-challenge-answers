import java.util.Scanner;

public class TestTriangle {

    public static void main(String[] args) {
        // 创建控制台录入对象
        Scanner sc = new Scanner(System.in);
        // 接收控制台录入的三条边
        System.out.println("请输入第一条边：");
        double side1 = sc.nextDouble();
        System.out.println("请输入第二条边：");
        double side2 = sc.nextDouble();
        System.out.println("请输入第三条边：");
        double side3 = sc.nextDouble();
        // 利用控制台录入的三条边创建对象
        Triangle triangle = new Triangle(side1,side2,side3);
        // 输出面积和周长
        System.out.println("三角形的面积"+triangle.getArea());
        System.out.println("三角形的边长"+triangle.getPerimeter());
        // 输出三角形的字符串
        System.out.println(triangle.toString());
    }
}