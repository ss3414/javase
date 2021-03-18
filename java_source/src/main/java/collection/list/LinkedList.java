package collection.list;

import org.junit.jupiter.api.Test;

import java.util.*;

public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, java.io.Serializable {

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public void addFirst(E e) {
    }

    @Override
    public void addLast(E e) {
    }

    @Override
    public boolean offerFirst(E e) {
        return false;
    }

    @Override
    public boolean offerLast(E e) {
        return false;
    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public void push(E e) {
    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }

    /*
     * LinkedList
     * 双向链表实现的列表
     * 由Node节点构成，包含数据和指向前后节点的指针
     * 既实现了List，又实现了Deque，既是列表，又是双端队列（栈+队列）
     * 可以用LinkedList取代Stack，用ArrayDeque取代LinkedList
     * 线程不安全
     *
     * add直接/下标添加：下标添加需要先查找O(n)，添加O(1)
     * set下标更新：查找O(n)，更新O(1)
     * get下标获取：查找O(n)
     * remove下标/条件删除：查找O(n)，删除O(1)
     *
     * 链表不需要扩容，直接添加O(1)
     * */
    @Test
    public void test() {
        List<String> list = new java.util.LinkedList<>();
        list.add("1");
        list.add(1, "2");
        System.out.println(list);
    }

}
