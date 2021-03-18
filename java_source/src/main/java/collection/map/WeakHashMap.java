package collection.map;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

public class WeakHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V> {

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Test
    public void test() {
        Map<String, Object> map = new java.util.WeakHashMap<>();
    }

}
