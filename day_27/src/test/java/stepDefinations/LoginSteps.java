package stepDefinations;

import io.cucumber.java.en.*;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.BaseClass;
import utilities.ExcelUtils;

public class LoginSteps extends BaseClass {
	LoginPage login;
	HomePage home;
	CartPage cart;

	@Given("User launches browser")
	public void launchBrowser() {
		initializeBrowser();
	}

	@When("User login using {string}")
	public void loginUsing(String rowNumber) {
		login = new LoginPage(driver);
		int row = Integer.parseInt(rowNumber);
		String username = ExcelUtils.getData(row, 0);
		String password = ExcelUtils.getData(row, 1);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickLogin();
	}

	@When("User searches product {string}")
	public void searchProduct(String product) {
		home = new HomePage(driver);
		home.searchProduct();
	}

	@When("User applies filter")
	public void applyFilter() {
		home.applyFilter();
	}

	@When("User adds products to cart")
	public void addProducts() {
		home.addProducts();
		home.openCart();
	}

	@When("User removes one product")
	public void removeProduct() {
		cart = new CartPage(driver);
		cart.removeProduct();
	}

	@Then("Validate total amount")
	public void validateTotal() {
		cart.validateAmount();
	}

	@When("User proceeds to checkout")
	public void checkout() {
		cart.checkout();
	}

	@When("User logout successfully")
	public void logout() {
		closeBrowser();
	}
}