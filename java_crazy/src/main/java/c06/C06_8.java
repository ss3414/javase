package c06;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class C06_8 {

    interface Log {

        void print();

    }

    public void printImpl(Log log) {
        log.print();
    }

    /*
     * Lambda表达式
     * ①Java8后，用Lambda表达式取代匿名内部类
     * ②组成部分：形参列表+箭头（->）+代码块
     * */
//    @Test
    public void test() {
        C06_8 c06_8 = new C06_8();
        c06_8.printImpl(() -> System.out.println("printImpl"));
    }

    @FunctionalInterface /* 检查是否为函数式接口 */
    interface Function1<T> {

        void apply(String input);

    }

    /*
     * 函数式接口
     * ①Lambda表达式的目标类型必须是函数式接口（只能包含一个抽象方法的接口）
     * ②因为Lambda表达式的结果被当成对象，所以可以使用Lambda表达式赋值
     * */
    @Test
    public void test2() {
        Function<Integer, Integer> test = i -> i + 1; /* Function接口+泛型+输入输出 */
        System.out.println(test.apply(1));

        Function1 function1 = System.out::println; /* 自定义函数式接口，有输入没输出 */
        function1.apply("1");
    }

    /************************************************************分割线************************************************************/

    @FunctionalInterface /* 检查是否为函数式接口 */
    interface Log2 {

        Integer test(String input);

    }

    @FunctionalInterface
    interface Log3 {

        String test(String input, String regex, String replace);

    }

    @FunctionalInterface
    interface Log4 {

        String test(String input);

    }

    /*
     * 方法引用与构造器引用
     * ①当Lambda表达式的代码块只有一条代码，可以使用方法引用/构造器引用
     * */
//    @Test
    public void test3() {
        /* 引用类方法 */
        Log2 log2 = (input) -> {
            return Integer.valueOf(input);
        };
        log2 = Integer::valueOf;
//        System.out.println(log2.test("123"));

        /* 引用特定对象的实例方法 */

        /* 引用对象的实例方法 */
        Log3 log3 = (input, regex, replace) -> {
            return input.replaceAll(regex, replace);
        };
        log3 = String::replaceAll;
//        System.out.println(log3.test("123abc", "\\d", ""));

        /* 引用构造器 */
        Log4 log4 = (input) -> {
            return new String(input);
        };
        log4 = String::new;
        System.out.println(log4.test("123"));
    }

    /*
     * Lambda表达式/匿名内部类
     * ①匿名内部类可以为任意接口创建实例，不管接口包含多少个抽象方法，Lambda表达式只能为函数式接口创建实例
     * ②匿名内部类可以为抽象类/普通类创建实例
     * */

}
