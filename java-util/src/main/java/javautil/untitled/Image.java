package javautil.untitled;

import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public class Image {

    /* 格式转换（底层） */
    @SneakyThrows
    public static void formatConvert(byte[] bytes, String format, String path) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
        ImageIO.write(bufferedImage, format, new File(path));
    }

    /* 格式转换 */
    @SneakyThrows
    public static void formatConvert(File input, String format) {
        byte[] bytes = javautil.common.File.file2Bytes(input);
        Map<String, String> map = javautil.common.File.parse(input);
        String path = map.get("path");
        String fileName = map.get("fileName");
        String outputPath = path + fileName + "." + format;

        formatConvert(bytes, format, outputPath);
    }

    /* 文字水印（底层） */
    public static BufferedImage textWatermark(BufferedImage bufferedImage) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.black); /* 颜色 */
        graphics2D.setBackground(Color.white); /* 背景色 */
        graphics2D.setFont(new Font("宋体", Font.PLAIN, 30)); /* 文字大小 */
        graphics2D.drawString("文字水印", width / 2, height / 2); /* 水印位置/内容 */
        graphics2D.dispose();
        return bufferedImage;
    }

    /* 文字水印 */
    public static boolean textWatermark(File input) {
        boolean flag = true;
        try {
            BufferedImage bufferedImage = textWatermark(ImageIO.read(input));
            Map<String, String> map = javautil.common.File.parse(input);
            String path = map.get("path");
            String suffix = map.get("suffix");
            String uuid = UUID.randomUUID().toString();
            File output = new File(path + uuid + suffix);
            ImageIO.write(bufferedImage, suffix.replace(".", ""), output);
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    /* 图片水印（底层） */
    public static BufferedImage imgWatermark(BufferedImage origin, BufferedImage watermark) {
        Integer originWidth = origin.getWidth();
        Integer originHeight = origin.getHeight();
        Integer watermarkWidth = watermark.getWidth();
        Integer watermarkHeight = watermark.getHeight();

        BufferedImage bufferedImage = new BufferedImage(originWidth, originHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.drawImage(origin, 0, 0, originWidth, originHeight, null); /* 绘制原图 */
        /* 水印图左顶点的坐标（左上） */
        int x = 0;
        int y = 0;
        int position = 10;
        switch (position) {
            case 1:
                /* 左上 */
                x = 0;
                y = 0;
                break;
            case 2:
                /* 左中 */
                x = 0;
                y = (originHeight - watermarkHeight) / 2;
                break;
            case 3:
                /* 左下 */
                x = 0;
                y = originHeight - watermarkHeight;
                break;
            case 4:
                /* 右上 */
                x = originWidth - watermarkWidth;
                y = 0;
                break;
            case 5:
                /* 右中 */
                x = originWidth - watermarkWidth;
                y = (originHeight - watermarkHeight) / 2;
                break;
            case 6:
                /* 右下 */
                x = originWidth - watermarkWidth;
                y = originHeight - watermarkHeight;
                break;
            case 7:
                /* 中上 */
                x = (originWidth - watermarkWidth) / 2;
                y = 0;
                break;
            case 8:
                /* 居中 */
                x = (originWidth - watermarkWidth) / 2;
                y = (originHeight - watermarkHeight) / 2;
                break;
            case 9:
                /* 中下 */
                x = (originWidth - watermarkWidth) / 2;
                y = originHeight - watermarkHeight;
                break;
            case 10:
                /* 自定义（比率） */
                x = (int) (originWidth * 0.1);
                y = (int) (originHeight * 0.1);
                int maxX = originWidth - watermarkWidth; /* x,y最大值（水印图完整显示在原图上） */
                int maxY = originHeight - watermarkHeight;
                if (x > maxX) {
                    x = maxX;
                }
                if (y > maxY) {
                    y = maxY;
                }
                break;
        }
        graphics2D.drawImage(watermark, x, y, watermarkWidth, watermarkHeight, null); /* 绘制水印 */
        graphics2D.dispose();
        return bufferedImage;
    }

    /* 图片水印 */
    public static boolean imgWatermark(File originImg, File watermarkImg) {
        boolean flag = true;
        try {
            BufferedImage bufferedImage = imgWatermark(ImageIO.read(originImg), ImageIO.read(watermarkImg));
            Map<String, String> map = javautil.common.File.parse(originImg);
            String path = map.get("path");
            String suffix = map.get("suffix");
            String uuid = UUID.randomUUID().toString();
            File output = new File(path + uuid + suffix);
            ImageIO.write(bufferedImage, suffix.replace(".", ""), output); /* 写入到文件 */
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    public static boolean imgWatermark(String originImg, String watermarkImg) {
        return imgWatermark(new File(originImg), new File(watermarkImg));
    }

}
