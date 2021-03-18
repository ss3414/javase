package javautil.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Constant {

    public static final long ONE_DAY = 24 * 60 * 60 * 1000;

    public static final String SYSTEM = System.getProperty("os.name");

    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36";

    public static String getDate() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    /* 获取桌面的地址 */
    public static String getDesktop() {
        String dir = "";
        if ("Windows".equals(Constant.SYSTEM)) {
            dir = "C:/Users/Administrator/Desktop/";
        } else if ("Linux".equals(Constant.SYSTEM)) {
            dir = "/home/fantasy/Desktop/";
        }
        return dir;
    }

    public static String getTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
