package collection.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class LinkedHashMap<K, V> extends HashMap<K, V> implements Map<K, V> {

    /*
     * LinkedHashMap
     * 数组+链表/红黑树实现
     * 继承自HashMap，数组的元素是链表，链表存储哈希冲突的Entry，再用双向链表连接Entry（有序）
     * 允许key/value为null
     * 线程不安全
     * */
    @Test
    public void test() {
        Map<String, Object> map = new java.util.LinkedHashMap<>();
    }

}
