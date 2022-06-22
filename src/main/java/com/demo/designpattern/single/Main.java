package com.demo.designpattern.single;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2020-03-24
 * @time 16:39
 */
public class Main {

    public static void main(String[] args){
        Single.getInstance();
        Single.getInstance();
        Single.getInstance();
        Single.getInstance();
        Single.getInstance();
        Single.getInstance();
    }
}
