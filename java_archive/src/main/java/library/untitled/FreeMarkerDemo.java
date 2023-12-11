package library.untitled;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkerDemo {

    @Test
    @SneakyThrows
    public void test() {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources"));
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        Template template = configuration.getTemplate("template.ftl");
        Map<String, Object> model = new HashMap<>();
        model.put("user", "name1");

        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("C:/Users/Administrator/Desktop/test.txt"));
        template.process(model, out);
        out.flush();
        out.close();

        StringWriter stringWriter = new StringWriter();
        template.process(model, stringWriter);
        stringWriter.flush();
        System.out.println(stringWriter);
    }

}
