package c05;

import org.junit.jupiter.api.Test;

public class C05_3 {

    /*
     * 变量
     * ①成员变量：实例变量/类变量
     * ②局部变量：形参/方法局部变量/代码块局部变量
     * */

    private String str1;

    private static String str2;

    @Test
    public void test() {
        System.out.println(new C05_3().str1);
        System.out.println(C05_3.str2);
    }

    public void test2(String str3) {
        String str4 = "";
    }

}
