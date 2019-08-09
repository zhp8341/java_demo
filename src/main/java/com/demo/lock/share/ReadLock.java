package com.demo.lock.share;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-08
 * @time 19:53
 */
public class ReadLock implements Runnable {

    private ReentrantReadWriteLock readLock;


    public ReadLock(ReentrantReadWriteLock readLock) {
        this.readLock = readLock;
    }

    public void run() {
        while (true){
            readLock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + " get read lock ");
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                readLock.readLock().unlock();
            }
        }

    }
}
