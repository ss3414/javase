package library.bean;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class JacksonTest {

    @Test
    public void test() throws IOException {
        List<Parent> list = Arrays.asList(
                Parent.builder().id(1).name("name1").build(),
                Parent.builder().id(2).name("name2").build());
        ObjectMapper mapper = new ObjectMapper();
        String JSONStr = mapper.writeValueAsString(list);

        JsonNode jsonNode = mapper.readTree(JSONStr);
        Iterator<JsonNode> elements = jsonNode.elements();
        while (elements.hasNext()) {
            JsonNode element = elements.next();
            System.out.println(element.get("name").asText());
        }
    }

    //    @Test
    public void test2() throws IOException {
        /* VO继承自实体类，根据Jackson注解决定序列化 */
        ParentVO parentVO = new ParentVO(1, "name", "pwd");
        ObjectMapper mapper = new ObjectMapper();
        String JSONStr = mapper.writeValueAsString(parentVO);

        /* 反序列化使用实体类 */
        Parent parent = mapper.readValue(JSONStr, Parent.class);
        System.out.println(parent);
    }

}
