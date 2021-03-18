package c14;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 * ①注解本质上是个接口，且继承Annotation类
 * ②RetentionPolicy.SOURCE/CLASS/RUNTIME
 * */
@Retention(RetentionPolicy.RUNTIME)
public @interface Consume {

    String str() default "str";

}
