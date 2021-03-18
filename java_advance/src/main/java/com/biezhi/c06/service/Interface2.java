package com.biezhi.c06.service;

public interface Interface2 extends Interface1 {

    default void test() {
        System.out.println("Interface2");
    }

}
