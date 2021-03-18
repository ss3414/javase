package c17;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;

public class C17_2 {

    //    @Test
    public void test() throws UnknownHostException {
        InetAddress address1 = InetAddress.getLocalHost();
        InetAddress address2 = InetAddress.getByName("www.bing.com");
        System.out.println(address1.getHostName());
        System.out.println(address2.getHostAddress());
    }

    @Test
    public void test2() throws UnsupportedEncodingException {
        String str1 = "中文";
        String str2 = "English";
        System.out.println(URLEncoder.encode(str1, "UTF-8"));
        System.out.println(URLEncoder.encode(str2, "UTF-8"));
        System.out.println(URLDecoder.decode(URLEncoder.encode(str1, "UTF-8"), "UTF-8"));
    }

}
