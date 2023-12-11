package library.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/*
 * JUnit5扩展
 * ①@ExtendWith+AnnotationExtension即可扩展，不一定需要自定义注解
 * */
@ExtendWith(AnnotationExtension.class)
public class JUnit5Demo {

    @BeforeAll
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

}
