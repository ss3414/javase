package c14;

public class C14_2 {

    /*
     * @Retention
     * ①RetentionPolicy.CLASS：默认值，编译器将注解记录在class文件中，运行时JVM无法获取注解信息
     * ②RetentionPolicy.RUNTIME：记录在class文件中，可以获取注解信息，程序可以通过反射获取注解信息
     * ③RetentionPolicy.SOURCE：注解只保留在源码中，编译器直接抛弃
     *
     * @Target：被修饰的注解只能修饰注解/构造器/成员变量/局部变量/方法定义/包定义/参数/类+接口+枚举定义
     *
     * @Documented：被修饰的注解将被javadoc提取成文档
     *
     * @Inherited：被被修饰的注解修饰的类具有继承性，子类将自动被注解修饰
     *
     * @Repeatable：重复注解
     * */

}
