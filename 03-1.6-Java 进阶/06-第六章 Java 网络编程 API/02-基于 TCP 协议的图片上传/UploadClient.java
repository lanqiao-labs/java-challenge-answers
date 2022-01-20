package org.lanqiao.client;

import java.io.*;
import java.net.*;

public class UploadClient {
    public static void main(String[] args) {
        // 指定文件路径
        File file = new File("timg.jpg");
        // 进行文件的判断
        if (file.exists() && file.toString().endsWith("jpg") && (file.length() < 1024 * 1024 * 2)) {
            try {
                // 创建文件输入流,从文件中读取一个图片
                InputStream in = new FileInputStream(file);
                // 创建socket对象和服务器端连接
                Socket socket = new Socket("127.0.0.1", 10203);
                // 创建网络输出流
                OutputStream netout = socket.getOutputStream();
                // 将文件传给服务器端,上传完毕关闭输出流
                byte[] bytes = new byte[1024 * 9];
                int len =0;
                while ((len = in.read(bytes)) != -1) {
                    netout.write(bytes,0,len);
                }
                // 关闭输出流
                socket.shutdownOutput();
                // 创建输入流接收服务器端发来的反馈
                InputStream netIn = socket.getInputStream();
                len = netIn.read(bytes);
                String str = new String(bytes, 0, len);
                if(str.equals("接收完成")){
                    System.out.println("上传完成");
                }
                netIn.close();
                netout.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("文件不合法!!!");
        }
    }
}
