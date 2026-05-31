package first_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class AmazonLoginSearchLogout {

    public static void main(String[] args) throws InterruptedException {

    
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.amazon.in");

        Thread.sleep(5000);

        driver.findElement(By.id("nav-link-accountList")).click();

        driver.findElement(By.id("ap_email_login"))
                .sendKeys("9199087661");

        driver.findElement(By.id("continue")).click();

        driver.findElement(By.id("ap_password"))
                .sendKeys("Aryan@2003");

        driver.findElement(By.id("signInSubmit")).click();

        Thread.sleep(5000);

        driver.findElement(By.id("twotabsearchtextbox"))
                .sendKeys("iPhone 16");

        driver.findElement(By.id("nav-search-submit-button")).click();

        Thread.sleep(5000);

//        WebElement firstProduct = driver.findElement(
//                By.cssSelector("h2 a"));
//
//        firstProduct.click();
//
//        Thread.sleep(5000);
//
//        for (String windowHandle : driver.getWindowHandles()) {
//            driver.switchTo().window(windowHandle);
//        }
//
//        Thread.sleep(3000);

        driver.findElement(By.id("a-autoid-3-announce")).click();

        Thread.sleep(5000);

        driver.findElement(By.id("nav-cart")).click();

        Thread.sleep(5000);
//
//        driver.findElement(By.id("nav-link-accountList")).click();
//
//        Thread.sleep(3000);
//
//        driver.findElement(By.xpath("//span[text()='Sign Out']")).click();
//
//        Thread.sleep(5000);
        
        
        
        Actions action = new Actions(driver);

        WebElement accountList = driver.findElement(
                By.id("nav-link-accountList"));

        action.moveToElement(accountList).perform();

        Thread.sleep(3000);

        // Click on Sign Out
        driver.findElement(By.xpath("//span[text()='Sign Out']")).click();

        Thread.sleep(5000);

        driver.quit();
    }
}