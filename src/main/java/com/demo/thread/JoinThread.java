package com.demo.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-14
 * @time 23:23
 */
public class JoinThread   {


    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new Runnable()
        {
            @Override
            public void run()
            {

                System.out.println("线程1");

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1结束");
            }
        });



        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("t1 task completed");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable()
        {
            public void run()
            {
                System.out.println("t2 task completed");
            }
        });

        //在t执行完毕后t1执行
        t.start();
        t.join();
        t1.start();
        t1.join();
        t2.start();

    }

}
