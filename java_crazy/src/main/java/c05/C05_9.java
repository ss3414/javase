package c05;

import org.junit.jupiter.api.Test;

public class C05_9 {

    static {
        str1 = "类初始化块";
    }

    {
        str2 = "对象初始化块";
    }

    private static String str1;
    private String str2;

    /*
     * 初始化块
     * ①优先级大于构造器
     * ②只能用static修饰
     * */
    @Test
    public void test() {
        System.out.println(C05_9.str1);
        System.out.println(new C05_9().str2);
    }

}
