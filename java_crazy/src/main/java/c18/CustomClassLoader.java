package c18;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomClassLoader extends ClassLoader {

    /*重写ClassLoader的findClass()  */
    @Override
    protected Class<?> findClass(String name) {
        String name2 = name.replace(".", "/");
        String javaFile = name2 + ".java";
        compile(javaFile); /* 编译 */
        String classFile = name2 + ".class";
        byte[] bytes = getBytes(classFile);
        /* 调用ClassLoader的defineClass将.class文件转换为Class对象 */
        Class<?> clazz = defineClass(name, bytes, 0, bytes.length);
        return clazz;
    }

    /* 编译 */
    private void compile(String javaFile) {
        try {
            System.out.println("编译：" + javaFile);
            Process process = Runtime.getRuntime().exec("javac " + javaFile);
            process.waitFor(); /* 其他线程等待这个线程完成 */
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* 读取.class文件的二进制数据 */
    private byte[] getBytes(String classFile) {
        File file = new File(classFile);
        byte[] bytes = new byte[Math.toIntExact(file.length())];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytes); /* 读取二进制数据到byte数组 */
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    /************************************************************分割线************************************************************/

    /*
     * 自定义ClassLoader（模拟java/JVM加载.class文件）
     * ①编译CustomClassLoader：javac -encoding UTF-8 -d . CustomClassLoader.java
     * ②编写一个不含包名的Hello World，运行：java c18.CustomClassLoader Hello
     * （java c18.CustomClassLoader相当于平常的java，只不过使用自定义ClassLoader）
     * （直接在IntelliJ中运行会使用默认的ClassLoader而非自定义ClassLoader）
     *
     * 程序=代码+运行时
     * 反射：元编程的一种
     * */
    public static void main(String[] args) {
        try {
            String className = args[0]; /* 目标类 */
            CustomClassLoader customClassLoader = new CustomClassLoader();
            Class<?> clazz = customClassLoader.loadClass(className); /* 调用重写的findClass */
            Method main = clazz.getMethod("main", String[].class); /* 目标类的main方法 */

            String[] args2 = new String[args.length - 1];
            System.arraycopy(args, 1, args2, 0, args2.length); /* 目标类的参数 */
            main.invoke(null, (Object) args2);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
