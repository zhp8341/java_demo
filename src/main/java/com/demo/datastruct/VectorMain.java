package com.demo.datastruct;

import java.util.Vector;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-09-19
 * @time 15:31
 */
public class VectorMain {

    public static void main(String[] args){
        Vector vector=new Vector();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(0,0);
        System.out.println(vector);
    }
}
