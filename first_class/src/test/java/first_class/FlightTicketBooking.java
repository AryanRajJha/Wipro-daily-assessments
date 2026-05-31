package first_class;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlightTicketBooking {

    public static void main(String[] args) throws InterruptedException {

        
        WebDriver driver = new ChromeDriver();

        driver.get("https://blazedemo.com/");

        driver.manage().window().maximize();

        Thread.sleep(3000);

        driver.findElement(By.name("fromPort"))
              .sendKeys("Boston");

        driver.findElement(By.name("toPort"))
              .sendKeys("London");

        Thread.sleep(2000);

        driver.findElement(
                By.xpath("//input[@value='Find Flights']"))
              .click();

        Thread.sleep(5000);

        driver.findElement(
                By.xpath("(//input[@value='Choose This Flight'])[1]"))
              .click();

        Thread.sleep(5000);

        driver.findElement(By.id("inputName"))
              .sendKeys("Aryan Raj");

        driver.findElement(By.id("address"))
              .sendKeys("Darbhanga");

        driver.findElement(By.id("city"))
              .sendKeys("Patna");

        driver.findElement(By.id("state"))
              .sendKeys("Bihar");

        driver.findElement(By.id("zipCode"))
              .sendKeys("846004");

        driver.findElement(By.id("creditCardNumber"))
              .sendKeys("1234567890123456");

        driver.findElement(By.id("creditCardMonth"))
              .clear();

        driver.findElement(By.id("creditCardMonth"))
              .sendKeys("12");

        driver.findElement(By.id("creditCardYear"))
              .clear();

        driver.findElement(By.id("creditCardYear"))
              .sendKeys("2028");

        driver.findElement(By.id("nameOnCard"))
              .sendKeys("Aryan Raj");

        Thread.sleep(2000);

        driver.findElement(
                By.xpath("//input[@value='Purchase Flight']"))
              .click();

        Thread.sleep(5000);

        System.out.println(
                driver.findElement(By.tagName("h1"))
                      .getText());

        Thread.sleep(3000);

    }
}