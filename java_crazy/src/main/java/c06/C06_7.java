package c06;

import org.junit.jupiter.api.Test;

public class C06_7 {

    private String str1;

    /*
     * 内部类
     * ①Test1写在C06_7内，Test1是C06_7的内部类
     * （写在C06_7外则是一个java文件包含多个类）
     * ②编译（javac -encoding UTF-8 -d . C06_7.java）后生成C06_7.class和C06_7$Test1.class（内部类）
     * ③成员内部类/局部内部类（写在方法内）/匿名内部类/静态内部类
     * ④内部类可以用private/protected/static修饰
     * */
    private class Test1 {

        private String str2;

        public void test() {
            C06_7.this.str1 = "str1"; /* 内部类可直接访问外部类的private成员，反之则不可以 */
            this.str2 = "str2";
        }

    }

    /*
     * 静态内部类
     * ①用static修饰内部类，这个内部类就属于外部类本身，而不属于外部类的某个对象
     *
     * 内部类的使用
     * ①在外部类内部使用内部类（正常使用）
     * ②在外部类以外使用非静态内部类（不要使用private修饰内部类）
     * ③在外部类以外使用静态内部类（推荐）
     * */
    static class Test2 {
    }

    /************************************************************分割线************************************************************/

    interface Log {

        void print();

    }

    public void printImpl(Log log) {
        log.print();
    }

    /*
     * 匿名内部类
     * ①匿名内部类必须继承一个父类/实现一个接口
     * ②匿名内部类不能是抽象类，也不能定义构造器（因为没有类名）
     * */
    @Test
    public void test() {
        /*
         * ①C06_7有个方法printImpl()，传入的参数是Log的实现类
         * ②Log是个接口，没有默认实现，在调用C06_7.printImpl()时手动实现（一次性的）
         * */
        C06_7 c06_7 = new C06_7();
        c06_7.printImpl(new Log() {
            @Override
            public void print() {
                System.out.println("printImpl");
            }
        });
    }

}
