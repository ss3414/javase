package com.biezhi.c05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class C05_2 {

    /* 构造器引用 */
//    @Test
    public void test() {
        Supplier<C05_2> supplier = C05_2::new;
        C05_2 object = supplier.get();
        System.out.println(object);
    }

    /* 数组引用 */
//    @Test
    public void test2() {
        Function<Integer, String[]> function = String[]::new; /* 传入的参数怎么决定数组长度的？ */
        String[] array = function.apply(100);
        System.out.println(array.length);
    }

    /*
     * Lambda异常
     * ①Lambda不允许抛出受检异常
     * ②要么直接处理（输出堆栈信息），要么包装为RuntimeException抛出
     * */
//    @Test
    public void test3() {
        Function<BufferedReader, String> function = (BufferedReader reader) -> {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        };
    }

    @FunctionalInterface
    interface MyFunction<T, R> {

        R apply(T t) throws Exception;

    }

    /* 包装器，参数是方法 */
    public static <T, R> Function<T, R> warp(MyFunction<T, R> function) {
        return t -> {
            try {
                return function.apply(t);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        };
    }

    /* fixme 函数式接口+Lambda异常 */
    @Test
    public void test4() {
        List<String> list = Collections.singletonList("Test");
        list.stream()
                .map(C05_2.warp(Class::forName))
                .collect(Collectors.toList());
    }

    /*
     * 断点条件
     * 断点回退
     * 断点级别：All/Thread（调试多线程）
     * 变量查看（直接输入）
     * */

}
