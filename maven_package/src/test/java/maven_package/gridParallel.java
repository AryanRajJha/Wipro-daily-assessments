package maven_package;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class gridParallel {

    WebDriver driver;

    @Parameters("browser")
    @Test
    public void launchBrowser(
            @Optional("chrome") String browser)
            throws MalformedURLException {

        URL hubURL =
                new URL("http://localhost:4444");

        if(browser.equalsIgnoreCase("chrome"))
        {
            ChromeOptions options =
                    new ChromeOptions();

            driver = new RemoteWebDriver(
                    hubURL, options);

            System.out.println(
                    "Chrome Browser Started");
        }

        else if(browser.equalsIgnoreCase("firefox"))
        {
            FirefoxOptions options =
                    new FirefoxOptions();

            driver = new RemoteWebDriver(
                    hubURL, options);

            System.out.println(
                    "Firefox Browser Started");
        }

        driver.get("https://www.google.com");

        System.out.println(
                "Title : "
                + driver.getTitle());

        System.out.println(
                "Thread ID : "
                + Thread.currentThread().getId());
    }

    @AfterTest
    public void closeBrowser()
    {
        if(driver != null)
        {
            driver.quit();

            System.out.println(
                    "Browser Closed");
        }
    }
}