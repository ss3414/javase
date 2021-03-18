package library.document;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.SimpleBookmark;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ITextTest {

    /* 获取PDF内容 */
//    @Test
    public void test() throws IOException {
        PdfReader reader = new PdfReader("D:/新建文件夹（同步）/文档/Idea/idea使用教程2017-06-01.pdf");
        for (int i = 0; i < reader.getNumberOfPages(); i++) {
            System.out.println(PdfTextExtractor.getTextFromPage(reader, i + 1));
        }
    }

    private List<HashMap<String, Object>> outputList = new ArrayList<>();

    /* 获取PDF目录（bookmark） */
    @Test
    public void test2() throws IOException {
        PdfReader reader = new PdfReader("D:/新建文件夹（同步）/文档/Idea/idea使用教程2017-06-01.pdf");
        List<HashMap<String, Object>> bookmarkList = SimpleBookmark.getBookmark(reader);
        recursive(bookmarkList, 1, "");
        for (HashMap<String, Object> out : outputList) {
            System.out.println(out);
        }
    }

    /*
     * 递归获取父子级目录
     * ①level：标题等级（1级大，2级小）
     * ②father：直系父节点
     * */
    public void recursive(List<HashMap<String, Object>> inputList, Integer level, String father) {
        Pattern pattern = Pattern.compile("^(\\d*)\\s");
        Matcher matcher = null;
        for (HashMap<String, Object> input : inputList) {
            HashMap<String, Object> out = new LinkedHashMap<>();
            out.put("level", level);
            out.put("father", father);
            out.put("title", input.get("Title"));
            String page = (String) input.get("Page");
            if (page == null) { /* 有标题没页码 */
                continue;
            }
            matcher = pattern.matcher(page);
            while (matcher.find()) {
                out.put("page", matcher.group(1));
            }
            outputList.add(out);
            if (input.get("Kids") != null) {
                List<HashMap<String, Object>> sonList = (List<HashMap<String, Object>>) input.get("Kids");
                recursive(sonList, level + 1, (String) input.get("Title"));
            }
        }
    }

}
