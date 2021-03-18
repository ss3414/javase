package com.biezhi.c06.service;

import com.biezhi.c06.service.impl.CalculatorImpl;

public class CalculatorFactory {

    public static Calculator getInstance() {
        return new CalculatorImpl();
    }

}
