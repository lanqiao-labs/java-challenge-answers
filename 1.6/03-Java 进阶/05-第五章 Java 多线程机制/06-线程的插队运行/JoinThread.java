package org.lanqiao.main;

public class JoinThread {
    public static void main(String[] args) {
        // 创建新线程
        Thread thread = new Thread(new EmergencyThread());
        // 使新创建的线程运行起来
        thread.start();
        // 使用 join() 使新创建的线程优先于当前线程运行
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 开始正常情况的发车
        for(int i = 0; i < 6 ; i++){
            // 使当前线程休眠 0.1 秒实现动态更新
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 输出正常情况下的发车信息
            System.out.println("正常情况："+i+"号车出发！");
            
        }

    }
}