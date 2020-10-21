package com.demo.oom;

/**
 *
 * java.lang.StackOverflowError
 *
 * 堆栈溢出 一般就是递归没返回，或者循环调用造成
 * @author zhuhuipei
 * @Description:
 * @date 2019-09-15
 * @time 22:30
 */
public class StackOverflow {

    public static void main(String[] args){
        StackOverflow stackOverflow=new StackOverflow();
        stackOverflow.a();
    }

    private void a(){
        System.out.println(1);
        this.a();
    }
}
