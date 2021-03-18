package c18;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class C18_4 {

    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = Class.forName("c18.C18_2");
        Object object = clazz.newInstance(); /* 通过newInstance()创建对象 */
        System.out.println(object);

        Field field = clazz.getField("str"); /* 访问成员变量 */
        C18_2 c18_2 = new C18_2();
        field.set(c18_2, "str");
        System.out.println(c18_2.str);

        Method method = clazz.getMethod("test3", String.class);
        method.invoke(object, "para"); /* 调用方法 */
    }

}
