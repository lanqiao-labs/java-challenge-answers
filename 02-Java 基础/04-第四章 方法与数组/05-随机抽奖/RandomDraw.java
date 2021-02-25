import java.util.Scanner;
import java.util.Random;

public class RandomDraw{
    /**
     * 控制台输入数组长度和数组元素，由于姓名是字符串型，因此数组使用 String 类型
     * @return 包含输入元素的数组
     */
    public static String[] input(){
        // 创建控制台输入对象
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要输入的数组长度：");
        // 接收数组长度
        int length = scanner.nextInt();
        // 创建数组
        String[] names = new String[length];
        // 循环录入数组内各个元素的值
        for(int i = 0 ; i < length; i++){
            System.out.println("请输入第"+(i+1)+"个元素：");
            // 将控制台输入的值放入数组
            names[i] = scanner.next();
        }
        return names;
    }

    public static void main(String[] args) {
        // 开启输入，接收控制台输入的名字
        String[] names = input();
        Random rand = new Random();
		// int randNumber =rand.nextInt(MAX - MIN + 1) + MIN; randNumber 将被赋值为一个 MIN 和 MAX 范围内的随机数
        int randNumber = rand.nextInt(names.length) + 0;
        // 将随机数作为下标取出数组中的姓名并打印
        System.out.println(names[randNumber]);
    }
}