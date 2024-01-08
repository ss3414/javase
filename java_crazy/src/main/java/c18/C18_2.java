package c18;

import org.junit.jupiter.api.Test;

import java.util.Map;

public class C18_2 {

    /*
     * ClassLoader应用
     * ①Tomcat
     * ②Java调用Groovy
     * */
    @Test
    public void test() {
        /*
         * 类加载器
         * ①为每一个被载入内存中的类生成一个java.lang.Class实例
         * ②JVM中的类，用其全限定名+类加载器作为唯一标识
         * */
//        Object object = new Object();
//        System.out.println(object); /* java.lang.Object@xxx（@xxx为类加载器） */
    }

    /* 类加载器层级：Extension ClassLoader>System ClassLoader>Bootstrap ClassLoader */
//    @Test
    public void test2() {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader); /* sun.misc.Launcher$AppClassLoader */

        ClassLoader extensionClassLoader = systemClassLoader.getParent();
        System.out.println(extensionClassLoader); /* sun.misc.Launcher$ExtClassLoader */
    }

    /************************************************************分割线************************************************************/

    public String str;

    public Map<String, Integer> map;

    public void test3(String name) {
        System.out.println("C18_2 test3:" + name);
    }

}
