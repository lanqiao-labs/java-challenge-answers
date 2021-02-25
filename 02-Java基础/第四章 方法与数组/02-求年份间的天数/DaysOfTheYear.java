import java.util.Scanner;

public class DaysOfTheYear {
    /**
     * 统计年份间相隔天数
     * @param firstYear 第一个年份
     * @param secondYear 第二个年份
     * @return 年份间相隔天数
     */
    public static int sumOfDays(int firstYear,int secondYear){
        // 定义变量保存总天数
        int sum = 0;
        // 统计天数时要注意闰年是 366 天，平年是 365 天
        for(int i = firstYear ; i<secondYear ; i++){
            // 若满足闰年的条件则累加 366 天，反之累加 365 天
            if((i%4==0&&i%100!=0)||i%400==0){
                sum+=366;
            }else{
                sum+=365;
            }
        }
        // 循环结束将累加的天数返回出去
        return sum;
    }

    public static void main(String[] args) {
        // 创建控制台输入所需的对象
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个年份");
        // 接收控制台输入的第一个年份
        int firstYear = scanner.nextInt();
        System.out.println("请输入第二个年份");
        // 接收控制台输入的第二个年份
        int secondYear = scanner.nextInt();
        // 调用方法将控制台输入的数字传入方法中，并保存方法运算的结果。
        int days = sumOfDays(firstYear,secondYear);
        // 打印结果
        System.out.println(firstYear+"至"+secondYear+"之间相隔："+days+"天！");

    }
}