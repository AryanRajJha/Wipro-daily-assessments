package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LogoutPage;

public class LogoutTest extends BaseClass {

    LogoutPage lp;

    @BeforeTest
    public void start() {

        setup();
    }

    @Test
    public void logoutTest() {

        lp = new LogoutPage(driver);

        lp.logoutUser();

        System.out.println("Logout Successful");
    }

    @AfterTest
    public void end() {

        closeBrowser();
    }
}