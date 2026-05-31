package first_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParaBankRegister {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        driver.manage().window().maximize();

        driver.findElement(By.id("customer.firstName"))
              .sendKeys("Aryan");

        driver.findElement(By.id("customer.lastName"))
              .sendKeys("Raj");

        driver.findElement(By.id("customer.address.street"))
              .sendKeys("Khudiram");

        driver.findElement(By.id("customer.address.city"))
              .sendKeys("Haldia");

        driver.findElement(By.id("customer.address.state"))
              .sendKeys("West Bengal");

        driver.findElement(By.id("customer.address.zipCode"))
              .sendKeys("123456");

        driver.findElement(By.id("customer.phoneNumber"))
              .sendKeys("1234567890");

        driver.findElement(By.id("customer.ssn"))
              .sendKeys("123456789");

        driver.findElement(By.id("customer.username"))
              .sendKeys("aryanraj12345");

        driver.findElement(By.id("customer.password"))
              .sendKeys("Password123");

        driver.findElement(By.id("repeatedPassword"))
              .sendKeys("Password123");

        driver.findElement(By.xpath("//input[@value='Register']"))
              .click();

        Thread.sleep(3000);

        System.out.println("Account Registered Successfully");

        driver.quit();
    }
}