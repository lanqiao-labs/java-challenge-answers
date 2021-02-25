import java.util.Scanner;

public class Prime {
    /**
     * 素数判断
     * @param num 要判断的数字
     * @return
     */
    public static String checkPrime(int num){
        // 素数的定义是除了 1 和数字本身没有其他因数的数字，因此循环从 2 遍历到 num-1
        for(int i = 2 ; i<num ; i++){
            // 若有一次整除的情况，说明数字不是素数，则立即停止方法并返回结果
            if(num%i==0){
                return num+"不是素数";
            }
        }
        // 若循环结束一次都没有进入 if 中说明该数字是个素数
        return num+"是素数";
    }

    public static void main(String[] args) {
        // 创建控制台输入所需的对象
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数字");
        // 接收控制台输入的数字
        int num = scanner.nextInt();
        // 将控制台输入的数字传入方法并打印结果
        System.out.println(checkPrime(num));

    }
}