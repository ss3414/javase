package c09;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class C09_2 {

    @Data
    class Github<T> {

        private T object;

    }

    @Data
    class Github2 extends Github<String> { /* 继承/实现泛型类/接口时，不能再使用泛型形参 */

    }

    @Data
    class Github3 extends Github { /* 继承/实现泛型类/接口时，没有传入实参 */

    }

    //    @Test
    public void test() {
        /*
         * ①List接口的定义：List<E>
         * ②使用List时为E形参传入了String实参，则产生了一个新的类型List<String>，可以认为是List的子类型
         * */
        List<String> list = new ArrayList<>();

        Github<String> github = new Github<>();
        github.setObject("str"); /* 泛型实参为String型，则object为String型 */
        System.out.println(github.getObject());
    }

    /* 从泛型类派生子类 */
//    @Test
    public void test2() {
        Github2 github2 = new Github2();
        github2.setObject("str");
        System.out.println(github2.getObject());

        Github3 github3 = new Github3();
        github3.setObject("str"); /* 注意此时object是Object类型，且编译器会警告 */
        System.out.println(github3.getObject());
    }

    /*
     * 并不存在泛型类
     * ①instanceof关键字也不允许判断泛型类
     * */
    @Test
    public void test3() {
        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        System.out.println(list1.getClass() == list2.getClass());
    }

}
