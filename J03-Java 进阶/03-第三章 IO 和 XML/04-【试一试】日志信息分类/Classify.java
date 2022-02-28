package org.lanqiao.main;

import java.io.*;

public class Classify {

    public static void main(String[] args)  {
        try {
            // 创建对应的输入输出流
            BufferedReader br = new BufferedReader(new FileReader("log.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("Error.txt"));
            // 读取数据
            int startValue = 0;
            String str = null;
            while((str = br.readLine()) != null){
                // 判断是否包含 ERROR
                if ((startValue = str.indexOf("ERROR")) > 0){
                    // 将错误信息写出去
                    bw.write((str.substring(0, startValue)
                        + str.substring(startValue + 5, str.length())));
                    bw.newLine();
                    bw.flush();
                }
            }
            // 关闭流
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}