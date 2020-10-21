package com.demo.extend;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2020-05-27
 * @time 11:23
 */
public class A {
    static {
        System.out.println("static A");
    }

    public A() {
        System.out.println("构造函数 A");
    }
}
