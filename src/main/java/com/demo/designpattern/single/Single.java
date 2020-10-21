package com.demo.designpattern.single;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2020-03-24
 * @time 16:34
 */
public class Single {

    private static Single single = null;

    private Single() {
        System.out.println("sssssss");
    }

    private static Single createInstance() {
        if (single == null) {
            single = new Single();
        }
        return single;
    }

    public static synchronized Single getInstance() {

        return createInstance();
    }




}
