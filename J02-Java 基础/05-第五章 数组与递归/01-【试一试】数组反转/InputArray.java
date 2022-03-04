import java.util.Scanner;

/**
 * 数组反转
 * @author lanqiao
 */
public class InputArray {

    /**
     * 控制台输入数组长度和数组元素
     * @return
     */
    public int[] input(){
        // 创建控制台输入对象
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要输入的数组长度：");
        // 接收数组长度
        int length = scanner.nextInt();
        // 创建数组
        int[] nums = new int[length];
        // 循环录入数组内各个元素的值
        for(int i = 0 ; i < length; i++){
            System.out.println("请输入第"+(i+1)+"个元素：");
            // 将控制台输入的值放入数组
            nums[i] = scanner.nextInt();
        }
        return nums;
    }
    /**
     * 反转数组
     * @param nums 原数组
     * @return 新数组
     */
    public int[] reverseArray(int[] nums){
        // 创建新数组
        int[] newArray = new int[nums.length];
        // 正向遍历原数组
        for(int i = 0; i < nums.length ; i++){
            // 将遍历出的值从后往前赋值给新数组
            newArray[newArray.length-(i+1)] = nums[i];
        }
        return newArray;
    }

    /**
     * 遍历并输出数组内的所有元素
     * @param nums 要输出的元素
     */
    public void showArray(int[] nums){

        System.out.print("数组内的元素有：");
        // 遍历数组,并不换行输出内容
        for(int i = 0 ;i < nums.length ; i++){
        }
        // 换行
        System.out.println();
    }
}