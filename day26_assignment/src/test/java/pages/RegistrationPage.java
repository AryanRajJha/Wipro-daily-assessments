package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {

        this.driver = driver;
    }

    By myAccount = By.xpath("//span[text()='My Account']");

    By register = By.linkText("Register");

    By firstName = By.id("input-firstname");

    By lastName = By.id("input-lastname");

    By email = By.id("input-email");

    By password = By.id("input-password");

    By privacyPolicy = By.name("agree");

    By continueBtn = By.xpath("//button[text()='Continue']");

    public void registerUser(String fname,
                             String lname,
                             String mail,
                             String pass) {

        driver.findElement(myAccount).click();

        driver.findElement(register).click();

        driver.findElement(firstName).sendKeys(fname);

        driver.findElement(lastName).sendKeys(lname);

        driver.findElement(email).sendKeys(mail);

        driver.findElement(password).sendKeys(pass);

        driver.findElement(privacyPolicy).click();

        driver.findElement(continueBtn).click();
    }
}