package c05;

import org.junit.jupiter.api.Test;

public class C05_1 {

    /*
     * ①定义类：省略/public+abstract/final
     * ②定义变量：private/省略/protected/public+static+final
     * ③定义方法：private/省略/protected/public+static+abstract/final
     * ④定义构造器：private/省略/protected/public
     * （构造器隐式返回该类的实例）
     * ⑤static：修饰变量（类变量）/方法（类方法），静态成员不能直接访问非静态成员
     * */

    @Test
    public void test() {
        /*
         * ①C05_1对象（堆内存），c05_1引用（栈内存）
         * ②Java中的引用就是C中的指针（NullPointerException，Java中唯一涉及指针的内容）
         * ③c05_1/c05_2是对同一个对象的引用（对象拷贝）
         * ④如果对象没有被任何变量引用，程序将无法再访问此对象，则此对象变为垃圾，被Java垃圾回收机制回收
         * （c05_1/c05_2赋值为null，C05_1对象将被回收）
         * */
        C05_1 c05_1 = new C05_1();
        C05_1 c05_2 = c05_1;

        c05_2.test3();
    }

    public void test2() {
        System.out.println("test2");
    }

    public void test3() {
        /*
         * ①没有使用static修饰的成员变量/方法都必须使用对象来调用
         * ②允许省略this
         * */
        this.test2(); /* 调用test3()的对象的test2方法 */
    }

    /*
     * 静态成员不能直接访问非静态成员
     * ①在static修饰的方法中使用this关键字，这个关键字就无法指向合适的对象，所以static修饰的方法不能使用this引用
     * ②同理static修饰的方法不能访问非static成员，因为非static成员需要对象（this）来调用
     * */

}
