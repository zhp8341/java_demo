package com.demo.abstracts;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-09-12
 * @time 11:22
 */
public abstract class AbstractsDemo {

    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public  void print(){
        System.out.println("我的抽象类 print");
    }


    public abstract void  absprint();
}

abstract  class  AbstractsDemo2 extends  AbstractsDemo{


    public void d2(){

    }

    public abstract void  absprint2();
}


class Main extends  AbstractsDemo2{


    @Override
    public void d2(){
        System.out.println("main d2");
    }
    @Override
    public void absprint() {

    }

    @Override
    public void absprint2() {

    }

    public static void main(String[] args){
        Main main=new Main();
        main.d2();
    }
}
