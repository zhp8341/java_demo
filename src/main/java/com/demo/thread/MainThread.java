package com.demo.thread;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-09
 * @time 23:47
 */
public class MainThread {

    public static void main(String[] args) {
//        CallableThread callableThread

        new Thread(new MyThreadYield()).start();
        new Thread(new MyThreadYield()).start();
//        new Thread(new MyThreadYield()).start();

    }
}
