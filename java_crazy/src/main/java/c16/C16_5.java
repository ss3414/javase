package c16;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

public class C16_5 {

    private static Integer count = 0;

    public void test() {
        count++;
    }

    public synchronized void test2() {
        count++;
    }

    //    @Test
    public void test3() {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        IntStream.range(0, 10000)
//                .forEach(i -> executor.submit(this::test));
                .forEach(i -> executor.submit(this::test2)); /* 用synchronized实现同步 */
        System.out.println(count);
    }

    /*
     * Lock显式锁代替synchronized隐式锁
     * ReentrantLock互斥锁（类似synchronized）
     * */
    private ReentrantLock lock = new ReentrantLock();

    public void test4() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    //    @Test
    public void test5() {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        IntStream.range(0, 10000)
                .forEach(i -> executor.submit(this::test4));
        System.out.println(count);
    }

    /*
     * ReadWriteLock读写锁
     * 只要没有线程获取写锁，读取是并发的无需等待
     * */
    @Test
    public void test6() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        ReadWriteLock lock2 = new ReentrantReadWriteLock();
        List<Integer> list = new ArrayList<>();
        Runnable runnable = () -> {
            lock2.writeLock().lock();
            try {
                list.add(1);
            } finally {
                lock2.writeLock().unlock();
            }
        };
        Runnable runnable2 = () -> {
            System.out.println(Thread.currentThread().getName());
            lock2.readLock().lock();
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(list);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock2.readLock().unlock();
            }
        };
        executor.submit(runnable);
        executor.submit(runnable2);
        executor.submit(runnable2);
    }

    /*
     * StampedLock
     * 支持读写锁/乐观锁
     * */

    /*
     * 信号量
     * */

}
