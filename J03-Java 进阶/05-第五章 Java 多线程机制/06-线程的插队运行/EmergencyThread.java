package org.lanqiao.main;

public class EmergencyThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            try {
                // 使该线程休眠 0.1 秒，实现动态更新
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 紧急情况下车辆出发
            System.out.println("紧急情况："+i+"号车出发。");
        }

    }
}