package c15;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;

public class C15_1 {

    /*
     * 相对路径
     * ①以本项目编译后生成的classes目录为例（java_crazy\target\classes）
     * ②java下的java代码和resources下的xml/properties同时被编译到classes目录下
     * */
//    @Test
    public void test() {
        System.out.println(File.separator);

        /* 以编译路径为参照点 */
        System.out.println(C15_1.class.getResource("/application.properties").getFile()); /* 必须加/ */

        /* SpringBoot fat jar问题 */
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("application.properties")); /* 不能加/ */

        /* 以项目路径为参照点 */
        File file = new File("src/main/resources/application.properties");
        System.out.println(file.getAbsoluteFile());
    }

    /* 重命名文件 */
    @Test
    public void test2() {
        File file = new File("C:/Users/Administrator/Desktop/test.jpg");
        String fileName = file.getName();
        /* substring从输入字符开始截断 */
        int i = fileName.lastIndexOf(".");
        String origin = fileName.substring(0, i); /* 不带后缀的文件名 */
        String suffix = fileName.substring(i); /* 后缀 */
        file.renameTo(new File("C:/Users/Administrator/Desktop/test2" + suffix));
    }

    /* 文件过滤 */
//    @Test
    public void test3() {
        File dir = new File("C:/Users/Administrator/IdeaProjects(2)/javase/java_crazy/src/main/java/c01");
        String[] names = dir.list(((dir2, name) -> name.endsWith(".java"))); /* 实现FilenameFilter接口 */
        System.out.println(Arrays.toString(names));
    }

}
