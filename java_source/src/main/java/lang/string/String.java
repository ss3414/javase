package lang.string;

import org.junit.jupiter.api.Test;

public class String implements java.io.Serializable, Comparable<java.lang.String>, CharSequence {

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }

    @Override
    public int compareTo(java.lang.String o) {
        return 0;
    }

    /*
     * String
     * JDK8：字符数组
     * JDK9：字节数组
     * 字符串常量
     * */
    @Test
    public void test() {
        java.lang.String str = "";
        System.out.println("123".equals("456")); /* 字符串的字面量天然是对象 */
    }

}
