package maven_package;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class maven_class {

    public static void main(String[] args) throws IOException {

        FileInputStream fis =new FileInputStream("C:\\Users\\HP\\OneDrive\\Desktop\\Book1.xlsx");

        Workbook wb =WorkbookFactory.create(fis);

        Sheet sh =wb.getSheet("Sheet1");

        int rows =sh.getLastRowNum();

        for(int i = 1; i <= rows; i++)
        {

            String username = sh.getRow(i).getCell(0).getStringCellValue();
            
            String password =sh.getRow(i).getCell(1).getStringCellValue();


            WebDriver driver =new ChromeDriver();

            driver.get("https://www.saucedemo.com");

            driver.findElement(By.id("user-name")).sendKeys(username);

            driver.findElement(By.id("password")).sendKeys(password);

            driver.findElement(By.id("login-button")).click();

            driver.quit();
        }

        wb.close();
    }
}