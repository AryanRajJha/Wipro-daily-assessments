package utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static String getData(int row, int cell) {
		String path = "src/test/resources/testdata/LoginData.xlsx";
		try {
			FileInputStream fis = new FileInputStream(path);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			String data = sheet.getRow(row).getCell(cell).getStringCellValue();
			workbook.close();
			return data;
		} catch (Exception e) {
			return "";
		}
	}
}