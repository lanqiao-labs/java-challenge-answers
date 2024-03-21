import java.util.Scanner;

/**
 * 定义一个 PerformanceAnalysis 类
 * @author lanqiao
 */
public class PerformanceAnalysis{
     static Scanner scanner = new Scanner(System.in);
    /**
     * 控制台输入数组长度和数组元素，需要注意成绩可能不是整数，因此使用 double 类型的数组
     * @return 包含输入元素的数组
     */
    public static double[] input(){
        // 创建控制台输入对象
    
        System.out.println("请输入要输入的成绩数组长度：");
        // 接收数组长度
        int length = scanner.nextInt();
        // 创建数组
        double[] nums = new double[length];
        // 循环录入数组内各个元素的值
        for(int i = 0 ; i < length; i++){
            System.out.println("请输入下一个成绩：");
            // 将控制台输入的值放入数组
            nums[i] = scanner.nextDouble();
        }
        return nums;
    }
    /**
     * 计算平均成绩
     * @param array 包含所有成绩的数组
     * @return 平均成绩
     */
    public static double average(double[] array){
        // 定义变量保存成绩总和，类型为浮点型
        double sum = 0;
        // 遍历数组并累加成绩
        for(int i = 0 ; i < array.length ; i++){
            sum+=array[i];
        }
        // 求出平均成绩，由于元素是浮点型，计算结果也采用浮点型
        double avg = sum/array.length;
        return avg;
    }
    /**
     * 传入成绩数组和平均成绩，统计成绩大于平均成绩的人数
     * @param array 成绩数组
     * @param average 平均成绩
     * @return 大于平均成绩的人数
     */
    public static int averageNum(double[] array,double average){
        // 定义变量统计人数
        int num = 0;
        // 循环遍历数组，判断元素是否大于平均成绩
        for (int i = 0; i < array.length; i++) {
            // 若成绩大于平均成绩，num 自增 1
            if(array[i]>average){
                num++;
            }
        }
        return num;
    }

    /**
     * 查找成绩数组中的最大值
     * @param array 成绩数组
     * @return 最大值
     */
    public static double findMax(double[] array){
        // 定义变量保存最大成绩，初始值为数组中的第一个元素
        double max = array[0];
        // 循环遍历数组
        for (int i = 0; i < array.length; i++) {
            // 若当前遍历的元素值大于 max 将他的值赋值给 max
            if(array[i]>max){
                max = array[i];
            }
        }
        // 循环结束 max 就是最大值，将其返回出去
        return max;
    }

    /**
     * 查找成绩数组中的最小值
     * @param array 成绩数组
     * @return 最小值
     */
    public static double findMin(double[] array){
        // 定义变量保存最小成绩，初始值为数组中的第一个元素
        double min = array[0];
        // 循环遍历数组
        for (int i = 0; i < array.length; i++) {
            // 若当前遍历的元素值小于 min 将他的值赋值给 min
            if(array[i]<min){
                min = array[i];
            }
        }
        // 循环结束 min 就是最小值，将其返回出去
        return min;
    }

    /**
     * 统计及格人数
     * @param array 成绩数组
     * @return 及格人数
     */
    public static int passNum(double[] array){
        // 定义变量保存及格人数
        int sum = 0;
        // 遍历数组判断是否及格
        for (int i = 0; i < array.length; i++) {
            // 若成绩大于 60 分则 sum 自增 1
            if(array[i]>60){
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // 开启输入，获得控制台录入数组
        double[] array = input();
        // 将数组传入方法中求取平均成绩
        double average = average(array);
        // 将数组和平均成绩传入方法中求取优秀人数
        int sum = averageNum(array, average);
        // 将数组传入方法求取最高分
        double max = findMax(array);
        // 将数组传入方法求取最低分
        double min = findMin(array);
        // 将数组传入方法求取及格人数
        int passNum = passNum(array);

        // 输出结果
        System.out.println("及格人数："+passNum);
        System.out.println("平均分："+average);
        System.out.println("优秀人数："+sum);
        System.out.println("最高分："+max);
        System.out.println("最低分："+min);
    }
}
