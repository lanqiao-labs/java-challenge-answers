package org.lanqiao.service;

import java.io.*;
import java.net.*;

public class Service{
    public static void main(String[] args){
        // 创建输出流和数据包
        OutputStream os=null;
        DatagramSocket ds=null;
        try{
            ds=new DatagramSocket(10203);
            System.out.println("在 10203 端口监听...");
            // 创建数组用于读取文件
            byte[] b=new byte[1024*2];
            // 创建数据包
            DatagramPacket dp=new DatagramPacket(b,0,b.length);
            // 读取数据
            ds.receive(dp);
            // 获取传入的数据
            byte[] data = dp.getData();
            // 将数据写出到文件中
            os=new FileOutputStream(new File("data/text.txt"));
            os.write(data, 0, dp.getLength());
            System.out.println("文件接收成功");
        } catch (SocketException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                os.close();
                ds.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}