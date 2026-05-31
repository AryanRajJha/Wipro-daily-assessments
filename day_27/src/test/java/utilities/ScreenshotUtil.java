package utilities;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtil extends BaseClass {
	public static void capture(String name) {
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File dest = new File("Screenshots/" + name + ".png");
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}