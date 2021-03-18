package library.document;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.util.List;

public class EasyPOITest {

    /* 读取 */
    @Test
    public void test() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("C:/Users/Administrator/Desktop/test.xlsx");
        ImportParams params = new ImportParams();
        List<ExcelData> dataList = ExcelImportUtil.importExcel(fileInputStream, ExcelData.class, params);
        System.out.println(dataList);
    }

}
