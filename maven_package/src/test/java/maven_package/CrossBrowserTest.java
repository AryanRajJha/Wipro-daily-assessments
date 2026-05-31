package maven_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {

    WebDriver driver;

    @Parameters("browser")
    @Test
    public void launchBrowser(String browser) {

        if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        driver.get("https://www.saucedemo.com");
        System.out.println("Browser Launched: " + browser);

        driver.quit();
    }
}