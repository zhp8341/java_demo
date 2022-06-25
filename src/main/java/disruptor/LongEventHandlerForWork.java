package disruptor;


import com.lmax.disruptor.WorkHandler;

public class LongEventHandlerForWork implements WorkHandler<LongEvent> {

  @Override
  public void onEvent(LongEvent event) throws Exception {
    System.out.println("[LongEventHandlerForWork]消费者Event:  " + event.getValue());
  }

}

