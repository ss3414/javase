package c07;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C07_2 {

    /* System */
//    @Test
    public void test() {
        /* 获取环境变量 */
        System.getenv().entrySet().forEach(System.out::println);

        /* 获取系统属性 */
//        System.getProperties().forEach((key, value) -> System.out.println(key + "=" + value));

        /* GC */
//        System.gc();
    }

    /* Runtime */
//    @Test
    public void test2() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());
        System.out.println(runtime.maxMemory());
        System.out.println(runtime.totalMemory());
        System.out.println(runtime.freeMemory());
    }

    /* Process+Runtime执行外部程序 */
    @Test
    public void test3() throws IOException {
        Process process = Runtime.getRuntime().exec("tasklist");
        /* 执行tasklist进程的输出是main进程的输入 */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }

}
