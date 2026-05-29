package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class day25MultipleLoginTest {

    WebDriver driver;

    // Test Method
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) throws InterruptedException {

        // Launch Browser
        driver = new ChromeDriver();

        // Open Website
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Maximize Window
        driver.manage().window().maximize();

        // Enter Username
        driver.findElement(By.id("username")).sendKeys(username);

        // Enter Password
        driver.findElement(By.id("password")).sendKeys(password);

        // Click Login Button
        driver.findElement(By.id("submit")).click();

        Thread.sleep(2000);

        // Validation
        String currentURL = driver.getCurrentUrl();

        if (username.equals("student") && password.equals("Password123")) {

            Assert.assertTrue(currentURL.contains("logged-in-successfully"),
                    "Valid Login Failed");

            System.out.println("Login Successful for: " + username);

        } else {

            Assert.assertTrue(currentURL.contains("practice-test-login"),
                    "Invalid Login Test Failed");

            System.out.println("Login Failed for: " + username);
        }
    }

    // DataProvider
    @DataProvider(name = "loginData")
    public Object[][] getData() {

        return new Object[][] {

                {"admin", "admin123"},
                {"user", "user123"},
                {"test", "test123"}

        };
    }

    // Close Browser
    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}