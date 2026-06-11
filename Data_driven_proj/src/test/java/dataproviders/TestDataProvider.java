package dataproviders;

import org.testng.annotations.DataProvider;

import utils.ExcelUtils;
import utils.JsonUtils;
import utils.CsvUtils;

public class TestDataProvider {

    @DataProvider(name = "excelData")
    public static Object[][] excelData()
            throws Exception {

        return ExcelUtils.getExcelData(
                "src/test/resources/testdata/LoginData.xlsx",
                "Sheet1");
    }

    @DataProvider(name = "jsonData")
    public static Object[][] jsonData()
            throws Exception {

        return JsonUtils.getJsonData(
                "src/test/resources/testdata/LoginData.json");
    }

    @DataProvider(name = "csvData")
    public static Object[][] csvData()
            throws Exception {

        return CsvUtils.getCsvData(
                "src/test/resources/testdata/LoginData.csv");
    }
}