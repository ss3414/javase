package com.pattern.c02;

import org.junit.jupiter.api.Test;

public class Proxy {

    interface Useable {
        void test();
    }

    /* 真实/代理对象必须实现同一个接口 */
    class User implements Useable {
        @Override
        public void test() {
            System.out.println("User");
        }
    }

    class UserProxy implements Useable {
        private User user;

        @Override
        public void test() {
            if (user == null) {
                user = new User();
            }
            user.test();
        }
    }

    @Test
    public void test() {
        Useable userProxy = new UserProxy();
        userProxy.test();
    }

}
