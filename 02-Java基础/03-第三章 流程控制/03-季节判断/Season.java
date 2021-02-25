import java.util.Scanner;

public class Season {
    public static void main(String[] args) {
        // 创建控制台录入所需的对象
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要判断的月份：");
        // 接收控制台输入的月份
        int month = scanner.nextInt();
        // 使用 switch 来判断该月份属于哪个季节，由于多个月份属于同一季节因此可以简写
        switch(month){
            case 3: case 4: case 5:
                System.out.println(month+"月是春季！");
            break;
            case 6: case 7: case 8:
                System.out.println(month+"月是夏季！");
            break;
            case 9: case 10: case 11:
                System.out.println(month+"月是秋季！");
            break;
            case 12: case 1: case 2:
                System.out.println(month+"月是冬季！");
            break;
        }
    }
}