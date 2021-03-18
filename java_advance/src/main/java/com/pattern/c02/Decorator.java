package com.pattern.c02;

import org.junit.jupiter.api.Test;

public class Decorator {

    class Wrapper {
        public Wrapper(User user) {
            System.out.println("User执行前");
            user.test();
            System.out.println("User执行后");
        }
    }

    class User {
        public void test() {
            System.out.println("User");
        }
    }

    @Test
    public void test() {
        /* Python能把函数作为参数传递，Java只能借助反射拦截方法 */
        new Wrapper(new User());
    }

}
