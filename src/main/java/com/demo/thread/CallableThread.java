package com.demo.thread;

import java.util.concurrent.Callable;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-09
 * @time 23:44
 */
public class CallableThread implements Callable {


    public Object call() throws Exception {
        System.out.println("当前线程：" + Thread.currentThread().getName());
        return null;
    }
}
