package buffer;

import java.util.Arrays;

public class RingBuffer<T> {


  private static final int DEFAULT_SIZE = 1024;

  private Object[] buffer;

  //head指向下一次读的位置
  private int head = 0;

  //tail指向的是下一次写的位置
  private int tail = 0;

  private int bufferSize;


  public RingBuffer() {
    this.bufferSize = DEFAULT_SIZE;
    this.buffer = new Object[bufferSize];
  }


  public RingBuffer(int initSize) {
    this.bufferSize = initSize;
    this.buffer = new Object[bufferSize];
  }

  private Boolean empty() {
    return head == tail;
  }


  private Boolean full() {
    return (tail + 1) % bufferSize == head;
  }

  public void clear() {
    Arrays.fill(buffer, null);
    this.head = 0;
    this.tail = 0;
  }

  public Boolean put(T v) {
    if (full()) {
      System.out.println("满了");
      return false;
    }
    buffer[tail] = v;
    tail = (tail + 1) % bufferSize;
    return true;
  }

  public Object get() {
    if (empty()) {
      return null;
    }
    Object result = buffer[head];
    head = (head + 1) % bufferSize;
    return result;
  }

  public static void main(String[] args) {
    RingBuffer<String> ringBuffer=new RingBuffer<String>(10);
    for (int i = 0; i <11 ; i++) {
      System.out.println("tail="+ringBuffer.tail +"  head="+ringBuffer.head );
      ringBuffer.put(i+"");
      if (i%3==0){
        System.out.println(ringBuffer.get());
      }
    }
    System.out.println(ringBuffer);


  }

}
