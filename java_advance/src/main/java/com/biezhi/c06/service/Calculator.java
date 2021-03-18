package com.biezhi.c06.service;

import com.biezhi.c06.service.impl.CalculatorImpl;

public interface Calculator {

    int add(int x, int y);

    int sub(int x, int y);

    int multi(int x, int y);

    int divide(int x, int y);

    default int mod(int x, int y) {
        return x % y;
    }

    static Calculator getInstance() {
        return new CalculatorImpl();
    }

}
