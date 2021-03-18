package library.bean;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class GsonTest {

    @Test
    public void test() {
        Gson gson = new Gson();
        Map map = new LinkedHashMap();
        map.put("BigDecimal", new BigDecimal(0.123456789));
        String JSONStr = gson.toJson(map);

        Map map2 = gson.fromJson(JSONStr, Map.class);
        System.out.println(map2);
    }

}
