package c14;

import org.junit.jupiter.api.Test;

public class C14_1 {

    /*
     * ①Java注解属于元编程，注解本身只是个标记，一般由反射完成注解的功能
     * */

    /*
     * ①@Override：重写父类方法
     * ②@Deprecated：过时
     * ③@SuppressWarnings：抑制编译器警告
     * ④@SafeVarargs：堆污染警告
     * ⑤@FunctionalInterface：检查是否为函数式接口
     * */
    @Override
    @Deprecated
    @SuppressWarnings(value = "unchecked")
    public String toString() {
        return "C14_1";
    }

    @Test
    public void test() {
        C14_1 c14_1 = new C14_1();
        System.out.println(c14_1.toString());
    }

}
