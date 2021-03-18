package com.biezhi.c04;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class C04 {

    /*
     * ①在函数式接口上使用Lambda表达式
     * ②java.util.function
     * ③类型推断
     * */

    /* Predicate（断言） */
//    @Test
    public void test() {
        Predicate<String> startsWith = x -> x.startsWith("s"); /* 参数/箭头符号/主体 */
        System.out.println(startsWith.test("str"));
    }

    /* Consumer（消费者） */
//    @Test
    public void test2() {
        Consumer<String> print = x -> System.out.println(x);
        print.accept("str");
    }

    /* Function（函数） */
//    @Test
    public void test3() {
        Function<Integer, String> intToString = x -> String.valueOf(x);
        System.out.println(intToString.apply(1));
    }

    /* Supplier（生产者） */
    @Test
    public void test4() {
        Supplier<String> uuid = () -> UUID.randomUUID().toString();
        System.out.println(uuid.get());
    }

}
