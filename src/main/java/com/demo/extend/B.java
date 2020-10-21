package com.demo.extend;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2020-05-27
 * @time 11:23
 */
public class B extends A {
    static {
        System.out.println("static B");
    }

    public B() {
        System.out.println("构造函数 B");
    }

    public static void main(String[] args){
        B b=new B();
    }
}
