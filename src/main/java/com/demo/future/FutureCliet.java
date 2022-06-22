package com.demo.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2021/6/2
 * @time 17:42
 */
public class FutureCliet {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        long start = System.currentTimeMillis();

        // 等凉菜
        Callable ca1 = () -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "凉菜准备完毕";
        };
        FutureTask<String> ft1 = new FutureTask<String>(ca1);
        new Thread(ft1).start();


        // 等包子 -- 必须要等待返回的结果，所以要调用join方法
        Callable ca2 = () -> {
            try {
                Thread.sleep(1000*3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "包子准备完毕";
        };

        FutureTask<String> ft2 = new FutureTask<String>(ca2);
        new Thread(ft2).start();
//
//        while (true){
//            Thread.sleep(500);
//           boolean run= ft1.isDone();
//           if (!run){
//               System.out.println(run);
//           }else{
//               System.out.println("结束 "+run);
//               break;
//           }
//
//        }


        System.out.println(ft1.get(100L, TimeUnit.MILLISECONDS));
        System.out.println(ft2.get());

        long end = System.currentTimeMillis();
        System.out.println("准备完毕时间："+(end-start));
    }
}
