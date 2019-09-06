package com.demo.threadlocal;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-30
 * @time 16:48
 */
public class ThreadMain {

    public static void main(String[] args) throws InterruptedException {
        final Person p = new Person();
        p.setName("小明");
        final ThreadLocal<Person> threadLocal = new ThreadLocal<Person>() {
            @Override
            public Person initialValue() {

                return p;
            }
        };
        for (int i = 0; i < 3; i++) {
           new Thread(new ThreadPerson(threadLocal,p)).start();
        }
        Thread.sleep(1000);

    }
}

class ThreadPerson implements Runnable {


    private final  ThreadLocal<Person> threadLocal;

    private final  Person person;

    public ThreadPerson(ThreadLocal<Person> personThreadLocal, Person person) {
        this.threadLocal = personThreadLocal;
        this.person = person;
    }

    @Override
    public void run() {
        threadLocal.set(person);
        //随意改变里面的值 不会影响其他线程
        threadLocal.get().setName("我要改名:"+Math.random()+"|"+Math.random());
        System.out.println(threadLocal.get().getName() + "==" + threadLocal.get()+"   "+Thread.currentThread().getName() );
    }
}
