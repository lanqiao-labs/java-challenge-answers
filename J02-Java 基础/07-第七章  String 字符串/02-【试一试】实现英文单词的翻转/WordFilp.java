/**
 * 实现英文单词翻转
 * @author 小桃子
 */
public class WordFilp {
      // 提供英文单词数组
    public static String[] strs = {"I", "Love", "You", "Daddy"};
    public static void main(String[] args) {
      
        // 创建字符串缓冲区
        StringBuffer buffer = new StringBuffer();
        // 遍历该单词数组，再遍历其中的每个单词，将其翻转后拼接到新字符串中
        for (int i = 0; i < strs.length; i++) {
            for (int j = strs[i].length()-1; j >= 0 ; j--) {
                // 进行字符串遍历，将遍历出的字符拼接到新字符串中
                buffer.append(strs[i].charAt(j));
            }
            // 当单词拼接完后在其后拼接一个空格，若循环是最后一次则不需要拼接空格
            if(i!=strs.length-1){
                buffer.append(" ");
            }
        }
        System.out.println(buffer);
    }
}
