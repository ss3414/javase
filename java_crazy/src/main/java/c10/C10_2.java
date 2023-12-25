package c10;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;

public class C10_2 {

    /*
     * 异常
     * ①Checked异常/Runtime异常
     * ②Java强制程序处理所有Checked异常
     *
     * Java异常体系
     * ①Exception（异常）/Error（错误），都继承自Throwable
     * */
//    @Test
    public void test() {
        try {
            Integer i = null;
            System.out.println(i.toString());
        } catch (NullPointerException e) { /* 先处理小异常，再处理大异常 */
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) { /* 捕获并抛出异常 */
            e.printStackTrace();
        } finally {
            System.out.println("finally"); /* 不管是否出现异常，都会执行finally */
        }
    }

    /* 自动关闭资源 */
    @Test
    public void test2() {
        File file = new File("");
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            fileInputStream.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
