package collection.concurrent;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> {

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    /*
     * ConcurrentHashMap
     * JDK7：分段锁
     * JDK8：数组+链表/红黑树实现，synchronized/volatile+CAS实现线程安全
     * synchronized只锁定链表/红黑树首节点，写入时只要没有哈希冲突就不会产生并发？
     * 线程安全
     * */
    @Test
    public void test() {
        Map<String, Object> map = new java.util.concurrent.ConcurrentHashMap<>();
    }

}
