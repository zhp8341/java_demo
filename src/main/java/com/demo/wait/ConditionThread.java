package com.demo.wait;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-18
 * @time 23:29
 */
public class ConditionThread implements Runnable {

    private int i = 0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public static void main(String[] args) {


        ConditionThread conditionThread = new ConditionThread();

        new Thread(conditionThread).start();
        new Thread(conditionThread).start();
    }


    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                condition.signal();
                if (i <= 100) {
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + ":" + i);
                    i++;
                    try {
                        condition.await();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }

            if (i == 101) {
                lock.lock();
                condition.signalAll();
                lock.unlock();
                break;

            }
        }
        System.out.println("结束" + Thread.currentThread().getName() + ":" + i);
    }
}
