package com.demo.lock.share;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-08
 * @time 19:53
 */
public class WriteLock implements Runnable {

    private ReentrantReadWriteLock writeLock;


    public WriteLock(ReentrantReadWriteLock readLock) {
        this.writeLock = readLock;
    }

    public void run() {
        while (true) {
            writeLock.writeLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + " get write lock ");
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                writeLock.writeLock().unlock();
            }
        }

    }
}
