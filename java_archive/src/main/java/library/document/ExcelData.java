package library.document;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

@Data
public class ExcelData {

    @Excel(name = "id") /* 需要与Excel表头严格对应 */
    private Integer id;

    @Excel(name = "name")
    private String name;

}
