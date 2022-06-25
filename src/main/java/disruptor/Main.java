package disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/*
 * https://zhuanlan.zhihu.com/p/458926355 (讲到了为什么RingBuffer 里有 protected long p1, p2, p3, p4, p5, p6, p7; )
 * 解决缓存行的问题 和伪共享
 * 一个long 8个字节   8*8=64 7+对象
 * @date 2022/6/24
 */
public class Main {


  public static void main(String[] args) throws Exception {


    new Thread(new Runnable() {
      @Override
      public void run() {

        while (true){
          Runtime run = Runtime.getRuntime();

          long max = run.maxMemory();

          long total = run.totalMemory();

          long free = run.freeMemory();

          long usable = max - total + free;

          System.out.print("最大内存 = " + max +"byte");

         // System.out.println("已分配内存 = " + total);

          //System.out.println("已分配内存中的剩余空间 = " + free);

          System.out.println("最大可用内存 = " + usable);
          try {
            Thread.sleep(1000L);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }


      }
    }).start();

    Executor executor = Executors.newCachedThreadPool();

    LongEventFactory factory = new LongEventFactory();

    int bufferSize = 1024;

    Disruptor<LongEvent> disruptor = new Disruptor<>(factory, bufferSize, executor);
    //消费者
    disruptor.handleEventsWith(new LongEventHandler());
    //disruptor.handleEventsWithWorkerPool(new LongEventHandlerForWork());
    disruptor.start();

    RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

    //生产者
    LongEventProducer producer = new LongEventProducer(ringBuffer);

    ByteBuffer bb = ByteBuffer.allocate(8);
    for (long l = 0; true; l++) {
      bb.putLong(0, l);
      producer.onData(bb);
      Thread.sleep(10);
    }

  }

}
