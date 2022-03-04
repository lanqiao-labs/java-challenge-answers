import java.util.Scanner;

public class HomeWork3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        godown:
        while (true) {
            System.out.print("请输入你的选择:");
            String chooice = sc.next();
            switch (chooice) {
                case "A":
                    System.out.print("请指定质数查找的范围:");
                    int area = sc.nextInt();
                    int index = 2;
                    System.out.print(area + " 以内的质数有:");
                    while (index < area) {
                        boolean flag = true;
                        for (int i = 2; i <= Math.sqrt(index); i++) {
                            if (index % i == 0) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            System.out.print(index + "  ");
                        }
                        index++;
                    }
                    System.out.println();
                    break;
                case "B":
                    System.out.print("请指定第一个数:");
                    int num1 = sc.nextInt();
                    System.out.print("请指定第二个数:");
                    int num2 = sc.nextInt();
                    int a = num1;
                    int b = num2;
                    int temp = a % b;
                    while (temp != 0) {
                        a = b;
                        b = temp;
                        temp = a % b;
                    }
                    System.out.println(num1 +" 和 " + num2+" 的最大公约数是："+b);
                    break;
                case "C":
                    System.out.print("1000 以内的水仙花数有：");
                    for (int i = 100; i < 1000; i++) {
                        int gw = i % 10;
                        int sw = (i % 100) / 10;
                        int bw = i / 100;
                        if (i == gw * gw * gw + sw * sw * sw + bw * bw * bw) {
                            System.out.print(i + " ");
                        }
                    }  System.out.println();
                    break;
                case "D":
                    System.out.print("请指定奇数的求和范围:");
                    int end = sc.nextInt();
                    int sum = 0;
                    for (int i = 1; i <= end; i += 2) {
                        sum += i;
                    }
                    System.out.println(end + " 范围内的奇数和是:" + sum);
                    break;
                default:
                    System.out.println("功能未开放");
                    break godown;
            }
        } System.out.println("游戏结束");
    }
}