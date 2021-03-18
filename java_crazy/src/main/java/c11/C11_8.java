package c11;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class C11_8 {

    /* 读取文件为BufferedImage并输出 */
    @Test
    public void test() throws IOException {
        File file = new File("C:/Users/Administrator/Desktop/test.jpg");
        BufferedImage input = ImageIO.read(file);
        Integer originWidth = input.getWidth();
        Integer originHeight = input.getHeight();
        BufferedImage output = new BufferedImage(originWidth, originHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = output.createGraphics();
        graphics2D.drawImage(input, 0, 0, originWidth, originHeight, null);

//        ImageIO.write(output, "jpg", new File("C:/Users/Administrator/Desktop/test2.jpg")); /* 写入到文件 */

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(output, "jpg", outputStream); /* 写入到字节流 */
        byte[] bytes = outputStream.toByteArray(); /* 写入到字节 */

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        output = ImageIO.read(byteArrayInputStream);
    }

}
