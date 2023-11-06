package library.untitled;

import lombok.SneakyThrows;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ThumbnailatorTest {

    /* 尺寸/旋转/压缩 */
    @Test
    @SneakyThrows
    public void test() {
        Thumbnails.of("C:/Users/Administrator/Desktop/test.jpg")
//                .scale(0.9f) /* 整体调整 */
                .scale(1.0f, 1.0f) /* 长宽缩放 */
                .rotate(90f) /* 向右旋转 */
                .outputQuality(0.5f) /* 图片压缩质量 */
                .toFile("C:/Users/Administrator/Desktop/test2.jpg");
    }

    /* 文字水印 */
//    @Test
    @SneakyThrows
    public void test2() {
        BufferedImage bufferedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB); /* 8位RGB */
        Graphics2D graphics2D = bufferedImage.createGraphics();
        bufferedImage = graphics2D.getDeviceConfiguration().createCompatibleImage(100, 100, Transparency.TRANSLUCENT); /* 透明背景 */
        graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(new Color(0, 0, 0));
        graphics2D.setFont(new Font("宋体", Font.PLAIN, 10));
        graphics2D.drawString("文字水印", 10, 10);

        Thumbnails.of("C:/Users/Administrator/Desktop/test.jpg")
                .scale(1.0f)
                .watermark(Positions.CENTER, bufferedImage, 1.0f)
                .toFile("C:/Users/Administrator/Desktop/test2.jpg");
    }

}
