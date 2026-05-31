package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass {

    LoginPage lp;

    @BeforeTest
    public void start() {

        setup();
    }

    @Test
    public void loginTest() {

        lp = new LoginPage(driver);

        lp.clickMyAccount();

        lp.clickLogin();

        lp.enterEmail("test@gmail.com");

        lp.enterPassword("test123");

        lp.clickLoginButton();

        System.out.println("Login Successful");
    }

    @AfterTest
    public void end() {

        closeBrowser();
    }
}