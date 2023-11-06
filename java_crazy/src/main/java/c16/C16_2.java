package c16;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class C16_2 {

    /* 继承Thread类 */
    class Test1 extends Thread {
        @Override
        public void run() {
            /*
             * 因为继承了Thread类，可以直接调用父类的getName方法
             * 相当于main()中的Thread.currentThread().getName()
             * */
            System.out.println("Thread:" + getName());
        }
    }

    /* 实现Runnable接口 */
    class Test2 implements Runnable {
        @Override
        public void run() {
            System.out.println("Runnable:" + Thread.currentThread().getName());
        }
    }

    /* 实现Callable接口 */
    class Test3 implements Callable {
        @Override
        public Object call() throws Exception {
            return String.format("Callable:%s", Thread.currentThread().getName());
        }
    }

    class Test4 extends FutureTask {
        private CountDownLatch countDownLatch;

        public Test4(@NotNull Callable callable, CountDownLatch countDownLatch) {
            super(callable);
            this.countDownLatch = countDownLatch;
        }

        @Override
        protected void done() {
            this.countDownLatch.countDown();
        }
    }

    /*
     * 3种新建线程的方式
     * Runnable/Callable必须用Thread包装执行，否则是主线程下的一个普通方法
     * Callable可以有返回值，用FutureTask包装
     * */
    @Test
    public void test() throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName());
//        new Test1().start();
//        new Thread(new Test2()).start();

//        FutureTask futureTask = new FutureTask(new Test3());
//        new Thread(futureTask).start();
//        while (true) {
//            if (futureTask.isDone()) {
//                System.out.println(futureTask.get());
//                break;
//            }
//        }

        /* 倒数计时（多个类使用同一个CountDownLatch） */
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Test4 test4 = new Test4(new Test3(), countDownLatch);
        new Thread(test4).start();
        countDownLatch.await(); /* 等待CountDownLatch等于0 */
        System.out.println(test4.get());
    }

}
