package collection.queue;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Deque;
import java.util.Iterator;

public class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E>, Cloneable, Serializable {

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterator<E> descendingIterator() {
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

    /*
     * ArrayDeque
     * 数组实现的双端队列
     * 不允许添加null元素
     * 线程不安全
     *
     * push/addFirst/offerFirst：入栈，添加后检查容量扩容2倍
     * pop/removeFirst/pollFirst：出栈
     * peek/peekFirst：获取栈顶元素
     *
     * add/offer/addLast/offerLast：入队，添加后检查容量扩容2倍
     * remove/poll/removeFirst/pollFirst：出队
     * element/peek/getFirst/peekFirst：获取队首元素
     * */
    @Test
    public void test() {
        Deque<String> deque = new java.util.ArrayDeque<>();
        deque.push("1");
        deque.push("2"); /* 1,2 右侧为栈顶 */
        deque.pop();
        System.out.println(deque.peek());

        deque.add("2");
        deque.remove(); /* 1,2 右侧为队首，左侧为队尾 */
        System.out.println(deque.element());
    }

}
