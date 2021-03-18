package library.request;

import javautil.common.Constant;
import okhttp3.*;
import org.junit.jupiter.api.Test;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

public class OkhttpTest {

    /* get */
    @Test
    public void test() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://httpbin.org/get?name=name123")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

    /* post */
//    @Test
    public void test2() throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .proxy(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("127.0.0.1", 1080))) /* 代理 */
                .build();
        Request request = new Request.Builder()
                .url("http://httpbin.org/post")
                .post(new FormBody.Builder().add("name", "name123").build())
                .addHeader("User-Agent", Constant.USER_AGENT) /* UA */
                .addHeader("Cookie", "123") /* Cookie */
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

    /* json */
//    @Test
    public void test3() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .addInterceptor(chain -> {
                    /* fixme 重试次数 */
                    Response response = chain.proceed(chain.request());
                    Integer count = 0;
                    while (!response.isSuccessful() && count < 2) {
                        response = chain.proceed(chain.request());
                        count++;
                        System.out.println(count);
                    }
                    return response;
                })
                .build();
        RequestBody requestBody = RequestBody.Companion
                .create("{\"name\": \"name123\"}", MediaType.Companion.parse("application/json;charset=UTF-8"));
        Request request = new Request.Builder()
                .url("http://httpbin.org/post")
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

    /* 文件下载 */
//    @Test
    public void test4() throws IOException {
        OkHttpClient client = new OkHttpClient.Builder().callTimeout(30, TimeUnit.SECONDS).build();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http").host("127.0.0.1").port(8080)
                .addPathSegment("download3")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        InputStream inputStream = response.body().byteStream();
        String content = response.header("Content");
        System.out.println(content);
    }

    private static class CustomTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private static class CustomVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String s, SSLSession sslSession) {
            return true;
        }
    }

    /* https（信任所有证书） */
//    @Test
    public void test5() throws IOException, NoSuchAlgorithmException, KeyManagementException {
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, new TrustManager[]{new CustomTrustManager()}, new SecureRandom());
        SSLSocketFactory factory = context.getSocketFactory();
        OkHttpClient client = new OkHttpClient.Builder()
                .sslSocketFactory(factory, new CustomTrustManager())
                .hostnameVerifier(new CustomVerifier())
                .build();
        Request request = new Request.Builder()
                .url("https://127.0.0.1:8080")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

}
