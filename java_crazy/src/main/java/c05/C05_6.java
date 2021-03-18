package c05;

import org.junit.jupiter.api.Test;

public class C05_6 {

    class Parent {
        public void test() {
            System.out.println("Parent");
        }
    }

    class Son extends Parent {
        public Son() {
            super(); /* 调用父类构造器 */
        }

        @Override
        public void test() {
            super.test(); /* super调用父类方法 */
            System.out.println("Son");
        }
    }

    @Test
    public void test() {
        Parent son = new Son();
        son.test();
    }

}
