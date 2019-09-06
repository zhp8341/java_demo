package com.demo.thread;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-09
 * @time 11:22
 */
public class ThreadCycle {

    public static void main(String[] args){

        //1、新建状态
        Thread thread=  new Thread(new ThreadRun());
        //2、就绪状态
        thread.start();

    }
}

class ThreadRun implements Runnable {


    //3:运行状态
    public void run() {
        System.out.println("当前线程：" + Thread.currentThread().getName());

        try {
            //4:阻塞状态
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //5:运行完毕 死亡状态
}
