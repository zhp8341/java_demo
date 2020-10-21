package volatiles;

/**
 * JMM
 * @author zhuhuipei
 * @Description:
 * @date 2019-09-05
 * @time 11:06
 */
public class VolatileDemo {

    //这种情况不会进入死循环
   // private static volatile boolean isOver = false;

    //这种情况会进入死循环
    private static  boolean isOver = false;

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isOver){} ;
            }
        });
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isOver = true;
    }
}
