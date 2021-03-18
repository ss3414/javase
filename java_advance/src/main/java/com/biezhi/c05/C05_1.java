package com.biezhi.c05;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Data
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class C05_1 {

    private Long id;

    public static List<Integer> test(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> result = list.stream().filter(predicate).collect(toList());
        return result;
    }

    /* 参数是否为3的倍数 */
    public static boolean test2(Integer i) {
        return (i % 3) == 0;
    }

    /*
     * 方法引用
     * ①静态方法引用
     * ②对象方法引用
     * */
    @Test
    public void main() {
        List<Integer> list = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19);
        List<Integer> result = test(list, C05_1::test2); /* 静态方法引用 */
        System.out.println(result);

        C05_1 object = new C05_1();
        object.setId(1L);
        System.out.println(Stream.of(object).map(C05_1::getId).count()); /* 对象方法引用 */
    }

}
