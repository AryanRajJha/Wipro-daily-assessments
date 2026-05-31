package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By product = By.xpath("//div[text()='Sauce Labs Backpack']");
	By addToCart = By.xpath("(//button[text()='Add to cart'])[1]");
	By cart = By.className("shopping_cart_link");

	public void searchProduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(product));
	}

	public void applyFilter() {
		System.out.println("Filter Applied");
	}

	public void addProducts() {
		driver.findElement(addToCart).click();
	}

	public void openCart() {
		driver.findElement(cart).click();
	}
}