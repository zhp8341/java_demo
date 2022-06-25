package disruptor;


public class LongEvent {

  private long value;

  private String[]  array;


  public void set(long value) {
    this.value = value;
  }

  public long getValue() {
    return this.value;
  }

  public void setArray(String[] array) {
    this.array = array;
  }
}