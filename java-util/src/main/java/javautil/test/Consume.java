package javautil.test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//@Testable /* 被JUnit5扩展识别 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Consume {

    String unit() default "s";

}
