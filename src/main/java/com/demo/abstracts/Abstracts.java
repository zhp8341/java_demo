package com.demo.abstracts;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-09-12
 * @time 11:25
 */
public class Abstracts extends AbstractsDemo {

    @Override
    public void absprint() {

        System.out.println("我是抽象方法 absprint");
        this.print();
    }

    public static void main(String[] args){
        Abstracts abstractsDemo= new Abstracts();

        abstractsDemo.absprint();


    }
}


