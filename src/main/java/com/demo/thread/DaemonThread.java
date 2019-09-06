package com.demo.thread;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-14
 * @time 23:31
 */
public class DaemonThread {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("1111111");

                }

            }
        });

        t1.setDaemon(true);
        t1.start();
        System.out.println("主线程end");

    }
}
