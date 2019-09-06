package com.demo.threadPool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-19
 * @time 20:36
 */
public class MyAbortPolicy implements RejectedExecutionHandler {


    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

        System.out.println("自定义拒绝策略"+new Thread(r).getName());
    }
}
