package library.document;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.util.List;

public class EasyPOIDemo {

    /* 读取 */
    @Test
    @SneakyThrows
    public void test() {
        FileInputStream fileInputStream = new FileInputStream("C:/Users/Administrator/Desktop/test.xlsx");
        ImportParams params = new ImportParams();
        List<ExcelData> dataList = ExcelImportUtil.importExcel(fileInputStream, ExcelData.class, params);
        System.out.println(dataList);
    }

}
