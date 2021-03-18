package com.biezhi.c06.service.impl;

import com.biezhi.c06.service.Calculator;

public class CalculatorImpl implements Calculator {

    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public int sub(int x, int y) {
        return x - y;
    }

    @Override
    public int multi(int x, int y) {
        return x * y;
    }

    @Override
    public int divide(int x, int y) {
        return x / y;
    }

}
