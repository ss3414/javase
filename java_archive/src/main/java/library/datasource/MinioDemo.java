package library.datasource;

import io.minio.*;
import javautil.common.Constant;
import lombok.SneakyThrows;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import org.junit.jupiter.api.Test;

import java.io.*;

public class MinioDemo {

    private static MinioClient minioClient = MinioClient.builder().endpoint("http://127.0.0.1:9000").credentials("01234567890123456789", "0123456789012345678901234567890123456789").build();

    private static String bucketName = Constant.getDate();

    /* 上传 */
    @Test
    @SneakyThrows
    public void test() {
        /* 创建存储桶 */
        boolean exist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if (!exist) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
        FileInputStream fileInputStream = new FileInputStream(new File("C:/Users/Administrator/Desktop/test.zip"));
        minioClient.putObject(PutObjectArgs.builder().bucket(bucketName).object("test.zip").stream(fileInputStream, fileInputStream.available(), -1).build());
    }

    /* 下载 */
//    @Test
    @SneakyThrows
    public void test2() {
        InputStream inputStream = minioClient.getObject(GetObjectArgs.builder().bucket(bucketName).object("test.zip").build());
        try (BufferedSource bufferedSource = Okio.buffer(Okio.source(inputStream))) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try (Sink sink = Okio.sink(byteArrayOutputStream)) {
                if (inputStream.available() == 0) {
                    bufferedSource.readAll(sink);
                }
            }
            OutputStream outputStream = new FileOutputStream(new File("C:/Users/Administrator/Desktop/test2.zip"));
            outputStream.write(byteArrayOutputStream.toByteArray());
        }
    }

    /* 删除 */
//    @Test
    @SneakyThrows
    public void test3() {
        minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object("test.zip").build());
    }

}
