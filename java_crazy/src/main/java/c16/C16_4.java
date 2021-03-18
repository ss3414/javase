package c16;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class C16_4 {

    /* 创建CompletableFuture */
    @Test
    public void test() throws ExecutionException, InterruptedException {
        CompletableFuture future = CompletableFuture.runAsync(() -> System.out.println(Thread.currentThread().getName()));
        CompletableFuture future2 = CompletableFuture.supplyAsync(() -> "result");
        System.out.println(future2.get());
    }

}
