package library.untitled;

import com.github.promeg.pinyinhelper.Pinyin;
import org.junit.jupiter.api.Test;

public class TinypinyinTest {

    @Test
    public void test() {
        String input = "《新华字典》";
//        String input = "123";
        String output = "other";
        try {
            input = input.replaceAll("[^A-Za-z\\u4e00-\\u9fa5]", ""); /* 过滤除英文/中文外所有字符 */
//            System.out.println(input);
            String temp = String.valueOf(Pinyin.toPinyin(input.charAt(0)).charAt(0)).toUpperCase();
            if (temp.matches("[A-Za-z]")) {
                output = temp;
            }
        } catch (Exception e) {
        }
        System.out.println(output);
    }

}
