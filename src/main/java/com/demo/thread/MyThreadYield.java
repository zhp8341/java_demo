package com.demo.thread;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-14
 * @time 23:12
 */
public class MyThreadYield implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName() + "线程第" + i + "次执行！");
            if (i % 5 == 0){
                Thread.yield();
                System.out.println("-------- i"+i);
            }

        }
    }
}
