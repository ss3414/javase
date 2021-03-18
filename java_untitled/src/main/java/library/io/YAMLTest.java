package library.io;

import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class YAMLTest {

    @Test
    public void test() throws IOException {
        Map map = new LinkedHashMap();
        map.put("id", 1);
        map.put("name", "name");
        map.put("pwd", "pwd");
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        Yaml yaml = new Yaml(options);
        yaml.dump(map, new FileWriter(new File("/home/fantasy/Desktop/test.yaml")));

        String text = yaml.dump(map);
        System.out.println(text);
    }

}
