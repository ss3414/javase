package c18;

import c18.proxy.CGLibProxy;
import c18.proxy.Log;
import c18.proxy.LogImpl;
import c18.proxy.LogProxy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class C18_5 {

    /*
     * 静态代理
     * （装饰器模式，Python装饰器）
     * ①编写一个代理类，实现和目标对象相同的接口，并在内部维护一个目标对象的引用（构造器注入）
     * ②缺点：只能接受Log实现类的对象
     * */
//    @Test
    public void test() {
//        Log log = new LogImpl();
//        log.test();

        Log log2 = new LogProxy(new LogImpl());
        log2.test();
    }

    /*
     * ①通过Proxy.getProxyClass()获得加强版的class
     * */
//    @Test
    public void test2() {
        Class logProxyClass = Proxy.getProxyClass(Log.class.getClassLoader(), Log.class);
        System.out.println(logProxyClass.getName());
        System.out.println(LogProxy.class.getName());

        logProxyClass.getConstructors();
        logProxyClass.getMethods();
        System.out.println();
    }

    /*
     * ①InvocationHandler.invoke()是目标对象/代理对象之间的桥梁
     * */
//    @Test
    public void test3() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        LogImpl logImpl = new LogImpl();

        Class logProxyClass = Proxy.getProxyClass(Log.class.getClassLoader(), Log.class);
        Constructor constructor = logProxyClass.getConstructor(InvocationHandler.class);
        Log logProxy = (Log) constructor.newInstance((InvocationHandler) (proxy, method, args) -> {
            System.out.println("LogImpl执行前");
            Object object = method.invoke(logImpl, args); /* method.invoke()执行目标对象方法 */
            System.out.println("LogImpl执行后");
            return object;
        });
        logProxy.test();
    }

    /*
     * JDK动态代理
     * ①避免手写代理类，使用反射机制产生被代理接口的匿名实现类
     * ②缺点：目标对象必须实现接口
     * */
//    @Test
    public void test4() {
        LogImpl logImpl = new LogImpl();

        Log logProxy = (Log) Proxy.newProxyInstance(
                logImpl.getClass().getClassLoader(),
                logImpl.getClass().getInterfaces(), /* 让代理对象/目标对象实现相同的接口 */
                (proxy, method, args) -> {
                    System.out.println("LogImpl执行前");
                    Object object = method.invoke(logImpl, args);
                    System.out.println("LogImpl执行后");
                    return object;
                });
        logProxy.test();
    }

    /*
     * CGLib代理
     * ①解释执行字节码时通过继承要代理的类实现代理
     * ②缺点：被代理的类不能被final修饰
     * ③对比：大量调用时CGLib效率高，但JDK8中动态代理效率高于CGLib
     * ④Spring：Bean实现了接口使用动态代理（MyBatis Mapper），反之使用CGLib
     * */
    @Test
    public void test5() {
        LogImpl logImpl = (LogImpl) CGLibProxy.newProxyInstance(LogImpl.class);
        logImpl.test();
    }

}
