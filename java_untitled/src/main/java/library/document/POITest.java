package library.document;

import com.google.common.collect.ImmutableMap;
import javautil.common.Constant;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

public class POITest {

    /* 读取xls */
//    @Test
    public void xlsRead() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:/Users/Administrator/Desktop/test.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet sheet = workbook.getSheet("Sheet1");
        HSSFRow row = sheet.getRow(0);
        System.out.println(row.getCell(0).getStringCellValue());
    }

    /* 创建xlsx */
    @Test
    public void xlsxCreate() throws IOException {
        File file = new File(Constant.getDesktop() + "test.xlsx");
        OutputStream outputStream = new FileOutputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");

        /* 居中边框 */
        XSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);

        List<Map<String, Object>> list = Arrays.asList(
                ImmutableMap.<String, Object>builder().put("id", "id").put("name", "name").put("pwd", "pwd").build(),
                ImmutableMap.<String, Object>builder().put("id", "1").put("name", "").put("pwd", "").build(),
                ImmutableMap.<String, Object>builder().put("id", "").put("name", "").put("pwd", "").build()
        );
        for (int i = 0; i < list.size(); i++) {
//            sheet.shiftRows(i, i + 1, 1, true, true); /* 移动下一行并保留格式 */
            XSSFRow row = sheet.createRow(i); /* 行 */
            Map<String, Object> map = list.get(i);
            int j = 0;
            for (Object value : map.values()) {
                XSSFCell cell = row.createCell(j);
                cell.setCellValue(String.valueOf(value)); /* 列 */
                cell.setCellStyle(style);
                j++;
            }
        }
        /* 合并单元格 */
        CellRangeAddress address = new CellRangeAddress(1, 2, 0, 2);
        sheet.addMergedRegion(address);

        workbook.write(outputStream);
        outputStream.close();
    }

    /* 读取xlsx */
//    @Test
    public void xlsxRead() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/module.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        List<Map<String, Object>> tempList = new ArrayList<>();
        int rowCount = sheet.getLastRowNum() + 1;
        if (rowCount > 1) {
            int cellCount = sheet.getRow(0).getLastCellNum();
            for (int i = 1; i < rowCount; i++) {
                Map<String, Object> map = new LinkedHashMap<>();
                for (int j = 0; j < cellCount; j++) {
                    try {
                        sheet.getRow(i).getCell(j).getStringCellValue();
                        map.put(sheet.getRow(0).getCell(j).getStringCellValue(), sheet.getRow(i).getCell(j).getStringCellValue()); /* 第0行是资源字段名，从第1行开始才是数据 */
                    } catch (NullPointerException e) {
                        map.put(sheet.getRow(0).getCell(j).getStringCellValue(), ""); /* 无数据 */
                    } catch (IllegalStateException e) {
                        map.put(sheet.getRow(0).getCell(j).getStringCellValue(), String.valueOf((int) sheet.getRow(i).getCell(j).getNumericCellValue())); /* 数字转换 */
                    }
                }
                tempList.add(map);
            }
            List<Map<String, Object>> mapList = tempList;
            for (Map<String, Object> map : tempList) { /* 删除所有value均为空的map */
                Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    String value = (String) iterator.next().getValue();
                    if (!value.isEmpty()) {
                        break;
                    }
                    if (!iterator.hasNext() && value.isEmpty()) { /* 最后一对key-value也为空 */
                        mapList.remove(map);
                    }
                }
            }
            System.out.println(mapList);
        } else {
            System.out.println("无数据");
        }
    }

}
