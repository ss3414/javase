package c14;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class C14_3 {

    @Consume(str = "test")
    public void test() throws InterruptedException {
        Thread.sleep(3 * 1000);
    }

    /*
     * 反射处理注解（Spring中可以使用Runner/Spring AOP）
     * */
    @Test
    public void test2() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = C14_3.class;
        Object object = clazz.newInstance();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Consume.class)) {
                long begin = System.currentTimeMillis();
                method.invoke(object); /* 执行被@Consume修饰的方法 */
                long times = System.currentTimeMillis() - begin;
                System.out.println("耗时：" + times / 1000.0 + "秒");
            }
        }
    }

}
