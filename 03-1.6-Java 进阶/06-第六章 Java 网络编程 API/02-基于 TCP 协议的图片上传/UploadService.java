package org.lanqiao.service;

import java.io.*;
import java.net.*;

public class UploadService {
    public static void main(String[] args) {
        // 创建服务端的套接字对象
        try (ServerSocket server = new ServerSocket(10203)) {
            Socket socket = server.accept();
            // 获取网络输入流
            InputStream netIn = socket.getInputStream();
            byte[] bytes = new byte[1024 * 34];
            int len =0;
            // 创建文件输出流,将客户端传过来的文件保存
            OutputStream out = new FileOutputStream("pic/mn.jpg");
            while ((len = netIn.read(bytes)) != -1) {
                out.write(bytes,0,len);
            }
            // 给客户端发送反馈
            OutputStream netOut = socket.getOutputStream();
            netOut.write("接收完成".getBytes());
            netOut.close();
            netIn.close();
            out.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}