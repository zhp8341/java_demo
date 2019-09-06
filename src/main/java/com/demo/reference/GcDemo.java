package com.demo.reference;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-30
 * @time 17:52
 */
public class GcDemo {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("执行了垃圾回收");
    }
}
