package c10;

import org.junit.jupiter.api.Test;

public class C10_3 {

    /*
     * ①只有Java有Checked异常这个设计
     * ②Checked异常被认为是一个比较失败的设计（Kotlin砍掉了Checked异常）
     * */
    @Test
    public void test() {
        test2();
        test3();
    }

    public void test2() {
        try {
            Integer i = null;
            System.out.println(i.toString());
        } catch (NullPointerException e) { /* NullPointerException是RuntimeException */
            e.printStackTrace();
        }
        System.out.println("test2");
    }

    /* 向上抛的异常如果不做处理，异常最终会被交给JVM，JVM打印异常堆栈并结束程序 */
    public void test3() throws NullPointerException {
        Integer i = null;
        System.out.println(i.toString());
        System.out.println("test3");
    }

}
