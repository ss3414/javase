package library.request;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import javautil.common.Constant;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.CharsetUtils;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpClientTest {

    //    @Test
    public void test() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://httpbin.org/post");
        post.setHeader("User-Agent", Constant.USER_AGENT);
        List<NameValuePair> paramList = new ArrayList<>();
        paramList.add(new BasicNameValuePair("id", "1"));
        post.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
        HttpResponse response = client.execute(post);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    /* 文件上传 */
//    @Test
    public void test2() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        String uri = "http://127.0.0.1/singleUpload";
        HttpPost post = new HttpPost(uri);

        File file = new File("D:/同步/文档/Idea/idea使用教程2017-06-01.pdf");
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE); /* 浏览器兼容模式 */
        builder.setCharset(CharsetUtils.get("UTF-8")); /* 解决中文文件名乱码 */

        /* 发送文件 */
//        FileBody fileBody = new FileBody(file);
//        builder.addPart("uploadFile", fileBody); /* 相当于<input type="file" name="uploadFile"/> */
//        builder.addTextBody("name", "name123");

        /* 发送文件流 */
        FileInputStream fileInputStream = new FileInputStream(file);
        int size = Math.toIntExact(file.length());
        byte[] bytes = new byte[size];
        fileInputStream.read(bytes);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        builder.addBinaryBody("uploadFile", byteArrayInputStream, ContentType.MULTIPART_FORM_DATA, "test.pdf");

        HttpEntity requestEntity = builder.build();
        post.setEntity(requestEntity);
        HttpResponse response = client.execute(post);
        System.out.println("response:" + response.toString());
        System.out.println("status:" + response.getStatusLine());
        System.out.println("responseEntity:" + EntityUtils.toString(response.getEntity()));
    }

    /* 文件下载 */
    @Test
    public void test3() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        String uri = "http://127.0.0.1/download";
        HttpGet get = new HttpGet(uri);
        HttpResponse response = client.execute(get);
        HeaderElement[] elements = response.getFirstHeader("Content-Disposition").getElements();
        String filename = URLDecoder.decode(elements[0].getParameterByName("filename").getValue(), "UTF-8");

        /* InputStream转字节数组 */
        HttpEntity entity = response.getEntity();
        InputStream inputStream = entity.getContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Integer length = 0;
        byte[] buffer = new byte[1024];
        while ((length = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, length);
        }
        byte[] bytes = byteArrayOutputStream.toByteArray();
    }

    /* 发送JSON（application/json） */
//    @Test
    public void test4() throws IOException {
//        HttpHost proxy = new HttpHost("127.0.0.1", 8888); /* 代理 */
//        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
//        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(config).build();
        Map map = new LinkedHashMap();
        map.put("status", 1000);
        StringEntity requestEntity = new StringEntity(JSONObject.toJSONString(map), "UTF-8");
        requestEntity.setContentType("application/json");

        HttpPost post = new HttpPost("http://127.0.0.1/requestJSON");
        post.setHeader("Content-Type", "application/json;charset=UTF-8");
        post.setEntity(requestEntity);

        CloseableHttpClient client = HttpClients.custom().build();
        HttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        JSONObject jsonObject = JSONObject.parseObject(EntityUtils.toString(entity));
        System.out.println(jsonObject);
    }

    /*
     * 模拟登录ssm_cookie_session
     * ①相当于在浏览器中第一次登录
     * ②登录成功返回302重定向，JSESSIONID与userId两个Cookie
     * */
//    @Test
    public void test5() throws IOException {
        CookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        String baseURI = "http://127.0.0.1";
        HttpPost post = new HttpPost(baseURI + "/login/doLogin");

        /* 登录表单 */
        List<NameValuePair> paramList = new ArrayList<>();
        paramList.add(new BasicNameValuePair("userName", "name1"));
        paramList.add(new BasicNameValuePair("userPassword", "pwd1"));
        HttpEntity requestEntity = new UrlEncodedFormEntity(paramList, "UTF-8");
        post.setEntity(requestEntity); /* 只有request时能设置请求实体 */

        /* 登录请求，获取重定向地址和登录Cookie */
        HttpResponse response = client.execute(post);

        /* 重定向 */
        if (response.getStatusLine().toString().contains("302")) {
            String redirectURI = response.getFirstHeader("Location").getValue();
            /* 上一次response返回的cookieStore可以作为下一次request的请求Cookie */
            client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
            post = new HttpPost(baseURI + redirectURI);
            response = client.execute(post);
            System.out.println("response:" + response.toString());
            System.out.println("status:" + response.getStatusLine());
            System.out.println("responseEntity:" + EntityUtils.toString(response.getEntity())); /* 主体 */
        }
    }

    /* 带Cookie访问（设置Header/Cookie） */
//    @Test
    public void test6() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://bbs.wuyou.net/forum.php?mod=guide&view=my");
        get.setHeader("User-Agent", Constant.USER_AGENT);
        JSONArray jsonArray = JSONArray.parseArray("");
        StringBuffer cookie = new StringBuffer();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            cookie.append(jsonObject.getString("name"));
            cookie.append("=");
            cookie.append(jsonObject.getString("value"));
            cookie.append(";");
        }
        get.setHeader("Cookie", cookie.toString());
        HttpResponse response = client.execute(get);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    /* 多线程测速 */
//    @Test
    public void test7() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Callable<String>> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Callable callable = () -> {
                CloseableHttpClient client = HttpClients.createDefault();
                HttpGet get = new HttpGet("http://127.0.0.1/speed");
                client.execute(get);
                return Thread.currentThread().getName();
            };
            list.add(callable);
        }
        executor.invokeAll(list).stream()
                .map(future -> {
                    try {
                        return future.get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                }).forEach(System.out::println);
    }

    /* 设置系统代理（所有Java程序发出的请求都走代理，不需要单独设置） */
//    @Test
    public void test8() {
        System.setProperty("http.proxyHost", "127.0.0.1");
        System.setProperty("http.proxyPort", "8888");
        System.setProperty("https.proxyHost", "127.0.0.1");
        System.setProperty("https.proxyPort", "8888");
    }

}
