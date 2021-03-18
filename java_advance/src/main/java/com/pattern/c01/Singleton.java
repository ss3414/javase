package com.pattern.c01;

import org.junit.jupiter.api.Test;

public class Singleton {

    private static Singleton singleton = new Singleton();

    /* 构造器私有，禁止使用new创建实例 */
//    private Singleton() {
//    }

    public static Singleton getInstance() {
        return singleton;
    }

    /* 单例：只有一个实例 */
    @Test
    public void test() {
        Singleton singleton1 = Singleton.getInstance(); /* 第一次调用getInstance时生成唯一的实例 */
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1.equals(singleton2));
    }

}
