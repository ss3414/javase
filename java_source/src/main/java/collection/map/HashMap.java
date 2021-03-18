package collection.map;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

public class HashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    /*
     * HashMap
     * JDK6：数组+链表实现，链表储存哈希冲突的元素
     * JDK8：数组+链表/红黑树实现，链表储存的元素超过阈值8时转换为红黑树
     * 默认容量16（必须是2的n次方）
     * 允许key/value为null
     * 线程不安全
     *
     * put添加：先查找是否已添加，再检查容量是否超过阈值（容量16*负载系数0.75），超过阈值扩容2倍并重新哈希
     * get获取：key+哈希函数获取对应下标的链表，再根据key.equals()获取具体元素
     * remove删除
     * */
    @Test
    public void test() {
        Map<String, Object> map = new java.util.HashMap<>();
    }

}
