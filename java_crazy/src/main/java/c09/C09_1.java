package c09;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class C09_1 {

    /*
     * 泛型入门
     * ①Java集合可以保存任何类型的对象，从集合中取出对象时需要强制类型转换
     *
     * 泛型通配符
     * ?（不确定的类型）
     * T（Type，确定的类型）
     * K,V（Key,Value）
     * E（Element）
     * R（Result，函数式接口返回值的类型）
     * */
    @Test
    public void test() {
        List list = new ArrayList();
        list.add("str1");
        list.add("str2");
        list.add(3); /* list使用泛型则此处编译无法通过 */
        /*
         * ①编译能通过（编译时不检查类型的异常）
         * ②抛出java.lang.ClassCastException异常
         * */
        list.forEach(e -> System.out.println(((String) e).length()));
    }

}
