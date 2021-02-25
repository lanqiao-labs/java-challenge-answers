import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        // 创建控制台输入对象
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要打印的三角形行数：");
        // 接收控制台输入的行数
        int line = scanner.nextInt();
        // 定义循环初始值
        int i = 0;
        // 开启外层循环，条件为 i<line 这样可以打印出 line 行的三角形
        while(i<line){
            // 定义内层循环的初始值
            int j = 0;
            int l = 0;
            // 开启内层循环，用于输出每行星号前的空格
            while(l<line-i-1){
                System.out.print(" ");
                l++;
            }
            // 开启内层循环，用于控制每行星号的个数，星号个数受行号控制
            while(j<=i*2){
                System.out.print("*");
                // 定义内层循环步长
                j++;
            }
            // 由于内层循环使用的是不换行打印，因此在此处需要加一句换行
            System.out.println();
            // 定义外层循环步长
            i++;
        }
    }
}