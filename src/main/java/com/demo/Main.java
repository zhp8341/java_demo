package com.demo;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-09-04
 * @time 17:42
 */
public class Main {
    //private static final String MATCHE = "^pt_\\w+";
    private static final String MATCHE = "^pt_.*";
    public static void main(String[] args){



        String s="PT__0_trade_shop".toLowerCase();

        System.out.println(s.contains("pt_"));
        System.out.println(s.contains("pt_"));
        System.out.println(s.indexOf("pt_"));
        System.out.println(s.matches(MATCHE));
    }
}
