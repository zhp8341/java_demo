package com.demo.datastruct;

import java.util.ArrayList;

/**
 *
 * 底层就是一个数组, 因此按序查找快, 乱序插入, 删除因为涉及到后面元素移位所以性能慢.
 * 一般默认容量是10, 扩容后, 会length*1.5.
 * @author zhuhuipei
 * @Description:
 * @date 2019-09-19
 * @time 15:25
 */
public class ArrayListMain {

    public static void main(String[] args){

        ArrayList arrayList=new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(1,5);
        arrayList.add(4);
        arrayList.add(7);
        arrayList.remove(8);
        System.out.println(arrayList);
    }
}
