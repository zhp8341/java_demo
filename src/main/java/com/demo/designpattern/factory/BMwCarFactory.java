package com.demo.designpattern.factory;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2020-03-24
 * @time 16:42
 */
public class BMwCarFactory implements CarFactory{

    @Override
    public Car buildCar() {
        return new BMWCar();
    }
}
