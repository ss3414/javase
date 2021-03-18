package com.pattern.c03;

import org.junit.jupiter.api.Test;

public class Template {

    /* 父类为什么是抽象类：不会有父类的实例 */
    abstract class Parent {
        public abstract void test(); /* 抽象方法：只有方法名没有方法体 */

        public final void print() { /* final：禁止子类重写 */
            System.out.println("Parent");
        }
    }

    class Son extends Parent {
        @Override
        public void test() {
            System.out.println("Son");
        }
    }

    /* 模板：将具体处理交给子类 */
    @Test
    public void test() {
        Parent son = new Son();
        son.test();
        son.print();
    }

}
