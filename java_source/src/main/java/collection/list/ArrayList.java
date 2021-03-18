package collection.list;

import org.junit.jupiter.api.Test;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable {

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    /*
     * ArrayList
     * 数组实现的列表
     * 允许添加null元素
     * 默认容量10
     * 添加元素前会检查容量，容量不足自动扩容到原来的1.5倍
     * 线程不安全
     *
     * add直接/下标添加：可能需要扩容O(n)，下标添加可能会挪动元素O(n)
     * set下标更新：O(1)
     * get下标获取：O(1)
     * remove下标/条件删除：O(n)
     * size尺寸：返回列表的长度（每次增删元素都会修改size），O(1)
     * isEmpty是否为空：O(1)
     * */
    @Test
    public void test() {
        List<String> list = new java.util.ArrayList<>();
        list.add("1");
        list.add(0, "2"); /* List不允许跨范围添加 */
        System.out.println(list);
        System.out.println(list.size());
    }

}
