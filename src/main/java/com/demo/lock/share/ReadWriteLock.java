package com.demo.lock.share;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-08
 * @time 19:51
 */
public class ReadWriteLock {

    public static void main(String[] args){
        ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock(true);

//        new Thread(new ReadLock(readWriteLock)).start();
//        new Thread(new ReadLock(readWriteLock)).start();
//        new Thread(new ReadLock(readWriteLock)).start();
//        new Thread(new ReadLock(readWriteLock)).start();


        new Thread(new WriteLock(readWriteLock)).start();
        new Thread(new WriteLock(readWriteLock)).start();
        new Thread(new WriteLock(readWriteLock)).start();
        new Thread(new WriteLock(readWriteLock)).start();
    }
}
