package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {

        this.driver = driver;
    }

    By addToCart =
            By.xpath("(//button[contains(@title,'Add to Cart')])[1]");

    By cartButton =
            By.xpath("//span[text()='Shopping Cart']");

    By removeButton =
            By.xpath("//button[contains(@title,'Remove')]");

    public void addProductToCart() {

        driver.findElement(addToCart).click();
    }

    public void openCart() {

        driver.findElement(cartButton).click();
    }

    public void removeProduct() {

        driver.findElement(removeButton).click();
    }
}