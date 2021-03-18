package c08;

import org.junit.jupiter.api.Test;

import java.util.*;

public class C08_3 {

    /*
     * Set
     * ①无序集合，元素不允许重复（通过计算元素哈希值判断是否重复）
     * ②Hash：哈希/散列，生成数据指纹
     * */
//    @Test
    public void test() {
        Set<String> set = new HashSet<>();
        set.add("str1");
        set.add("str2");
        set.add("str3");
        set.forEach(System.out::println);
    }

    //    @Test
    public void test2() {
        Set<String> set = new LinkedHashSet<>(); /* 链表维护元素的顺序 */
        set.add("str1");
        set.add("str2");
        set.add("str3");
        set.forEach(System.out::println);
    }

    //    @Test
    public void test3() {
        SortedSet<String> set = new TreeSet<>(); /* SortedSet的实现类 */
        set.add("str1");
        set.add("str2");
        set.add("str3");
        System.out.println(set.first());
    }

    @Test
    public void test4() {
        Set<Github> set = EnumSet.allOf(Github.class);
        System.out.println(set);
    }

}
