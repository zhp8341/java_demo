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

    private String name;


    public ReadLock(ReentrantReadWriteLock readLock, String name) {
        this.readLock = readLock;
        this.name = name;
    }

    public void run() {
        while (true) {
            readLock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + " get read lock :" + name);
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                readLock.readLock().unlock();
            }
        }

    }
}
