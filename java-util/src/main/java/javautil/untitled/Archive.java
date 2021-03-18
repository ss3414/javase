package javautil.untitled;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Archive {

    /* JSON转Cookie */
    public static String JSON2Cookie(String input) {
        JSONArray jsonArray = JSONArray.parseArray(input);
        StringBuffer cookie = new StringBuffer();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            cookie.append(String.format("%s%s%s%s", jsonObject.getString("name"), "=", jsonObject.getString("value"), ";"));
        }
        return cookie.toString();
    }

    /* 获取年份 */
    public static List<String> getYears(Integer begin, Integer end) {
        List<String> years = new ArrayList<>();
        for (int i = begin; i <= end; i++) {
            years.add(String.valueOf(i));
        }
        return years;
    }

    public static List<String> getYears() {
        Integer BEGIN_YEAR = 1970;
        Integer END_YEAR = Integer.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy")));
        return getYears(BEGIN_YEAR, END_YEAR);
    }

}
