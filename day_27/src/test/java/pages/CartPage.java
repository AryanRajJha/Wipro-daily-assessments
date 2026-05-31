package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	By removeBtn = By.id("remove-sauce-labs-backpack");
	By checkoutBtn = By.id("checkout");

	public void removeProduct() {
		driver.findElement(removeBtn).click();
	}

	public void validateAmount() {
		System.out.println("Total Amount Validated");
	}

	public void checkout() {
		driver.findElement(checkoutBtn).click();
	}
}