package com.demo.annotation;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2020-07-06
 * @time 19:06
 */
public class AnnotationMain {


    public static void main(String[] args) throws Exception {

        Class clazz=  Class.forName("com.demo.annotation.TestClassAnnotation");
        if (clazz.isAnnotationPresent(TestAnnotation.class)) {
            System.out.println("Person类上配置了Info注解！");
            //获取该对象上Info类型的注解
            TestAnnotation infoAnno = (TestAnnotation) clazz.getAnnotation(TestAnnotation.class);
            System.out.println("person.name :" + infoAnno.value() + ",person.isDelete:" + infoAnno.isDelete());
        } else {
            System.out.println("Person类上没有配置Info注解！");
        }
    }
}


@TestAnnotation(isDelete = true,value = "无情")
class TestClassAnnotation {
    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 是否有效
     */
    private boolean isDelete;

}
