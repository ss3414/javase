package c16;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class C16_3 {

    /* Executor+Runnable */
//    @Test
    public void test() {
        System.out.println(Thread.currentThread().getName());
        ExecutorService executor = Executors.newSingleThreadExecutor(); /* 单线程线程池 */
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName()); /* Lambda表达式简化 */
        executor.execute(runnable);
    }

    /* Executor+Callable */
//    @Test
    public void test2() {
        ExecutorService executor = Executors.newFixedThreadPool(1); /* 固定大小线程池 */
        Callable callable = () -> {
            TimeUnit.SECONDS.sleep(2);
            return "result";
        };
        Future<?> future = executor.submit(callable); /* execute无返回值/submit有返回值 */
//        while (true) {
//            try {
//                if (future.isDone()) {
//                    System.out.println("结束运行");
//                    System.out.println(future.get());
//                    break;
//                }
//                TimeUnit.SECONDS.sleep(1);
//                System.out.println("正在运行");
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//        }

        /* 等待Future结束运行 */
        try {
            System.out.println(future.get(3, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    /* 定时Future */
//    @Test
    public void test3() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1); /* 定时/周期线程池 */
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName());
        ScheduledFuture<?> future = executor.schedule(runnable, 1, TimeUnit.SECONDS); /* 延时1秒 */
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println(future.getDelay(TimeUnit.SECONDS)); /* 新线程延时1秒，主线程等待3秒，返回-2（2秒前执行） */
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* 周期Future */
//    @Test
    public void test4() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName());
        executor.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* 时间叠加 */
//    @Test
    public void test5() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable runnable = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        executor.scheduleWithFixedDelay(runnable, 0, 1, TimeUnit.SECONDS);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* 批量运行 */
    @Test
    public void test6() {
        ExecutorService executor = Executors.newWorkStealingPool();
        List<Callable<String>> list = Arrays.asList(
                () -> "result1",
                () -> "result2",
                () -> "result3"
        );
        try {
            executor.invokeAll(list).stream()
                    .map(future -> {
                        try {
                            return future.get();
                        } catch (InterruptedException | ExecutionException e) {
                            throw new RuntimeException(e); /* 必须抛出RuntimeException */
                        }
                    }).forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /************************************************************分割线************************************************************/

    /*
     * fixme ThreadPoolExecutor
     * 推荐ThreadPoolExecutor而非Executors创建线程池
     * SingleThreadExecutor/FixedThreadPool允许请求的队列长度为Integer.MAX_VALUE，可能堆积大量请求
     * ScheduledThreadPool/CachedThreadPool可能创建大量线程
     * */
//    @Test
    public void test7() {
        /*
         * 饱和策略（线程/队列已满时的处理策略）
         * AbortPolicy：抛出异常
         * CallerRunsPolicy：回调执行自己的线程运行任务
         * DiscardPolicy：不处理新任务
         * DiscardOldestPolicy：丢弃最早未处理任务
         * */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1, /* 最小线程 */
                10, /* 最大线程 */
                1, /* 等待时间 */
                TimeUnit.SECONDS, /* 单位 */
                new ArrayBlockingQueue<>(10), /* 任务队列 */
                new ThreadPoolExecutor.CallerRunsPolicy());
        Runnable runnable = () -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i < 10; i++) {
            executor.submit(runnable);
            System.out.println(executor.getActiveCount());
        }
        executor.shutdown();
    }

}
