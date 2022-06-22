package com.demo.designpattern.factory;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2020-03-24
 * @time 16:47
 */
public class Main {

    public static void main(String[] args){

       new BMwCarFactory().buildCar().buildCar();
    }
}
