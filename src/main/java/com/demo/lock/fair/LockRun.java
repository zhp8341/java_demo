package com.demo.lock.fair;

import java.util.concurrent.locks.Lock;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-08
 * @time 19:29
 */
public class LockRun implements Runnable {

    private Lock lock;

    public LockRun(Lock lock) {
        this.lock = lock;
    }

    public void run() {
        while (true) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " get lock");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
