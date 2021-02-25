import java.util.Scanner;

class TestFor {
    public static void main(String[] args) {
        int firNum;             //第一个数
        int secNum;            //第二个数
        int maxNum;           //最大数
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        maxNum = input.nextInt();
        System.out.println("数" + maxNum + "的乘法表为：");
        for (firNum = 0, secNum = maxNum; firNum <= maxNum; firNum++, secNum--) {
            System.out.println(firNum + " * " + secNum + " = " + firNum * secNum);
        }
    }
}
