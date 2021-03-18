package c07;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

public class C07_3 {

    /*
     * Object
     * 所有Java类都继承自Object类，拥有Object类的方法
     * hashCode/equals成对出现
     * toString
     *
     * clone
     * 深拷贝：拷贝时成员变量（引用类型）也应当拷贝
     * 浅拷贝：不拷贝成员变量
     *
     * wait/notify/notifyAll线程间通信
     *
     * finalize通知GC回收？
     * */
//    @Test
    public void test() {
        Date date1 = new Date();
        Date date2 = date1;
        Date date3 = (Date) date1.clone(); /* 实现Cloneable接口 */
        System.out.println(date1 == date2); /* 比较对象地址 */
        System.out.println(date1 == date3);
    }

    /* Objects */
    @Test
    public void test2() {
        System.out.println(Objects.toString(null));
    }

    /* 随机数 */
//    @Test
    public void test3() {
//        System.out.println((int) (Math.random() * 10));
        Random random = new Random();
        System.out.println(random.nextInt(4) + 4); /* 4~8 */
    }

}
