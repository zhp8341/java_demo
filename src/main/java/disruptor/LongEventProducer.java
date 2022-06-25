package disruptor;


import com.lmax.disruptor.RingBuffer;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class LongEventProducer {

  private final RingBuffer<LongEvent> ringBuffer;

  public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
    this.ringBuffer = ringBuffer;
  }

  public void onData(ByteBuffer bb) {
     // 当缓冲区满的时候这里会阻塞
    long sequence = ringBuffer.next();
    try {
      LongEvent event = ringBuffer.get(sequence);
      event.set(bb.getLong(0));
      String[] array = new String[1024];
      for(int i = 0; i < 1000; i++) {
        for(int j = 'a'; j <= 'z'; j++) {
          array[i] += (char)j;
        }
      }
      event.setArray(array);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      ringBuffer.publish(sequence);
    }
  }

}


