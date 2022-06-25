package disruptor;


import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

public class LongEventHandler implements EventHandler<LongEvent> {
  /*
   * event表示消费到的本次事件的主体，在例子里也就是StringEvent
   * sequence表示消费到的本次事件对应的sequence
   * endOfBatch表示消费到的本次事件是否是这个批次中的最后一个
   * @Param:[event, sequence, endOfBatch]
   * @return: void
   * @Author: zhuhuipei
   * @date 2022/6/24
   */
  @Override
  public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
    Thread.sleep(1000);
    System.out.println(
        "[LongEventHandler]消费者Event:  " + event.getValue() + " sequence:+" + sequence + "  endOfBatch:" + endOfBatch);
  }
}

