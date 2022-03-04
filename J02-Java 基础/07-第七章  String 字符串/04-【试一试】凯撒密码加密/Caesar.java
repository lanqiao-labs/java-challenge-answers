import java.util.Scanner;
/**
 * 凯撒密码加密
 * @author 小桃子
 */
public class Caesar{
    /**
     * 加密方法
     * @param s 要进行加密处理的字符串
     * @param key 字符移动的位数
     * @return 加密后的字符串
     */
    public String process( String s,int key){
        String es = "";
        for(int i = 0; i < s.length(); i++){
            //取字符串中的每一位
            char c = s.charAt(i);
            //是小写字母
            if(c >= 'a' && c <= 'z'){
                //移动 key%26 位
                c += key % 26;
                //向左越界
                if(c < 'a') c += 26;
                //向右越界
                if(c > 'z') c -= 26;
            }else if(c >= 'A' && c <= 'Z'){   //是大写字母
                c += key % 26;
                if(c < 'A') c += 26;
                if(c > 'Z') c -= 26;
            }
            es += c;
        }
        return es;
    }
    public static void main(String args[]){
        // 创建控制台输入对象
        Scanner input = new Scanner(System.in);
        System.out.print("请输入需要加密的字符串：");
        // 调用加密方法
        System.out.println("加密后的字符串为：" + new Caesar().process(input.nextLine(),2));
        // 资源释放
        input.close();
    }
}