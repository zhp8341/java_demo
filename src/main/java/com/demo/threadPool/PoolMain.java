package com.demo.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-19
 * @time 20:17
 */
public class PoolMain {


    private static int corePoolSize = 3;

    private static int maximumPoolSize = 6;

    private static long keepAliveTime = 20;

    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(5000L);

        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2,true);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS,workQueue,new MyAbortPolicy());
        for (int i = 0; i <10 ; i++) {
            threadPoolExecutor.execute(new TaskThread(i));
        }



    }
}
