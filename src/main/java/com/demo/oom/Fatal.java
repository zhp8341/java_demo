package com.demo.oom;

import java.util.UUID;

/**
 *
 *
 * java.lang.OutOfMemoryError: unable to create new native thread
 *
 * @author zhuhuipei
 * @Description:
 * @date 2019-09-15
 * @time 22:53
 */
public class Fatal {

    // jvm -Xmx5m -Xms5m
    public static void main(String[] args) {

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String s= UUID.randomUUID().toString();
                    try {
                        Thread.sleep(Long.MAX_VALUE);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
}

