package library.datasource;

import io.minio.*;
import javautil.common.Constant;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import org.junit.jupiter.api.Test;

import java.io.*;

public class MinioTest {

    private static MinioClient minioClient = MinioClient.builder().endpoint("http://127.0.0.1:9000").credentials("01234567890123456789", "0123456789012345678901234567890123456789").build();

    private static String bucketName = Constant.getDate();

    /* 上传 */
    @Test
    public void test() {
        try {
            /* 创建存储桶 */
            Boolean exist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!exist) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            }
            FileInputStream fileInputStream = new FileInputStream(new File("/home/fantasy/Desktop/test.zip"));
            minioClient.putObject(PutObjectArgs.builder().bucket(bucketName).object("test.zip").stream(fileInputStream, fileInputStream.available(), -1).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* 下载 */
//    @Test
    public void test2() {
        try {
            InputStream inputStream = minioClient.getObject(GetObjectArgs.builder().bucket(bucketName).object("test.zip").build());
            try (BufferedSource bufferedSource = Okio.buffer(Okio.source(inputStream))) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try (Sink sink = Okio.sink(byteArrayOutputStream)) {
                    if (inputStream.available() == 0) {
                        bufferedSource.readAll(sink);
                    }
                }
                OutputStream outputStream = new FileOutputStream(new File("/home/fantasy/Desktop/test2.zip"));
                outputStream.write(byteArrayOutputStream.toByteArray());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* 删除 */
//    @Test
    public void test3() {
        try {
            minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object("test.zip").build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
