package collection.set;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, java.io.Serializable {

    /*
     * LinkedHashSet
     * 对LinkedHashMap的封装
     * */
    @Test
    public void test() {
        Set<String> set = new java.util.LinkedHashSet<>();
    }

}
