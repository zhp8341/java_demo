package com.demo.object;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author zhuhuipei
 * @Description:
 * @date 2019-08-18
 * @time 21:50
 */
public class ObjectMain  extends  Object{

    public static void main(String[] args) {

        User user1 = new User("zhp", "123456");
        User user2 = new User("zhp", "123456");
        User user3 = user1;

        System.out.println(user1 == user3);
        System.out.println(user1.equals(user2));
        Map<Object, String> map = new HashMap();
        map.put(user1, "1");
        map.put(user2, "1");

        System.out.println(map);


        System.out.println("-------------------");



    }


}

class User {
    private String name;

    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }
}
