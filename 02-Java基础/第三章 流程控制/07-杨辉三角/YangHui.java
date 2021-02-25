import java.util.Scanner;
public class YangHui {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 行数
        System.out.print("请输入杨辉三角的行数：");
        int lines = scanner.nextInt();
        // 乘数
        int iMul;
        // 杨辉三角公式
        for (int i = 0; i < lines; i++) {
            // 输出空格
            for(int k = 0; k <= lines-i-2 ; k++){
                System.out.print(" ");
            }
            iMul = 1;
            for (int j = 0; j <= i; j++) {
                // 这行代码和下面的代码互换，就会打印错误的杨辉三角，原因是应当先输出在改变值
                System.out.print(iMul + " ");
                // 通过系数变化改变乘数的值
                iMul = iMul * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}