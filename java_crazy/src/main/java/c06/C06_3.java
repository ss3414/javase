package c06;

public class C06_3 {

    public static void main(String[] args) {
        /*
         * 两种方式
         * ①新建对象调用方法
         * ②调用类静态方法（不需要实例化，所以main方法使用static修饰）
         * */
        new C06_3().test();
        C06_3.test2();
    }

    public void test() {
        System.out.println("Hello World");
    }

    public static void test2() {
        System.out.println("Hello World");
    }

}
