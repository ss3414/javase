package com.pattern.c01;

import org.junit.jupiter.api.Test;

public class Factory {

    abstract class ParentProduct {
        public abstract void test();
    }

    abstract class ParentFactory {
        public abstract ParentProduct create();
    }

    class SonProduct extends ParentProduct {
        @Override
        public void test() {
            System.out.println("SonProduct");
        }
    }

    class SonFactory extends ParentFactory {
        @Override
        public ParentProduct create() {
            return new SonProduct();
        }
    }

    /* 工厂：将实例的生成交给子类 */
    @Test
    public void test() {
        ParentFactory factory = new SonFactory();
        ParentProduct product = factory.create();
        product.test();
    }

}
