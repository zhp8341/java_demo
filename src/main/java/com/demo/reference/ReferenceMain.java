package com.demo.reference;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-30
 * @time 18:06
 */
public class ReferenceMain {


    private static final int HASH_INCREMENT = 0x61c88647;
    //-Xmx1m -Xms1m 启动设置jvm参数
    public static void main(String[] args){

        System.out.println(HASH_INCREMENT);

        GcDemo date=new GcDemo();
        date = null;

        //显式调用垃圾回收
         //System.gc();

         //隐式调用垃圾回收
        ReferenceTest.drainMemory();
    }
}
