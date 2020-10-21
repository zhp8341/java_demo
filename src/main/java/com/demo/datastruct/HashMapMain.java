package com.demo.datastruct;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * initialCapacity	HashMap 初始容量 16 DEFAULT_INITIAL_CAPACITY
 *
 * threshold
 * @author zhuhuipei
 * @Description:
 * @date 2019-09-19
 * @time 15:49
 */
public class HashMapMain {


    static final int MAXIMUM_CAPACITY = 1 << 30;


    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    public static void main(String[] args){
//        HashMap<String,String> hashMap=new HashMap();
//        for (int i = 0; i < 10000; i++) {
//            hashMap.put(i+"x","1x"+i);
//        }
//
//        //System.out.println(hashMap);
//
//
//        System.out.println(MAXIMUM_CAPACITY);
//        System.out.println(DEFAULT_INITIAL_CAPACITY);
//        System.out.println(DEFAULT_INITIAL_CAPACITY*0.75);

//
//        String s="plumless";
//        String s2="buckeroo";
//            int  hashCode=s.hashCode();
//            int  hashCode2=s2.hashCode();
//            System.out.println(hashCode);
//            System.out.println( hashCode ^ (hashCode >>> 16));
//
//            System.out.println(hashCode2);
//            System.out.println( hashCode2 ^ (hashCode2 >>> 16));

//        HashMap<User,User> hashMap=new HashMap();
//
//        hashMap.put(new User("1",1),new User("1",1));
//        hashMap.put(new User("1",1),new User("1",1));
//
//        System.out.println(hashMap);

//          Map<HashMap<Object, Object>, String> map = new HashMap<>();
//          map.put(new HashMap<>(), "value");
//          System.out.println("Before:" + map.size());
//          Iterator<Map.Entry<HashMap<Object, Object>, String>> iterator = map.entrySet().iterator();
//          while (iterator.hasNext()) {
//                  //iterator.next().getKey().put("123", "1a23");
//                   iterator.next().getKey().put("123", "123");
//                 iterator.remove();
//              }
//         System.out.println("After:" + map.size());


        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <1000000000 ; i++) {
            int hash=hash(String.valueOf(i));
            if (list.contains(hash)){
                System.out.println(i+"="+hash);
            }

        }



    }



   private static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}

class  User{

    private  String name;

    private  Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
