import java.util.Scanner;
public class Caesar{
    String s;     //要进行加密处理的字符串
    int key;      //字符移动的位数
    
    public String process( String s,int key){   //加密方法
        String es="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);      //取字符串中的每一位
            if(c>='a'&& c<='z'){       //是小写字母
                c+=key%26;           //移动 key%26 位
                if(c<'a') c+=26;     //向左越界
                if(c>'z') c-=26;     //向右越界
            }
            else if(c>='A'&& c<='Z'){   //是大写字母
                c+=key%26;
                if(c<'A') c+=26;
                if(c>'Z') c-=26;
            }
            es+=c;
        }
        return es;
    }
    public static void main(String args[]){
        String s;
        Scanner input = new Scanner(System.in);
        System.out.print("请输入需要加密的字符串：");
        s =input.nextLine();
        Caesar c=new Caesar();
        String str=c.process(s,2);   //进行加密
        System.out.println("加密后的字符串为："+str);
        


    }
}