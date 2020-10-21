package com.demo.gc;

import java.util.concurrent.TimeUnit;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-12-18
 * @time 14:45
 */
public class GcMain {

    public static void main(String[] args) throws InterruptedException {

        String[] array = new String[1024 * 10];
        for(int i = 0; i < 1024 * 10; i++) {
            for(int j = 'a'; j <= 'z'; j++) {
                array[i] += (char)j;
                TimeUnit.SECONDS.sleep(2);
            }
        }

    }
}
