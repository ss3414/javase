package collection.set;

import org.junit.jupiter.api.Test;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, java.io.Serializable {

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    /*
     * HashSet
     * 对HashMap的封装
     *
     * add添加：相当于向被封装的HashMap中添加Entry（value为空的Object）
     * */
    @Test
    public void test() {
        Set<String> set = new java.util.HashSet<>();
    }

}
