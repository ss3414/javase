package collection.queue;

import org.junit.jupiter.api.Test;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Queue;

public class PriorityQueue<E> extends AbstractQueue<E> implements java.io.Serializable {

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Test
    public void test() {
        Queue<String> queue = new java.util.PriorityQueue<>();
    }

}
