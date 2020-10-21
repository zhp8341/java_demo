package com.demo.datastruct;

import java.util.LinkedList;

/**
 *
 * 经典的双链表结构, 适用于乱序插入, 删除. 指定序列操作则性能不如ArrayList, 这也是其数据结构决定的
 *
 * @author zhuhuipei
 * @Description:
 * @date 2019-09-19
 * @time 15:20
 */
public class LinkedListMain {

    public static void main(String[] args){
        LinkedList  linkedList=new LinkedList();
        linkedList.addLast(9);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.addFirst(0);
        linkedList.add(3,100);
        System.out.println(linkedList);
    }
}
