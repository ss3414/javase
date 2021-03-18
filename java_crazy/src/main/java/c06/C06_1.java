package c06;

import org.junit.jupiter.api.Test;

public class C06_1 {

    /*
     * 包装器类
     * ①Java中除基本类型外一切皆对象，基本类型有其对应包装器类
     * ②基本类型直接将值保存在栈中，包装器类将对象保存在堆中，然后在栈中引用
     * ③包装器类的默认值为null，基本类型boolean默认为false，char默认为十六进制0，其他默认为0
     * */
    @Test
    public void test() {
        Integer i = 1; /* 装箱，等价于Integer.valueOf(1) */
        int j = i; /* 拆箱，等价于i.intValue() */
    }

}
