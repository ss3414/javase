package c05;

import org.junit.jupiter.api.Test;

public class C05_8 {

    class Parent {
        public void test() {
            System.out.println("Parent");
        }
    }

    class Son1 extends Parent {
    }

    class Son2 {
        private Parent parent;

        public Son2(Parent parent) {
            this.parent = parent;
        }

        public void test() {
            parent.test();
        }
    }

    /*
     * ①继承实现了类复用，破坏了封装
     * ②使用组合来实现复用，提供更好的封装
     * ③何时使用继承：子类有额外的属性/行为
     * */
    @Test
    public void test() {
        Parent son1 = new Son1();
        son1.test(); /* 继承自父类的方法 */

        Son2 son2 = new Son2(new Parent());
        son2.test(); /* 直接使用父类对象的方法 */
    }

}
