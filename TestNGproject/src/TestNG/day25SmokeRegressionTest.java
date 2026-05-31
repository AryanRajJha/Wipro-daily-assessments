package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class day25SmokeRegressionTest {

    WebDriver driver;

    // Setup
    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
    }

    // Smoke Test 1
    @Test(groups = {"smoke"})
    public void verifyLoginPageTitle() {

        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, "Swag Labs");

        System.out.println("Smoke Test 1 Passed");
    }

    // Smoke Test 2
    @Test(groups = {"smoke"})
    public void verifyLoginButtonDisplayed() {

        boolean loginButton =
                driver.findElement(By.id("login-button")).isDisplayed();

        Assert.assertTrue(loginButton);

        System.out.println("Smoke Test 2 Passed");
    }

    // Regression Test 1
    @Test(groups = {"regression"})
    public void validLoginTest() throws InterruptedException {

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        Thread.sleep(2000);

        String currentURL = driver.getCurrentUrl();

        Assert.assertTrue(currentURL.contains("inventory"));

        System.out.println("Regression Test 1 Passed");
    }

    // Regression Test 2
    @Test(groups = {"regression"})
    public void invalidLoginTest() throws InterruptedException {

        driver.findElement(By.id("user-name"))
                .sendKeys("wrong_user");

        driver.findElement(By.id("password"))
                .sendKeys("wrong_password");

        driver.findElement(By.id("login-button")).click();

        Thread.sleep(2000);

        boolean errorMessage =
                driver.findElement(By.cssSelector("h3[data-test='error']"))
                        .isDisplayed();

        Assert.assertTrue(errorMessage);

        System.out.println("Regression Test 2 Passed");
    }

    // Close Browser
    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}