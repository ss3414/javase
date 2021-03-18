package com.internal;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class C03 {

    /* Collection中的新方法 */
    @Test
    public void test() {
        /* forEach+Consumer */
        List<Integer> list = Arrays.asList(2, 3, 5, 7);
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer o) {
                System.out.println(o);
            }
        });
        list.forEach(o -> System.out.println(o));

        /* removeIf+Predicate */
        List<Integer> list2 = new ArrayList<>(Arrays.asList(2, 3, 5, 7)); /* Arrays.asList()生成的List无法修改 */
        list2.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer o) {
                return o >= 3;
            }
        });
        list2.removeIf(o -> o >= 3);
        System.out.println("list2:" + list2);

        /* removeIf+UnaryOperator */
        List<Integer> list3 = Arrays.asList(2, 3, 5, 7);
        list3.replaceAll(new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer o) {
                if (o >= 3) {
                    return 0;
                }
                return o;
            }
        });
        list3.replaceAll(o -> {
            if (o >= 3) {
                return 0;
            }
            return o;
        });
        System.out.println("list3:" + list3);
    }

}
