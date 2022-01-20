package org.lanqiao.main;

import java.io.*;
import java.nio.file.Files;

public class Word {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream verb = null;
        FileOutputStream noun = null;
        FileOutputStream adjective = null;
        try {
//          读取源文件
            fis = new FileInputStream("word.txt");
            byte[] content = new byte[fis.available()];
            fis.read(content);
//          将内容转为字符串
            String contentStr = new String(content);
//          用逗号将字符串分割为一维数组
            String[] contentArray = contentStr.split(",");
//          创建二维数组，将前一步分割的一维数组内每个字符串再次用冒号分割，并存入一个二维数组。
            String[][] srcArray = new String[contentArray.length][];
            for (int i = 0; i < contentArray.length; i++) {
                String[] split = contentArray[i].split(":");
                srcArray[i] = split;
            }
            // 创建文件夹 file
            File dir = new File("file");
            if(!dir.exists()){
                Files.createDirectory(dir.toPath());
            }
//          创建不同词性文件对象以及对应的输出流
            File verbFile = new File("file/verb.txt");
            File nounFile = new File("file/noun.txt");
            File adjectiveFile = new File("file/adjective.txt");
            verb = new FileOutputStream(verbFile);
            noun = new FileOutputStream(nounFile);
            adjective = new FileOutputStream(adjectiveFile);
//          判断当前单词属于哪个词性，写入对应的文件
            for(int i = 0; i < srcArray.length; i++){
                if(srcArray[i][0].equalsIgnoreCase("verb")){
                    verb.write((srcArray[i][1]+" ").getBytes());
                }else if(srcArray[i][0].equalsIgnoreCase("noun")){
                    noun.write((srcArray[i][1]+" ").getBytes());
                }else if(srcArray[i][0].equalsIgnoreCase("adjective")){
                    adjective.write((srcArray[i][1]+" ").getBytes());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
//          关闭流
            try {
                fis.close();
                verb.close();
                noun.close();
                adjective.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}