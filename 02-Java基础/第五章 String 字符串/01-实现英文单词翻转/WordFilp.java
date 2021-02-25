import java.util.Scanner;

public class WordFilp {
    public static void main(String[] args) {
        // 创建控制台输入对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个英文短语：");
        // 从控制台接收输入的英文短语
        String str = sc.nextLine();
        // 将原句使用空格进行分割，得到单词构成的数组
        String[] strs = str.split(" ");
        // 创建一个新字符串，用于拼接翻转后的单词，该字符串初始值为空
        String nstr = "";
        // 遍历该单词数组，再遍历其中的每个单词，将其翻转后拼接到新字符串中
        for (int i = 0; i < strs.length; i++) {
            for (int j = strs[i].length()-1; j >= 0 ; j--) {
                // 进行字符串遍历，将遍历出的字符拼接到新字符串中
                nstr+=strs[i].charAt(j);
            }
            // 当单词拼接完后在其后拼接一个空格，若循环是最后一次则不需要拼接空格
            if(i!=strs.length-1){
                nstr+=" ";
            }
        }
        System.out.println(nstr);
    }
}