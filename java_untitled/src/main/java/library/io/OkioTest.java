package library.io;

import okio.BufferedSource;
import okio.HashingSource;
import okio.Okio;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class OkioTest {

    /* Source输入流/Sink输出流 */
    @Test
    public void test() {
        try {
            HashingSource hashingSource = HashingSource.sha256(Okio.source(new File("/home/fantasy/Desktop/test.zip")));
            BufferedSource bufferedSource = Okio.buffer(hashingSource);
            bufferedSource.readAll(Okio.blackhole());
            System.out.println(hashingSource.hash().hex());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
