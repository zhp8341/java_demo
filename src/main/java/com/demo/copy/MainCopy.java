package com.demo.copy;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-18
 * @time 22:14
 */
public class MainCopy {

    public static void main(String[] args) throws CloneNotSupportedException {

        //引用copy
        Teacher teacher =new Teacher("wuqing",1);
        Teacher otherteacher = teacher;
        System.out.println(teacher==otherteacher);

        //对象copy
        Teacher teacher1 =new Teacher("wuqing",1);
        Teacher teacher2 = (Teacher) teacher1.clone();
        System.out.println(teacher2==teacher1);

    }

}
