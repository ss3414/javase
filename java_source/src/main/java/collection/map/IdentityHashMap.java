package collection.map;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

public class IdentityHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, java.io.Serializable, Cloneable {

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Test
    public void test() {
        Map<String, Object> map = new java.util.IdentityHashMap<>();
    }

}
