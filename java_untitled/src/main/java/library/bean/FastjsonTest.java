package library.bean;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONValidator;
import lombok.Builder;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FastjsonTest {

    //    @Test
    public void test() {
        List<Parent> list = Arrays.asList(Parent.builder().id(1).name("name1").build(), Parent.builder().id(2).name("name2").build());
        String JSONStr = JSON.toJSONString(list);

        List<Parent> list2 = JSON.parseArray(JSONStr, Parent.class);
        System.out.println(list2);
    }

    //    @Test
    public void test2() {
        JSONObject jsonObject = JSONObject.parseObject(FileUtil.readString(new File("C:/Users/Administrator/Downloads/PycharmProjects/pyutil/untitled/test.json"), "UTF-8"));
        System.out.println(jsonObject);
    }

    @Test
    public void test3() {
        Map map = new LinkedHashMap();
        map.put("pwd_id", 1);
//        User user = User.builder().id(1).pwd(map).build();
        String jsonStr = "{\"name_id\": 1}";
        User user = User.builder().id(1).name(jsonStr).pwd(map).build();
        if (user.getName() != null && JSONValidator.from((String) user.getName()).validate()) {
            user.setName(JSON.parse((String) user.getName()));
        }
        System.out.println(JSON.toJSONString(user));
    }

}

@Data
@Builder
class User {

    private Integer id;
    private Object name;
    private Map pwd;

}
