import java.util.Scanner;

public class Print {
    static Scanner input = new Scanner(System.in);
    static int m = 0 ;//行数
    static int n = 0 ; //列数

    //当前正在打印的数字是： arr[row][column]
    static int row = 0, column = 0;
    // 约定打印的方向
    static int right = 0;
    static int down = 1;
    static int left = 2;
    static int up = 3;
    static int [][]arr  = null ;
    //当前正在打印的方向（从“右”开始）
    static int direction = right;
    //当前正在打印第几圈
    static int circle = 1;
    //当前正在打印第几个数字
    static int count = 0;

    //输入行号、列号，并初始化二维数组
    public static void input(){
        //行数
        System.out.println("请输入行数：");
         m = input.nextInt();
        //列数
        System.out.println("请输入列数：");
         n = input.nextInt();;
         arr  = new int[m][n];
    }

    //填充二维数组
    public static void fillArray(){
        while (count < m * n) {
            count++;
            arr[row][column] = count;
            switch (direction) {
                case 0:
                    // 向右打印时，打印的位置逐步右移
                    if (column < n - circle) {
                        column++;
                    } else {
                        //从“向右打印”切换到“向下打印”
                        direction = down;
                        row++;
                    }
                    break;
                case 1:
                    if (row < m - circle) {
                        row++;
                    } else {
                        direction = left;
                        column--;
                    }
                    break;
                case 2:
                    if (column > circle - 1) {
                        column--;
                    } else {
                        direction = up;
                        row--;
                    }
                    break;
                case 3:
                    if (row > circle) {
                        row--;
                    } else {
                        circle++;
                        direction = right;
                        column++;
                    }
                    break;
            }
        }
    }

    //打印
    public static void print(){
        // 输出
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] < 10) {
                    System.out.print(arr[i][j] + " " + " ");
                } else {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        //输入行号、列号，并初始化二维数组
        input();
        //填充二维数组
        fillArray();
        //打印
        print();
    }
}
