package com.biezhi.c06;

import com.biezhi.c06.service.Calculator;
import com.biezhi.c06.service.CalculatorFactory;
import com.biezhi.c06.service.impl.CalculatorImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class C06_1 {

    /* 从Java8开始，接口方法可以有方法体，可以有默认实现 */
    @Test
    public void main() {
        /* 接口默认方法 */
        Calculator calculator = new CalculatorImpl();
        System.out.println(calculator.add(1, 1));
        System.out.println(calculator.sub(1, 1));
        System.out.println(calculator.multi(1, 1));
        System.out.println(calculator.divide(1, 1));
        System.out.println(calculator.mod(1, 1));

        /* 接口static方法 */
        Calculator calculator2 = CalculatorFactory.getInstance(); /* 通过工厂模式获取实例 */
        calculator2 = Calculator.getInstance();
        System.out.println(calculator2.add(1, 1));
    }

}
