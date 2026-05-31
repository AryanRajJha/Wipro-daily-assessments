package sel_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        driver.manage().window().maximize();

        
        Thread.sleep(300);

        String title = driver.getTitle();

        System.out.println("Page Title: " + title);

        driver.quit();
    }
}