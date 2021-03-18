package c07;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C07_5 {

    /* find()/lookingAt()/matches() */
//    @Test
    public void test() {
        String content = "www.runoob.com/java/java-regular-expressions.html";
        Pattern pattern = Pattern.compile("www(.*)com");
        Matcher matcher = pattern.matcher(content);
        /* matcher.find()查找子串 */
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        /* 部分匹配（content是否存在以www开头com结尾的子串） */
        System.out.println(matcher.lookingAt());
        /* 完全匹配（content必须完全匹配正则） */
        System.out.println(matcher.matches());
    }

    /* group() */
//    @Test
    public void test2() {
        String content = "www.runoob.com/java/java-regular-expressions.html";
        Pattern pattern = Pattern.compile("www(.*)com(.*)html");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.group(0)); /* 最终匹配结果 */
            System.out.println(matcher.group(1)); /* 第一个()匹配结果 */
            System.out.println(matcher.group(2)); /* 第二个()匹配结果 */
        }
    }

    /* 多行替换 */
//    @Test
    public void test3() {
        Pattern pattern = Pattern.compile("^\\s*", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(" 123\n" + " 456");
        System.out.println(matcher.replaceAll(""));
    }

    /* String内建正则 */
    @Test
    public void test4() {
        /* 多个分隔符用|作为连字符 */
        String content = "www.runoob.com/java/java-regular-expressions.html";
        String[] splitArray = content.split("runoob(.*?)java");

        System.out.println(content.matches(".*[A-Za-z].*")); /* 字符串是否包含英文 */
    }

}
