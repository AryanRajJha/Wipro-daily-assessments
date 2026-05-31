package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;

import pages.CartPage;
import pages.SearchPage;

public class CartTest extends BaseClass {

    SearchPage sp;

    CartPage cp;

    @BeforeTest
    public void start() {

        setup();
    }

    @Test
    public void cartTest() {

        sp = new SearchPage(driver);

        sp.searchProduct("iPhone");

        cp = new CartPage(driver);

        cp.addProductToCart();

        cp.openCart();

        System.out.println("Product Added To Cart");
    }

    @AfterTest
    public void end() {

        closeBrowser();
    }
}