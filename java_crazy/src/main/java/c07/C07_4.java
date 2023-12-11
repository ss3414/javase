package c07;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

public class C07_4 {

    /*
     * ①原有的Date/Calendar是线程不安全的
     * ②Java8的时间日期API参考了joda-time
     * */

    /* LocalDate */
//    @Test
    public void test() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getDayOfMonth());
    }

    /* LocalTime */
//    @Test
    public void test2() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
    }

    /* LocalDateTime */
//    @Test
    public void test3() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }

    /* DateTimeFormatter */
//    @Test
    public void test4() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
    }

    /* Clock */
//    @Test
    public void test5() {
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.millis());
        System.out.println(java.sql.Date.from(clock.instant())); /* 新旧转换 */
    }

    /* Instant（瞬间） */
//    @Test
    public void test6() {
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(now.getEpochSecond());
        System.out.println(now.plusSeconds(3));
        System.out.println(now.minusSeconds(3));
    }

    /* Duration（时间间隔） */
//    @Test
    public void test7() throws InterruptedException {
        Instant instant = Instant.now();
        Thread.sleep(3 * 1000);
        Instant instant2 = Instant.now();
        Duration duration = Duration.between(instant, instant2);
        System.out.println(duration.getSeconds());
        System.out.println(duration.toMillis()); /* 毫秒 */
    }

    /* ZoneId（时区） */
//    @Test
    public void test8() {
        ZoneId zoneId = ZoneId.systemDefault();
        ZoneId zoneId2 = ZoneId.of("Asia/Shanghai");
        ZoneId zoneId3 = TimeZone.getDefault().toZoneId(); /* 新旧转换 */
        System.out.println(zoneId);
        System.out.println(zoneId2);
        System.out.println(zoneId3);
        System.out.println(ZoneId.getAvailableZoneIds());
    }

    /* ZonedDateTime */
//    @Test
    public void test9() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.of("Europe/Paris");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
        System.out.println(zonedDateTime);
    }

    /************************************************************分割线************************************************************/

    /* JDK6时间API */
//    @Test
    public void test10() {
        Calendar calendar = Calendar.getInstance();
        System.out.println("年：" + calendar.get(Calendar.YEAR));
        System.out.println("月：" + (calendar.get(Calendar.MONTH) + 1));
        System.out.println("日：" + calendar.get(Calendar.DAY_OF_MONTH)); /* 当月的第几日 */
        System.out.println("时：" + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("分：" + calendar.get(Calendar.MINUTE));
        System.out.println("秒：" + calendar.get(Calendar.SECOND));
        System.out.println("当前时间毫秒数：" + System.currentTimeMillis());

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); /* varchar型时间 */
        System.out.println("Date格式化前：" + date);
        System.out.println("Date格式化后：" + format.format(date));
    }

    /* 时间戳 */
//    @Test
    public void test11() throws ParseException {
//        System.out.println(System.currentTimeMillis()); /* 13位时间戳 */
//        System.out.println(System.currentTimeMillis() / 1000); /* 10位时间戳 */

//        /* 时间戳转时间 */
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(format.format(new Date((long) System.currentTimeMillis())));

        /* 时间转时间戳 */
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        long time = format.parse("2020-01-01").getTime();
        System.out.println(time);
    }

    /* 最近12个月 */
//    @Test
    public void test12() {
        LocalDate today = LocalDate.now();
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("month", today.minusMonths(i).format(DateTimeFormatter.ofPattern("yyyyMM")));
            map.put("begin", today.minusMonths(i).format(DateTimeFormatter.ofPattern("yyyyMM")) + "01000000");
            map.put("end", today.minusMonths(i + 1).format(DateTimeFormatter.ofPattern("yyyyMM")) + "01000000");
            mapList.add(map);
        }
//        System.out.println(mapList);

        List list = mapList.stream().map(e -> e.get("month")).sorted().collect(Collectors.toList()); /* 抽取 */
        System.out.println(list);
    }

    /* 补齐时间 */
    @Test
    public void test13() {
        String date = "2020-01-01";
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        date = localDate.atStartOfDay().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(date);
    }

}
