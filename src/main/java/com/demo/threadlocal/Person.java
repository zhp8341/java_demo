package com.demo.threadlocal;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-30
 * @time 16:47
 */
public class Person {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
