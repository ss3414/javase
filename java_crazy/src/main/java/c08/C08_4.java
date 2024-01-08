package c08;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class C08_4 {

    //    @Test
    public void test() {
        /*
         * ①Vector（向量）
         * ②Vector线程安全，ArrayList线程不安全
         * */
        List<String> list = new Vector<>();
        list.add("str1");
        list.add("str2");
        list.add("str3");
    }

    @Test
    public void test2() {
        String[] array = {"str1", "str2", "str3"};
        List<String> list = Arrays.asList(array); /* Arrays.asList()转换的List只能查看不能增删改 */
        list.add("str4");
    }

}
