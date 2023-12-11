package c08;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class C08_6 {

    /*
     * Map
     * ①如果把Map中的所有Key放在一起看，就组成了一个Set
     * ②所有Value放在一起看，就组成了一个List
     * */
//    @Test
    public void test() {
        /*
         * ①Hashtable（哈希表）
         * ②Hashtable线程安全，HashMap线程不安全
         * ③不推荐使用Hashtable
         * */
        Map<String, Object> map = new Hashtable<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        System.out.println(map.keySet());
        System.out.println(map.values());

        /* 遍历键值 */
//        for (Map.Entry<String, Object> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }

        map.forEach((k, v) -> System.out.println(k + ":" + v));

        /* 遍历键 */
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        /* 遍历值 */
        for (Object value : map.values()) {
            System.out.println(value);
        }
    }

    //    @Test
    public void test2() {
        Map<String, Object> map = new LinkedHashMap<>(); /* 有序 */
        map.put("key1", "value1");
        map.put("key2", "value2");
        System.out.println(map);
    }

    /*
     * Properties
     * ①Properties是Hashtable的子类，特别适合处理属性文件（.properties/.ini）
     * */
//    @Test
    public void test3() throws IOException {
        Properties properties = new Properties();
        properties.load(C08_6.class.getResourceAsStream("/application.properties"));
        System.out.println(properties.getProperty("jdbc.url"));
    }

    //    @Test
    public void test4() {
        SortedMap<String, Object> map = new TreeMap<>(); /* TreeMap即红黑树 */
        map.put("key1", "value1");
        map.put("key2", "value2");
        System.out.println(map.firstKey()); /* 返回值最小的Key */
    }

    //    @Test
    public void test5() {
        Map<String, Object> map = new WeakHashMap<>();
        map.put("key1", "value1");
        map.put(new String("key2"), "value2"); /* key2没有被强引用变量引用，GC后自动删除 */
        System.out.println(map);
        System.gc();
        System.out.println(map);
    }

    //    @Test
    public void test6() {
        /*
         * ①两个key1是字面量，同一个引用
         * ②两个key2则是两个引用
         * */
        Map<String, Object> map = new IdentityHashMap<>();
        map.put("key1", "value1");
        map.put("key1", "value1");
        map.put(new String("key2"), "value2");
        map.put(new String("key2"), "value2");
        System.out.println(map);
    }

    //    @Test
    public void test7() {
        Map map = new EnumMap(Github.class);
        map.put(Github.Java, "Java");
        map.put(Github.Python, "Python");
        System.out.println(map);
    }

    @Test
    public void test8() {
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        map.put("key1", "value1");

        /* 迭代时添加 */
        map.forEach((k, v) -> {
            if ("key1".equals(k)) {
                map.put("key2", "value2");
            }
            System.out.println(k + ":" + v);
        });
    }

}
