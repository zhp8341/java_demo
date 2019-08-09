package com.demo.lock.fair;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-08
 * @time 19:03
 */
public class LockFair {

    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock(true);

        new Thread(new LockRun(reentrantLock)).start();
//
//        new Thread(new LockRun(reentrantLock)).start();
//
//        new Thread(new LockRun(reentrantLock)).start();


    }
}
