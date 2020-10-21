package com.demo.datastruct;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-09-20
 * @time 17:50
 */
public class Student {

    private String name;
    private String address;
    private Long id;

    @Override
    public int hashCode() {
        return this.hash(name,address,id);
    }

    /**
     * 模拟返回的hash值
     * @param obj
     * @return
     */
    private int hash(Object...obj){
        if (obj == null) {
            return 0;
        }
        int result=0;
        for (Object o : obj) {
            result = result+1;
        }
        return result;
    }

}
