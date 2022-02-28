import java.util.Scanner;

public class FindElement{
    public static void main(String[] args){
        // 定义二维数组
        int[][] array={{1,2,8,9},
                    {2,4,9,12},
                    {4,7,10,13},
                    {6,8,11,15}};
        // 创建控制台输入对象
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查找的数字：");
        // 接收控制台输入数字
        int num = scanner.nextInt();
        // 传入方法查找并输出结果
        System.out.println(findByTheUpperRightCorner(num,array));
    }

    /*
     * 选取数组查找范围内的右上角的数字，如果该数字等于要查找的数字，则查找结束。
     * 如果该数字小于要查找的数字，则剔除该数字所在的行；
     * 如果该数字大于要查找的数字，则剔除该数字所在的列；
     */
    public static boolean findByTheUpperRightCorner(int target, int [][] array) {
        // 判断数组长度
        if(array.length>0){
            // 定义总行数
            int rows=array.length;
          	// 定义总列数
            int columns=array[0].length;
            // 定义当前行数
            int row=0;
            // 定义当前列数等于总列数-1
            int column=columns-1;
            // 查找元素
            while(row<rows&&column>=0){
                // 如果相等则返回true
                if(array[row][column]==target)
                    return true;
                // 若大于目标数字则进入下一列
                if(array[row][column]>target)
                    column--;
                // 若小于则当前行数加一
                else
                    row++;
            }
            // 若循环结束还未找到则直接返回 false
            return false;
        }
        return false;
    }
}
