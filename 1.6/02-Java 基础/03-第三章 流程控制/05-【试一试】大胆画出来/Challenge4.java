import java.util.Scanner;
/**
 * 根据不同的选择显示用星号组成的图形
 * @author 蓝桥
 */
public class Challenge4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String chooice = null;
        goDown: while (true) {
            System.out.println("\n----------------------");
            System.out.println("1、矩形");
            System.out.println("2、直角三角形");
            System.out.println("3、等腰三角形");
            System.out.println("4、菱形");
            System.out.println("5、心形");
            System.out.println("----------------------");
            System.out.print("请选择要打印的图形：");
            chooice = sc.next();
            switch (chooice) {
                case "1":
                    System.out.print("请指定矩形的行数:");
                    int rows = sc.nextInt();
                    System.out.print("请指定矩形的列数:");
                    int columns = sc.nextInt();
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < columns; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case "2":
                    System.out.print("请指定直角三角形的高:");
                    int high = sc.nextInt();
                    for (int i = 1; i <= high; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case "3":
                    System.out.print("请指定等腰三角形的高:");
                    high = sc.nextInt();
                    for (int i = 1; i <= high; i++) {
                        // 打印空白倒直角三角
                        for (int j = high; j > i; j--) {
                            System.out.print(" ");
                        }
                        for (int j = 1; j <= 2 * i - 1; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case "4":
                    System.out.print("请指定菱形的行高:");
                    int gao = sc.nextInt() + 2;
                    for (int i = 1; i <= gao; i++) {
                        if (i <= gao / 2) {// 打印上半部正等腰三角形
                            for (int j = 1; j <= gao / 2 - i; j++)
                                System.out.print(" ");
                            for (int k = 1; k <= 2 * i - 1; k++)
                                System.out.print('*');
                        } else {// 打印下半部倒等腰三角形
                            int end = gao % 2 == 0 ? 2 * (i - gao / 2) : 2 * (i - gao / 2) + 1;
                            for (int j = gao / 2 + 1; j <= i; j++)
                                System.out.print(" ");
                            for (int k = gao - 2; k >= end; k--)
                                System.out.print('*');
                        }
                        if(i<=gao-2){
                            System.out.println();
                        }

                    }
                    break;
                case "5":

                for (int i = 0, k = 0; i < 14; i++) {
                    if (i < 3) {
                        for (int j = 0; j < 5 - 2 * i; j++) {
                            System.out.print(" ");
                        }
                        if (i == 2) {
                            for (int j = 0; j < 6 + 4 * i - 1; j++) {
                                System.out.print("*");
                            }
                            for (int j = 0; j < 7 - 4 * i + 2; j++) {
                                System.out.print(" ");
                            }
                            for (int j = 0; j < 6 + 4 * i - 1; j++) {
                                System.out.print("*");
                            }
                        } else {
                            for (int j = 0; j < 6 + 4 * i; j++) {
                                System.out.print("*");
                            }
                            for (int j = 0; j < 7 - 4 * i; j++) {
                                System.out.print(" ");
                            }
                            for (int j = 0; j < 6 + 4 * i; j++) {
                                System.out.print("*");
                            }
                        }
                    } else if (i < 6) {
                        for (int j = 0; j < 29; j++) {
                            System.out.print("*");
                        }
                    } else {
                        if (i == 13) {
                            for (int j = 0; j < 2 * (i - 6); j++) {
                                System.out.print(" ");
                            }
                            System.out.print("*");
                        } else {
                            for (int j = 0; j < 2 * (i - 6) + 1; j++) {
                                System.out.print(" ");
                            }
                            for (int j = 1; j < 28 - 4 * k; j++) {
                                System.out.print("*");
                            }
                            k++;
                        }
                    }
                    System.out.println();
                }
                    break;
                case "0":

                    break goDown;
                default:
                    break;
            }
        }
        System.out.println("打印结束");
    }
}