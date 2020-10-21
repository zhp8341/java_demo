package com.demo.oom;

import java.util.UUID;

/**
 *
 * 年老代堆空间被占满 java.lang.OutOfMemoryError: Java heap space
 * @author zhuhuipei
 * @Description:
 * @date 2019-09-15
 * @time 22:39
 */
public class OOM {

    //-Xmx1m -Xms1m 启动设置jvm参数
    public static void main(String[] args){
        StringBuilder stringBuilder=new StringBuilder();

        while (true){
            stringBuilder.append(UUID.randomUUID().toString());
        }
    }
}
