package com.demo.wait;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-18
 * @time 22:39
 */
public class WaitThread  implements  Runnable{


    private  Object o;

    public WaitThread(Object o) {
        this.o = o;
    }

    @Override
    public void run() {
        System.out.println("开始运行。。。。"+Thread.currentThread().getName());
        synchronized (o){
            try {
                o.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("结束运行。。。。"+Thread.currentThread().getName());

    }
}
