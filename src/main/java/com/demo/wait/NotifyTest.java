package com.demo.wait;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-18
 * @time 23:08
 */
public class NotifyTest implements Runnable {
    int i = 1;
    public static void main(String[] args){
        NotifyTest test = new NotifyTest();
        new Thread(test).start();
        new Thread(test).start();
    }
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                this.notify();
                if (i <= 100) {
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + ":" + i);
                    i++;
                    try {
                        this.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            if (i==101){
                synchronized (this) {
                    this.notifyAll();
                }
                break;

            }
        }
        System.out.println("结束"+Thread.currentThread().getName() + ":" + i);
    }
}
