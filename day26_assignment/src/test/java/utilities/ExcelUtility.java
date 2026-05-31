package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    public static String getData(String file,
                                 String sheetName,
                                 int row,
                                 int cell) throws Exception {

        FileInputStream fis =
                new FileInputStream(file);

        XSSFWorkbook workbook =
                new XSSFWorkbook(fis);

        XSSFSheet sheet =
                workbook.getSheet(sheetName);

        String data =
                sheet.getRow(row)
                     .getCell(cell)
                     .getStringCellValue();

        workbook.close();

        return data;
    }
}