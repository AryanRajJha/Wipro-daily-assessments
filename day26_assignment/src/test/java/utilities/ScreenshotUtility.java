package utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

    public static void captureScreenshot(
            WebDriver driver,
            String fileName) throws Exception {

        File src =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        File dest =
                new File("./screenshots/"
                        + fileName + ".png");

        FileUtils.copyFile(src, dest);
    }
}