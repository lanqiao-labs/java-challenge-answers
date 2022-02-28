import java.util.Scanner;

public class CommonDivisor {
    public static void main(String[] args) {
        // 创建控制台输入需要的对象
        Scanner scanner = new Scanner(System.in);
        // 接收控制台输入的两个数字 a b
        System.out.println("请输入第一个数字");
        int a = scanner.nextInt();
        System.out.println("请输入第二个数字");
        int b = scanner.nextInt();
        // 找出两个数字中比较小的那个数字，并将其的值保存在新的变量 min 中
        int min ;
        if(a>b){
            min = b;
        }else{
            min = a;
        }
        // 使用循环从 min 遍历到 1 找到的第一个能把 a 和 b 整除的数字就是最大公约数了,此时我们终循环并将其保存在变量 result 中
        int result = 0;
        for(int i = min ; i>0 ; i--){
            // 这里使用取余的方式判断是否整除，若能整除双方立刻终止循环并输出结果
            if(a % i == 0 && b % i == 0){
                result = i;
                break;
            }
        }
        System.out.println(a+"和"+b+"的最大公约数是："+result);
    }
}

//参考答案2 辗转相除法
//import java.util.Scanner;

// public class CommonDivisor {
//     public static void main(String[] args) {
//         // 创建控制台输入需要的对象
//         Scanner scanner = new Scanner(System.in);
//         // 接收控制台输入的两个数字 a b
//         System.out.println("请输入第一个数字");
//         int a = scanner.nextInt();
//         System.out.println("请输入第二个数字");
//         int b = scanner.nextInt();
//         int c = 0;
//         while ((c = a % b) != 0) {
//             a = b;
//             b = c;
//         }
//         System.out.println(a + "和" + b + "的最大公约数是：" + b);
//     }
// }
