import java.util.Scanner;
/**
 * 挑战 - 计算 Java 工程师的薪资
 * @author 小桃子
 */
public class CalSalary {
    public static void main(String[] args) {
        // Java工程师月薪
        double engSalary = 0.0;
        // 从控制台获取输入的对象
        Scanner input = new Scanner(System.in);
        // 底薪
        int basSalary = 3000;//默认值3000
        System.out.print("请输入Java工程师底薪：");
        // 从控制台获取输入—底薪，赋值给basSalary
        basSalary = input.nextInt();
        // 月工作完成分数（最小值为0，最大值为150）
        int comResult = 100;//默认值100
        System.out.print("请输入Java工程师月工作完成分数（最小值为0，最大值为150）：");
        // 从控制台获取输入—月工作完成分数，赋值给comResult
        comResult = input.nextInt();
        // 月实际工作天数
        double workDay = 22;//默认值22
        System.out.print("请输入Java工程师月实际工作天数：");
        // 从控制台获取输入—月实际工作天数，赋值给workDay
        workDay = input.nextDouble();
        System.out.print("请输入Java工程师月应扣保险数：");
        // 从控制台获取输入—月应扣保险数，赋值给insurance
        double insurance = input.nextDouble();
        // Java工程师月薪= 底薪 + 底薪×25%×月工作完成分数/100 + 15×月实际工作天数-月应扣保险数
        engSalary = basSalary + basSalary * 0.25 * comResult / 100 + 15 * workDay - insurance;
        System.out.println("Java工程师月薪为：" + engSalary);

        // 资源释放
        input.close();
    }
}