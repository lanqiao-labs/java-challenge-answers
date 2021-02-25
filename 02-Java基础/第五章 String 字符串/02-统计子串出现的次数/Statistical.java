import java.util.Scanner;

public class Statistical{

    public static void main(String[] args) {
        // 创建一个控制台输入对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一段字符串：");
        // 接收控制台输入的第一段字符串
        String str1 = sc.next();
        System.out.println("请输入第二段字符串：");
        // 接收控制台输入的第二段字符串
        String str2 = sc.next();
        // 定义一个变量保存统计的结果
        int total = 0;
        // 遍历第一段字符串，由于我们要从中截取跟 str2 等长的字符串，因此判断条件要减去 str2 的长度。
        for (int i = 0; i <= str1.length()-str2.length(); i++) {
            // 从第一段字符串中依次截取长度等于第二段字符串的子串
            String sub = str1.substring(i,i+str2.length());
            // 比较截取出的子串和第二段字符串是否相同，若相同则让 total 自增 1
            if(sub.equals(str2)){
                total++;
            }
        }
        System.out.println("子串一共出现了"+total+"次！");
    }
}