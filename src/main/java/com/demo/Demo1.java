package com.demo;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2020-10-16
 * @time 16:34
 */
public class Demo1 {


    public static void main(String[] args) {
        String a ="20";
        change(a);// 实参  实际上的参数
        System.out.println("a "+a);
    }
    public static void change(String a){//形参  形式上的参数
        System.out.println("a1  "+a);
        a="100";
        System.out.println("a2  "+a);
    }
}
