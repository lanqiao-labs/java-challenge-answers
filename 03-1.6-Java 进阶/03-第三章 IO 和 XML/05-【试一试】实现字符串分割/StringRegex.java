import java.util.StringTokenizer;
/**
 * 使用正确的方式实现字符串分隔
 * @author 小桃子
 */
public class StringRegex {
    public static void main(String[] args) {
        String str1 = "123+456*789-123/456%789";
        String[] strs = str1.split("\\+|\\*|\\-|/|%");
        for (String s : strs) {
            System.out.println(s);
        }

        String str2 = "0 1 2 3 4 5 6 7 8 9";
        StringTokenizer st = new StringTokenizer(str2);
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
}