package com.demo.threadPool;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-19
 * @time 20:15
 */
public class TaskThread implements Runnable {

    int i;

    public TaskThread(int i) {
        this.i = i;
    }

    @Override
    public void run() {

        System.out.println(i + "   线程开始运行" + Thread.currentThread().getName());

        try {
            Thread.sleep(1000 * 5L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i + "   线程结束运行" + Thread.currentThread().getName());
    }
}
