package stepdefination;

import aryan.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Loginsteps extends BaseClass
{
	@Given("user launches browser")
	public void launch_browser()
	{
		System.out.println("Browser launched successfully");
	}
	@Given("user opens login page")
	public void open_login_page()
	{
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	System.out.println("Application opened");
	}
	@When("user enters username {string}")
	public void enter_username(String username)
	{
		System.out.println("Username: " + username);
	}
	@When("user enters password {string}")
	public void enter_password(String password)
	{
		System.out.println("Password: " + password);
	}
	@When("user clicks login button")
	public void enter_login()
	{
		System.out.println("Clicked login button");
	}
	@Then("user should navigate to dashboard")
	public void dashboard()
	{
		System.out.println("Dashboard Displayed");
		
	}
	@Then("user should see error message")
	public void error_message()
	{
		System.out.println("Invalid credentials");
		
	}
}