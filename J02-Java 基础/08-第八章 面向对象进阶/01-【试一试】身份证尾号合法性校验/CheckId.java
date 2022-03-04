import java.util.Scanner;

public class CheckId{
    public static void main(String[] args) {
        // 创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个身份证号码(尾号若为X请传入大写的X)：");
        // 接收控制台输入的身份证号码
        String strId = sc.next();
        // 传入方法判断该身份证号码是否合法
        boolean result = check(strId);
        if(result){
            System.out.println("合法尾号");
        }else{
            System.out.println("非法尾号");
        }
    }

    public static boolean check(String strId){
        // 定义一个整形数组作为身份证前十七位所乘的系数
        int[] num = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
        // 定义一个字符串数组作为尾号备选
        String[] strs = {"1","0","X","9","8","7","6","5","4","3","2"};
        // 定义变量保存运算结果
        int sum = 0;
        // 遍历身份证号码字符串，将前 17 位取出并乘以系数相加
        for (int i = 0; i < 17; i++) {
            // 使用 charAt() 方法遍历字符串，并使用 Integer.parseInt() 转为数字
            // 因为该方法参数为字符串类型，但 charAt() 方法的返回值是 char 类型
            // 因此我们在参数区域加上一个空的字符串，又因任何数据加上字符串结果都会为一个字符串
            // 因此我们这样可以使 char 自动转换为字符串类型
            int n = Integer.parseInt(strId.charAt(i)+"");
            // 将遍历出来的数字乘以对应系数，由于下标一致可以继续使用 i 取出系数
            sum += n*num[i];
        }
        // 用运算结果对 11 取余，将结果作为下标取出尾号
        String end = strs[sum%11];
        // 比较我们求出的尾号和传入的身份证尾号是否相同，若相同则尾号合法，反之则不合法
        String srcEnd = strId.substring(17);
        if(end.equalsIgnoreCase(srcEnd)){
            return true;
        }else{
            return false;
        }

    }
}