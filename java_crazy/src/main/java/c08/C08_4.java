package c08;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;

import java.util.*;

public class C08_4 {

    //    @Test
    public void test() {
        /*
         * ①Vector（向量）
         * ②Vector线程安全，ArrayList线程不安全
         * */
        List<String> list = new Vector<>();
        list.add("str1");
        list.add("str2");
        list.add("str3");
    }

    //    @Test
    public void test2() {
        String[] array = {"str1", "str2", "str3"};
        List<String> list = Arrays.asList(array); /* Arrays.asList()转换的List只能查看不能增删改 */
        list.add("str4");
    }

    /* List去重 */
    @Test
    public void test3() {
        Map<String, Object> map1 = ImmutableMap.<String, Object>builder().put("key", "value").build();
        Map<String, Object> map2 = ImmutableMap.<String, Object>builder().put("key", "value").build();

        List list = new ArrayList(Arrays.asList(map1, map2));
        HashSet set = new HashSet(list);
        list.clear();
        list.addAll(set);
        System.out.println(list);
    }

}
