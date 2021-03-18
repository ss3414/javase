package c05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class C05_7 {

    /*
     * 多态
     * ①Java引用变量，编译时类型（声明时决定），运行时类型（赋值时决定），编译时运行时类型不同，即为多态
     * ②子类对象赋值给父类引用变量，称为向上转型
     * */
    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        list2.trimToSize(); /* trimToSize去重，trimToSize是ArrayList独有的方法，虽然list运行时是ArrayList型，但是list无法调用trimToSize */

        /*
         * 强制类型转换
         * ①基本类型只能在整型/浮点型/字符型间进行
         * ②引用类型只能在具有继承关系的两个类型间进行
         * */
        Object object = "str";
        if (object instanceof String) {
            String str = (String) object;
        }
    }

}
