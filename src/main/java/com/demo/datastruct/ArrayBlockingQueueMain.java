package com.demo.datastruct;

import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * add(E e)：把 e 加到 BlockingQueue 里，即如果 BlockingQueue 可以容纳，则返回 true，否则报异常
 * offer(E e)：表示如果可能的话，将 e 加到 BlockingQueue 里，即如果 BlockingQueue 可以容纳，则返回 true，否则返回 false
 * put(E e)：把 e 加到 BlockingQueue 里，如果 BlockQueue 没有空间，则调用此方法的线程被阻断直到 BlockingQueue 里面有空间再继续
 * poll(time)：取走 BlockingQueue 里排在首位的对象，若不能立即取出，则可以等 time 参数规定的时间,取不到时返回 null
 * take()：取走 BlockingQueue 里排在首位的对象，若 BlockingQueue 为空，阻断进入等待状态直到 Blocking 有新的对象被加入为止
 * remainingCapacity()：剩余可用的大小。等于初始容量减去当前的 size
 *
 * @author zhuhuipei
 * @Description:
 * @date 2019-09-19
 * @time 15:34
 */
public class ArrayBlockingQueueMain {

    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue arrayBlockingQueue=new ArrayBlockingQueue(5);
        arrayBlockingQueue.add(1);
        arrayBlockingQueue.add(2);
        arrayBlockingQueue.add(3);
        arrayBlockingQueue.add(4);
        arrayBlockingQueue.add(5);
        System.out.println(arrayBlockingQueue);
        arrayBlockingQueue.take();
        arrayBlockingQueue.put(7);
        System.out.println(arrayBlockingQueue);

    }
}
