package collection.list;

import org.junit.jupiter.api.Test;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

public class Vector<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable {

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    /*
     * Vector（向量）
     * ArrayList的线程安全版
     *
     * add添加/get获取都用synchronized实现同步
     * */
    @Test
    public void test() {
        List<String> list = new java.util.Vector<>();
    }

}
