package library.untitled;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;
import org.junit.jupiter.api.Test;

import java.io.File;

public class Tess4JTest {

    @Test
    public void test() throws TesseractException {
        File file = new File("src/main/resources/render.jpg");
        ITesseract instance = new Tesseract();
        /*
         * ①不需要Tesseract-OCR Windows版
         * ②需要训练数据tessdata
         * */
        instance.setDatapath(LoadLibs.extractTessResources("tessdata").getAbsolutePath()); /* tess4j jar包中tessdata */
//        instance.setDatapath(new File("C:/Program Files/Tesseract-OCR/tessdata").getAbsolutePath()); /* 外部tessdata */
        String result = instance.doOCR(file);
        System.out.println(result);
    }

}
