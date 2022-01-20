import java.util.Scanner;
/**
 * 计算三位数各位之和
 * @author 小桃子
 */
public class Digit {
    public static void main(String[] args) {
        // 创建键盘输入对象
        Scanner input = new Scanner(System.in);

        System.out.println("请输入一个三位数：");
        // 接收键盘录入的三位数
        int num = input.nextInt();
        // 取出个位
        int units  = num % 10;
        // 取出十位
        int tens = (num / 10) % 10;
        // 取出百位
        int hundreds = num / 100;
        // 求和
        int sum = units + tens + hundreds;
        // 输出结果
        System.out.println(num + "各位之和为："+sum);
        // 资源释放
        input.close();
    }
}