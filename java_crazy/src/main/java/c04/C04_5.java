package c04;

import org.junit.jupiter.api.Test;

public class C04_5 {

    @Test
    public void test() {
        /*
         * ①数组也是一种数据类型，而且是引用类型
         * ②数组初始化完成长度不可变
         * */
        int[] array1 = {1, 2, 3}; /* 静态初始化 */
        int[] array2 = new int[10]; /* 动态初始化，数组元素默认值是null */

        System.out.println(array1.length);

        /* 二维数组 */
        int[][] array = new int[2][2];
    }

}
