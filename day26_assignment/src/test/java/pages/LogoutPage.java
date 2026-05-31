package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {

    WebDriver driver;

    public LogoutPage(WebDriver driver) {

        this.driver = driver;
    }

    By myAccount = By.xpath("//span[text()='My Account']");

    By logout = By.linkText("Logout");

    public void logoutUser() {

        driver.findElement(myAccount).click();

        driver.findElement(logout).click();
    }
}