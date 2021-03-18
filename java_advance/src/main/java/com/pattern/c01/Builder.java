package com.pattern.c01;

import org.junit.jupiter.api.Test;

public class Builder {

    abstract class Parent {
        public abstract void test();
    }

    class Director {
        private Parent parent;

        public Director(Parent parent) {
            this.parent = parent;
        }

        public void direct() {
            parent.test(); /* 这里是个Parent型的变量 */
        }
    }

    class Son1 extends Parent {
        @Override
        public void test() {
            System.out.println("Son1");
        }
    }

    class Son2 extends Parent {
        @Override
        public void test() {
            System.out.println("Son2");
        }
    }

    /* 建造器：组装复杂的实例 */
    @Test
    public void test() {
        Parent son1 = new Son1();
        Son2 son2 = new Son2();

        /* 模板模式+依赖注入（Director依赖Parent） */
        new Director(son1).direct();
        new Director(son2).direct();
    }

}
