package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.SearchPage;

public class SearchTest extends BaseClass {

    SearchPage sp;

    @BeforeTest
    public void start() {

        setup();
    }

    @Test
    public void searchTest() {

        sp = new SearchPage(driver);

        sp.searchProduct("Laptop");

        System.out.println("Search Successful");
    }

    @AfterTest
    public void end() {

        closeBrowser();
    }
}