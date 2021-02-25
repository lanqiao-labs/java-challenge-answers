import java.util.Scanner;
public class StrCount{
    public static void main(String[] args) {	
        int count = 0;	//用于计数的变量
        int start = 0;	//标识从哪个位置开始查找
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个字符串：");
        String str = input.next();
        System.out.print("请输入要查找的字符串：");
        String str1 = input.next();
        while (str.indexOf(str1, start) >= 0 && start < str.length()) {
            count++;
            //找到子字符串后，查找位置移动到找到的这个字符串之后开始
            start = str.indexOf(str1, start) + str1.length();
        }
        System.out.println(str1 + " 在 " + str + "出现的次数为" + count);
    }
}
