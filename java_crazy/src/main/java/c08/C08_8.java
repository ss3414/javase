package c08;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class C08_8 {

    /* 排序 */
//    @Test
    public void test() {
        Integer[] array = new Integer[]{5, 2, 3, 7};
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
//        Collections.reverse(list); /* 反转 */
//        Collections.sort(list); /* 升序 */
//        Collections.swap(list, 0, list.size() - 1); /* 替换 */
        Collections.rotate(list, -1); /* 旋转 */
        System.out.println(list);
    }

    /* 查找/替换 */
//    @Test
    public void test2() {
        Integer[] array = new Integer[]{5, 2, 3, 7};
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
//        System.out.println(Collections.binarySearch(list, 2)); /* 二分法查找 */
        Collections.replaceAll(list, 7, 9); /* 替换 */
        System.out.println(list);
    }

    /* 同步 */
//    @Test
    public void test3() {
        Integer[] array = new Integer[]{5, 2, 3, 7};
        List<Integer> list = Collections.synchronizedList(new ArrayList<>(Arrays.asList(array)));
    }

    /* 不可变 */
    @Test
    public void test4() {
        List<Integer> list = Collections.singletonList(2);
    }

}
