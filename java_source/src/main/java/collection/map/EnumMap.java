package collection.map;

import java.util.AbstractMap;
import java.util.Set;

public class EnumMap<K extends Enum<K>, V> extends AbstractMap<K, V> implements java.io.Serializable, Cloneable {

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

}
