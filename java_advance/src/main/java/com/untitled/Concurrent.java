package com.untitled;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class Concurrent {

    /*
     * 概念
     * ①并发/并行
     * 并发：同一时间段内，多个任务同时运行
     * 并行：同一时间，多个任务同时运行
     * ②上下文切换
     * 多线程编程中一般线程数>CPU核心数，而一个CPU核心在同一时间只能被一个线程使用
     * 为每个线程分配时间片
     * 当一个线程时间片用完让给其他线程使用，这个过程被称为上下文切换
     * */

    /*
     * 进程/线程
     * ①进程：程序的一次执行过程（创建>运行>消亡）
     * 在Java中，启动main函数即启动一个JVM进程，main函数所在线程即主线程
     * ②线程：比进程更小的执行单位
     * 线程共享进程的堆/方法区，但是有自己的程序计数器/虚拟机栈/本地方法栈
     * */
//    @Test
    public void test2() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        /*
         * 常见线程
         * 给JVM发信号
         * 调用对象的finalize方法
         * 清除引用
         * main
         * */
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(threadInfo.getThreadId() + ":" + threadInfo.getThreadName());
        }
    }

    /*
     * 线程的生命周期和状态
     * ①状态
     * new：新建
     * runnable：运行中，就绪和运行统称运行中
     * blocked：阻塞
     * waiting：等待
     * time_waiting：超时等待
     * terminated：终止
     * ②生命周期
     * 线程创建后进入new状态
     * 调用start方法后进入ready（就绪）状态，分配到CPU时间片后进入running（运行）状态
     * 调用wait方法后进入waiting状态
     * 调用sleep/wait方法后可能进入time_waiting状态，超过超时时间恢复runnable（ready+running）状态
     * 调用同步方法却没有获得锁时进入blocked状态
     * 调用run方法后进入terminated状态
     * */

    /*
     * 线程的方法
     * ①为什么不直接调用run方法
     * 调用start方法后就绪，分配到时间片调用run方法运行（新线程中运行），运行后终止
     * 直接调用run方法会在主线程下当做一个普通方法执行
     * ②wait/sleep
     * 两者都可以暂停线程的运行
     * wait常用于线程间通信，sleep常用于暂停线程
     * wait释放了锁，sleep没有释放锁
     * wait被调用后，线程不会自动苏醒，需要调用notify/notifyAll苏醒
     * sleep被调用后，线程会自动苏醒
     * */
//    @Test
    @SneakyThrows
    public void test4() {
        Thread thread = new Thread();
        thread.start();
//        thread.run();

        thread.wait();
        thread.notify();

        thread.interrupt();

        thread.join();

        Thread.sleep(1000);
        Thread.yield();
    }

    /************************************************************分割线************************************************************/

    /*
     * synchronized
     * ①锁本身是个对象，synchronized是"加锁"，synchronized作用是保证线程间同步
     * ②应用
     * 修饰代码块
     * 修饰实例方法：作用于当前对象实例，进入同步代码块前需要获得对象实例的锁
     * 修饰静态方法：给当前类加锁，作用于所有对象实例（静态成员属于类）
     * ③实现原理
     * 依靠monitorenter/monitorexit指令实现
     * monitorenter指向同步代码块开始，monitorexit指向同步代码块结束
     * 执行到monitorenter指令时，线程获取锁（也就是获取monitor，monitor位于Java对象的对象头中）
     * 获取锁后锁计数器加1，执行monitorexit指令释放锁后锁计数器减1
     * */

    /*
     * 锁
     * ①锁的状态
     * 偏向锁：偏向于第一个获得锁的线程，没有多线程竞争的情况下不需要同步
     * 轻量级锁：如果偏向锁失败再使用轻量级锁，没有多线程竞争的情况下使用CAS代替互斥量
     * 自旋锁：让线程等待（自旋）而非挂起
     * 重量级锁
     *
     * 死锁（有锁才会产生死锁）
     * ①产生死锁的4个条件
     * 互斥条件：资源任意时刻只能由一个线程占用
     * 请求与保持条件：一个线程因申请资源阻塞时，对已获得资源保持不放
     * 不剥夺条件：线程已获得资源在未使用完之前不被其他线程强行剥夺
     * 循环等待条件
     * ②避免死锁
     * 破坏请求与保持条件：一次性申请所有资源
     * 破坏不剥夺条件：阻塞时释放已获得资源
     * 破坏循环等待条件：按序申请，逆序释放
     * */
    private final String resource1 = "resource1";
    private final String resource2 = "resource2";

    //    @Test
    @SneakyThrows
    public void test6() {
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + ":get resource1");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + ":get resource2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + ":get resource2");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + ":get resource1");
                }
            }
        });

        thread1.start(); /* thread1占有resource1，准备获取resource2，thread2相反，产生死锁 */
        thread2.start();
        Thread.sleep(1000);
    }

    /*
     * volatile
     * ①在Java内存模型中，线程可以把变量保存在本地内存（如寄存器）而非主存，可能会导致数据不一致
     * ②作用：保证变量的可见性，防止指令重排序
     * ③volatile/synchronized区别
     * volatile主要解决变量在线程间的可见性，synchronized主要解决线程间同步
     * volatile性能优于synchronized
     * volatile只能修饰变量，而synchronized可以修饰代码块/方法
     * 多线程访问volatile不会发生阻塞，synchronized会
     * volatile保证数据的可见性，synchronized既保证数据的可见性也保证原子性
     *
     * ThreadLocal
     * 线程私有变量
     * */

    /*
     * final
     * final修饰的变量不能修改，即为常量
     * final修饰的方法不能重写，但能重载（方法名相同）
     * final修饰的类不能继承
     * */

    /************************************************************分割线************************************************************/

    /*
     * 旧版并发
     * Thread/Runnable
     * synchronized/volatile/final
     * （Vector/Hashtable）
     *
     * 新版并发JUC（java.util.concurrent）
     * ①Callable+Future
     * ②Executor线程池
     * ③锁（java.util.concurrent.locks）
     * ④AQS（AbstractQueuedSynchronizer，JUC的核心）
     * ⑤Java内存模型：原子性/可见性/有序性
     * ⑥原子（java.util.concurrent.atomic）
     * ⑦并发集合
     * */
    @Test
    public void test9() {
    }

    /*
     * ReentrantLock/synchronized区别
     * 两者都是可重入锁（重入：可以再次获取自己的内部锁）
     * synchronized隐式/ReentrantLock显式（需要手动锁定/解锁）
     * ReentrantLock高级特性：等待可中断/公平锁/选择性通知
     * */

}
