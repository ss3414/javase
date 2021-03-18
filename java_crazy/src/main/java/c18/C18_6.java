package c18;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class C18_6 {

    @Test
    public void test() throws NoSuchFieldException {
        Class<?> clazz = C18_2.class;
        Field field = clazz.getField("str");
        Class<?> type = field.getType(); /* 只能获取非泛型变量的类型 */

        Field field2 = clazz.getField("map");
        Type type2 = field2.getGenericType();
        ParameterizedType type3 = (ParameterizedType) type2; /* 泛型变量的类型 */
        System.out.println(type3.getRawType());
        System.out.println(Arrays.toString(type3.getActualTypeArguments()));
    }

}
