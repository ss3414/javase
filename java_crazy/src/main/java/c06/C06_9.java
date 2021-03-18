package c06;

import org.junit.jupiter.api.Test;

public class C06_9 {

    class Github {

        /*
         * 通过静态常量表示枚举
         * ①缺点：没有命名空间
         * */
        public static final String Java = "Java";
        public static final String Python = "Python";

    }

    /*
     * 枚举类
     * ①可以实现接口，默认继承Enum类而非Object类，不能显式的继承其他父类
     * ②默认使用final修饰，不能派生子类
     * ③构造器只能使用private修饰
     * */
    public enum Github2 {
        Java, Python
    }

    @Test
    public void test() {
        System.out.println(Github.Java);
        System.out.println(Github2.Python);
    }

}
