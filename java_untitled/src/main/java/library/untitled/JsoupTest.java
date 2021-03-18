package library.untitled;

import cn.hutool.core.io.FileUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.io.File;

public class JsoupTest {

    @Test
    public void test() {
        StringBuilder stringBuilder = new StringBuilder()
                .append("<h2>标题1</h2>")
                .append("<div>内容1</div>")
                .append("<h2>标题2</h2>")
                .append("<div>内容2</div>")
                .append("<h2>标题3</h2>")
                .append("<div>内容3</div>");
        String html = stringBuilder.toString();
        Document document = Jsoup.parse(html);
        Elements elements = document.select("h2");
        for (Element element : elements) {
            System.out.println(element.text());
        }

        String[] contents = html.split("<h2>[\\s\\S]*?</h2>");
        for (String content : contents) {
            System.out.println(content);
        }

        /* 抽取所有标签内的内容（白名单机制） */
        System.out.println(Jsoup.clean(html, Whitelist.none()));
    }

}
