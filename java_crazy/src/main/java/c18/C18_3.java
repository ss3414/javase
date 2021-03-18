package c18;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class C18_3 {

    //    @Test
    public void test() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("c18.C18_2"); /* 调用ClassLoader通过全限定名获取类的二进制字节流 */
        Class<?> clazz2 = C18_2.class; /* 推荐这种方式获取 */
        C18_2 c18_2 = new C18_2();
        Class<?> clazz3 = c18_2.getClass();
    }

    //    @Test
    public void test2() {
        Class<?> clazz = C18_2.class;
        Constructor<?>[] constructors = clazz.getDeclaredConstructors(); /* 全部构造器 */
        Field[] fields = clazz.getDeclaredFields(); /* 全部成员变量 */
        Method[] methods = clazz.getDeclaredMethods(); /* 全部方法 */
        Annotation[] annotations = clazz.getDeclaredAnnotations(); /* 全部注解 */

        Class<?>[] classes = clazz.getDeclaredClasses(); /* 全部内部类 */
        Class<?> clazz2 = clazz.getDeclaringClass(); /* 外部类 */
        Class<?>[] classes3 = clazz.getInterfaces(); /* 全部接口 */
        Class<?> clazz4 = clazz.getSuperclass(); /* 超类 */

        System.out.println(clazz.isInstance(new C18_2())); /* 代替instanceof关键字 */
    }

    @Test
    public void test3() {
        Class<?> clazz = C18_2.class;
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        System.out.println(constructors[0].getParameterCount());
    }

}
