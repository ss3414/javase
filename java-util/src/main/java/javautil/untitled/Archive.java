package javautil.untitled;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Archive {

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
