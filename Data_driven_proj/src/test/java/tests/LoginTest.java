package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import dataproviders.TestDataProvider;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "excelData",
          dataProviderClass =
          TestDataProvider.class)

    public void loginUsingExcel(String username,
                                String password) {

        driver.get(
            "https://practicetestautomation.com/practice-test-login/");

        LoginPage login =
                new LoginPage(driver);

        login.login(username,password);
    }

    @Test(dataProvider = "jsonData",
          dataProviderClass =
          TestDataProvider.class)

    public void loginUsingJson(String username,
                               String password) {

        driver.get(
            "https://practicetestautomation.com/practice-test-login/");

        LoginPage login =
                new LoginPage(driver);

        login.login(username,password);
    }

    @Test(dataProvider = "csvData",
          dataProviderClass =
          TestDataProvider.class)

    public void loginUsingCsv(String username,
                              String password) {

        driver.get(
            "https://practicetestautomation.com/practice-test-login/");

        LoginPage login =
                new LoginPage(driver);

        login.login(username,password);
    }
}