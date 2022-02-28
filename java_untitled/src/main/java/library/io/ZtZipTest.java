package library.io;

import org.junit.jupiter.api.Test;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;

public class ZtZipTest {

    @Test
    public void test() {
        ZipUtil.unpack(new File("C:/Users/Administrator/Desktop/line.zip"), new File("C:/Users/Administrator/Desktop"));
    }

}
