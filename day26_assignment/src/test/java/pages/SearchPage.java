package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {

        this.driver = driver;
    }

    By searchBox = By.name("search");

    By searchButton =
            By.xpath("//button[@class='btn btn-light btn-lg']");

    public void searchProduct(String product) {

        driver.findElement(searchBox).sendKeys(product);

        driver.findElement(searchButton).click();
    }
}