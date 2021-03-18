package c06;

import org.junit.jupiter.api.Test;

public class C06_6 {

    abstract class ParentClass {
        public abstract void test();
    }

    interface ParentInterface {
        void test2(); /* 抽象方法，默认用public abstract修饰 */

        static void test3() { /* 类方法，可以有实现 */
            System.out.println("test3");
        }

        /*
         * ①默认方法，default修饰
         * ②Java不支持多继承，所以提供了接口，Java8之前抽象类有实现接口没有，Java8之后接口=可多继承的类
         * */
        default void test4() {
        }
    }

    interface ParentInterface2 extends ParentInterface {
    }

    class SonClass1 extends ParentClass {
        @Override
        public void test() {
        }
    }

    class SonClass2 implements ParentInterface {
        @Override
        public void test2() {
        }
    }

    class SonClass3 extends ParentClass implements ParentInterface {
        @Override
        public void test() {
        }

        @Override
        public void test2() {
        }
    }

    /*
     * 接口
     * ①接口中只能定义抽象/类/默认方法
     * ②接口之间也可以继承
     *
     * 抽象类和接口
     * ①Java8之前
     * 不能被实例化，需要被继承/实现
     * 可以包含抽象方法
     * 接口只能定义静态变量/不能定义构造器和初始化块
     * 一个类只能有一个直接父类，但允许实现多个接口
     * ②Java8之后
     * 接口=可多继承的类
     * */
    @Test
    public void test() {
        ParentClass sonClass1 = new SonClass1();
        ParentInterface sonClass2 = new SonClass2();

        ParentClass sonClass3 = new SonClass3();
        sonClass3.test();
        ParentInterface sonClass4 = new SonClass3();
        sonClass4.test2();
        SonClass3 sonClass5 = new SonClass3();
        sonClass5.test();
        sonClass5.test2();

        ParentInterface.test3(); /* 接口的类方法 */
    }

}
