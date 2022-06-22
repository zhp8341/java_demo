package com.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {



  public static void main(String[] args) {
    CountDownLatch countDownLatch=new CountDownLatch(5);
    try{

      for (int i = 0; i <5 ; i++) {
       new Thread(new Task(countDownLatch)).start();
      }
      boolean b= countDownLatch.await(5000, TimeUnit.SECONDS);
      System.out.println(b);
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}

class  Task implements  Runnable{

  private CountDownLatch countDownLatch;

  public Task(CountDownLatch countDownLatch) {
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName());
    try {
      Thread.sleep(3000);
      System.out.println(Thread.currentThread().getName()+" 业务处理完成了");
      countDownLatch.countDown();
      System.out.println(countDownLatch.getCount());

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
