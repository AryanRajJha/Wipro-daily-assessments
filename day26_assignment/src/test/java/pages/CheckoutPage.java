package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {

        this.driver = driver;
    }

    By checkoutButton = By.linkText("Checkout");

    By confirmOrder =
            By.xpath("//button[contains(text(),'Confirm Order')]");

    public void clickCheckout() {

        driver.findElement(checkoutButton).click();
    }

    public void confirmOrder() {

        driver.findElement(confirmOrder).click();
    }
}