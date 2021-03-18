package c08;

import org.junit.jupiter.api.Test;

import java.util.*;

public class C08_5 {

    /*
     * Queue
     * ①模拟队列
     * ②队列：先进先出
     * */
//    @Test
    public void test() {
        Queue<Integer> queue = new PriorityQueue<>(); /* PriorityQueue从小到大排序，不符合队列的定义 */
        queue.offer(5);
        queue.offer(3);
        queue.offer(2);
        System.out.println(queue);
    }

    /*
     * Deque
     * ①Deque是Queue的子接口，代表双端队列
     * ②offer加入队列尾部，poll获取队列头部元素并删除
     * */
//    @Test
    public void test2() {
        Deque<Integer> deque = new ArrayDeque<>(); /* 用ArrayDeque取代Stack */
        deque.offer(5);
        deque.offer(3);
        deque.offer(2);
        System.out.println(deque.poll());
        System.out.println(deque.poll());
        System.out.println(deque.poll());
    }

    /*
     * LinkedList
     * ①LinkedList既实现List接口，又实现Deque接口
     * ②push加入队列头部，pop获取队列头部元素并删除
     * */
    @Test
    public void test3() {
        Deque<Integer> deque = new LinkedList<>();
        deque.push(5);
        deque.push(3);
        deque.push(2);
        System.out.println(deque.pop());
        System.out.println(deque.pop());
        System.out.println(deque.pop());
    }

}
