package com.demo.thread;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2020-05-07
 * @time 20:49
 */
public class ThreadBreak implements Runnable {

    @Override
    public void run() {

        try {
            while(!Thread.currentThread().isInterrupted()){
                System.out.println(1);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }catch (Exception e){


        }


        System.out.println("over");
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ThreadBreak());
        t.start();
        Thread.sleep(10);

        t.interrupt();
    }
}
