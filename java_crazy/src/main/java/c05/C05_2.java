package c05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class C05_2 {

    private String str;

    /*
     * ①面向过程：函数（函数是一等公民）
     * ②面向对象：方法（类是一等公民，方法不能独立存在）
     * */
    @Test
    public void test() {
        /* Java只有值传递（传入副本），没有引用传递，只不过在传入引用类型时的值是引用地址 */
        C05_2 c05_2 = new C05_2();
        c05_2.str = "str1";
        System.out.println(c05_2.str);
        c05_2.test2(c05_2); /* test2方法传入的是C05_2对象的引用 */
        System.out.println(c05_2.str);
    }

    public void test2(C05_2 c05_2) {
        c05_2.str = "str2";
    }

    /* 可变形参（当做数组处理） */
    public void test3(String... strs) {
        System.out.println(Arrays.toString(strs));
    }

    /* 重载（方法名相同，形参不同） */
    public void test3(String str) {
    }

}
