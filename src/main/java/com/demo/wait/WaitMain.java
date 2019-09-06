package com.demo.wait;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-18
 * @time 22:45
 */
public class WaitMain {

    public static void main(String[] args) throws  Exception {

        Object o=new Object();

       new Thread(new WaitThread(o)).start();
       new Thread(new WaitThread(o)).start();
       new Thread(new WaitThread(o)).start();


        Thread.sleep(1000L);

       //new Thread(new NotifyThread(o)).start();

        synchronized (o){
            System.out.println("主线程解锁"+Thread.currentThread().getName());
            o.notify();
            o.notify();
            o.notify();
        }

        Thread.sleep(2000L);


    }
}
