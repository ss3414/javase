package library.bean;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

public class LombokDemo {

    //    @Test
    public void test() {
//        Parent parent = Parent.builder().id(1).name("name").password("pwd").build(); /* @Builder（Guava写法） */
//        System.out.println(parent);

//        Parent son = Son.builder().id(1).name("name").password("pwd").build();
//        son.test(); /* Son.builder()生成的类型为Parent，此处的son.test()无法显现多态 */
//        System.out.println(son);
    }

    @Test
    @SneakyThrows /* 省略try catch */
    public void test2() {
        throw new Exception("test");
    }

}
