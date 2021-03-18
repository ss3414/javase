package c16;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class C16_7 {

    /*
     * 原子操作
     * 多线程中并发安全的操作且不需要synchronized/Lock
     * 原子操作依赖CAS（Compare And Swap/比较与交换）
     *
     * 基本类型：AtomicBoolean/AtomicInteger/AtomicLong
     * 引用类型：AtomicMarkableReference/AtomicReference/AtomicStampedReference
     * 数组：AtomicIntegerArray/AtomicLongArray/AtomicReferenceArray
     * 属性修改：AtomicIntegerFieldUpdater/AtomicLongFieldUpdater
     * LongAccumulator/LongAdder
     * */
    private static AtomicInteger count = new AtomicInteger(0);

    public void test() {
        count.addAndGet(1);
    }

    @Test
    public void test2() {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        IntStream.range(0, 10000).forEach(i -> executor.submit(this::test));
        System.out.println(count.get());
    }

    /*
     * 并发集合
     * ConcurrentHashMap/ConcurrentSkipListMap+ConcurrentLinkedQueue/ConcurrentLinkedDeque+ConcurrentSkipListSet
     * Concurrent开头，线程安全，读取操作时不必锁定
     *
     * CopyOnWriteArrayList+CopyOnWriteArraySet
     * CopyOnWrite开头，读写分离
     *
     * 非阻塞队列：ConcurrentLinkedQueue/ConcurrentLinkedDeque
     * 阻塞队列：BlockingQueue/BlockingDeque+ArrayBlockingQueue+LinkedBlockingQueue/LinkedBlockingDeque+PriorityBlockingQueue
     * */

}
