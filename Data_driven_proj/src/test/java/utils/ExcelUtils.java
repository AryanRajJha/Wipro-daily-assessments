package utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static Object[][] getExcelData(String filePath,
                                          String sheetName)
                                          throws Exception {

        FileInputStream fis =
                new FileInputStream(filePath);

        Workbook workbook =
                new XSSFWorkbook(fis);

        Sheet sheet =
                workbook.getSheet(sheetName);

        int rows =
                sheet.getPhysicalNumberOfRows();

        int cols =
                sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data =
                new Object[rows - 1][cols];

        for(int i = 1; i < rows; i++) {

            for(int j = 0; j < cols; j++) {

                data[i - 1][j] =
                        sheet.getRow(i)
                        .getCell(j)
                        .toString();
            }
        }

        workbook.close();

        return data;
    }
}