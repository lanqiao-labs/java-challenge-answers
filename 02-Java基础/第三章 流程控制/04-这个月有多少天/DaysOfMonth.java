import java.util.Scanner;

public class DaysOfMonth {
    public static void main(String[] args) {
        // 创建控制台输入所需的对象
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要查询的月份：");
        // 接收控制台输入的月份
        int month = scanner.nextInt();
        // 通过 switch 来判断输入的月份有多少天，每个 case 都需要加上 break
        switch(month){
            case 1:
                System.out.println(month+"月有31天");
                break;
            case 2:
                System.out.println(month+"月有28天");
                break;
            case 3:
                System.out.println(month+"月有31天");
                break;
            case 4:
                System.out.println(month+"月有30天");
                break;
            case 5:
                System.out.println(month+"月有31天");
                break;
            case 6:
                System.out.println(month+"月有30天");
                break;
            case 7:
                System.out.println(month+"月有31天");
                break;
            case 8:
                System.out.println(month+"月有31天");
                break;
            case 9:
                System.out.println(month+"月有30天");
                break;
            case 10:
                System.out.println(month+"月有31天");
                break;
            case 11:
                System.out.println(month+"月有30天");
                break;
            case 12:
                System.out.println(month+"月有31天");
                break;
        }
    }
}