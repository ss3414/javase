package library.untitled;

import com.github.promeg.pinyinhelper.Pinyin;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

public class TinypinyinTest {

    @Test
    @SneakyThrows
    public void test() {
        String input = "《新华字典》";
        String output = "other";
        input = input.replaceAll("[^A-Za-z\\u4e00-\\u9fa5]", ""); /* 过滤除英文/中文外所有字符 */
        String temp = String.valueOf(Pinyin.toPinyin(input.charAt(0)).charAt(0)).toUpperCase();
        if (temp.matches("[A-Za-z]")) {
            output = temp;
        }
        System.out.println(output);
    }

}
