package com.demo.designpattern.factory;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2020-03-24
 * @time 16:42
 */
public class AudiCar implements  Car {
    @Override
    public void buildCar() {
        System.out.println("造一辆奥迪");
    }
}
