package org.lanqiao.client;

import java.io.*;
import java.net.*;

public class Client{
    public static void main(String[] args){
        DatagramSocket ds=null;
        InputStream is=null;
        try{
            // 监听端口
            ds=new DatagramSocket(10204);
            System.out.println("客户端在 10203 监听");
            // 创建输入流
            is=new FileInputStream(new File("text.txt"));
            // 读取文件
            byte[] b=new byte[is.available()];
            is.read(b);
            // 向服务端写出文件
            DatagramPacket dp=new DatagramPacket(b,0,b.length);
            dp.setPort(10203);
            dp.setAddress(InetAddress.getByName("127.0.0.1"));
            // 发出数据包
            ds.send(dp);
            System.out.println("文件发送成功");
        } catch (SocketException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                is.close();
                ds.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}