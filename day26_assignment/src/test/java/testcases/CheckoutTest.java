package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;

import pages.CartPage;
import pages.CheckoutPage;
import pages.SearchPage;

public class CheckoutTest extends BaseClass {

    SearchPage sp;

    CartPage cp;

    CheckoutPage chk;

    @BeforeTest
    public void start() {

        setup();
    }

    @Test
    public void checkoutTest() {

        sp = new SearchPage(driver);

        sp.searchProduct("MacBook");

        cp = new CartPage(driver);

        cp.addProductToCart();

        cp.openCart();

        chk = new CheckoutPage(driver);

        chk.clickCheckout();

        System.out.println("Checkout Started");
    }

    @AfterTest
    public void end() {

        closeBrowser();
    }
}