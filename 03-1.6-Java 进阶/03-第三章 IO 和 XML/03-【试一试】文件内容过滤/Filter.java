package org.lanqiao.main;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Filter {
    public static void main(String[] args) {
        // 创建文件对象
        File f1 = new File("text.txt");
        File f2 = new File("出师表.txt");
        // 创建文件流
        FileReader fr = null;
        FileWriter fw = null;
        try {
            // 赋值
            fr = new FileReader(f1);
            fw = new FileWriter(f2);
            // 创建字符数组
            String str = "";
            int c;
            // 读取
            while ((c = fr.read()) != -1) {
                str+=(char)c;
            }
            // 将读取到的字符串转为字符数组
            char[] chars = str.toCharArray();
            String newStr = "";
            // 使用增强 for 遍历数组。
            for(char cs : chars){
                // 判断字符是否为字母
                if(cs<'A'||cs>'Z'&&cs<'a'||cs>'z'){
                    newStr+=cs;
                }
            }
            fw.write(newStr);
        } catch (IOException  e) {
            e.printStackTrace();
        }finally{
            try {
                fw.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}