package library.bean;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FastjsonTest {

    //    @Test
    public void test() {
        List<Parent> list = Arrays.asList(
                Parent.builder().id(1).name("name1").build(),
                Parent.builder().id(2).name("name2").build());
        String JSONStr = JSON.toJSONString(list);

        List<Parent> list2 = JSON.parseArray(JSONStr, Parent.class);
        System.out.println(list2);
    }

    @Test
    public void test2() {
        JSONObject jsonObject = JSONObject.parseObject(FileUtil.readString(new File("/home/fantasy/Downloads/PycharmProjects/pyutil/untitled/test.json"), "UTF-8"));
        System.out.println(jsonObject);
    }

}
