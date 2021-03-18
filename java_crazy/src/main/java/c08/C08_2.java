package c08;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C08_2 {

    /*
     * Java集合
     * ①Collection接口：List（有序集合）/Set（无序集合）/Queue（队列）
     * ②Map接口
     * */
    @Test
    public void test() {
        List<String> list = new ArrayList<>(); /* List接口，数组实现 */
        list.add("str1");
        list.add("str2");
        list.add("str3");

        Iterator<String> iterator = list.iterator(); /* Iterator迭代器 */
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        list.forEach(System.out::println); /* Lambda迭代 */
    }

}
