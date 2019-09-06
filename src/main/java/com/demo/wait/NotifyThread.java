package com.demo.wait;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-18
 * @time 22:54
 */
public class NotifyThread implements Runnable {

    private  Object o;

    public NotifyThread(Object o) {
        this.o = o;
    }

    @Override
    public void run() {
        try {

            synchronized(o){
                Thread.sleep(1500);
                System.out.println("解锁 waitThread"+Thread.currentThread().getName());
                o.notify();

            }
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

    }
}
