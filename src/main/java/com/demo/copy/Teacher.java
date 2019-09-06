package com.demo.copy;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-18
 * @time 22:13
 */
public class Teacher implements Cloneable {

    private String name;

    private int age;

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
