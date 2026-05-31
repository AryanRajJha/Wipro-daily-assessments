package sel_1;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoEcommerceFlow {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        

        driver.get("https://www.saucedemo.com/");


        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

       

        if (driver.getCurrentUrl().contains("inventory")) {

            System.out.println("Login Successful");

        } else {

            System.out.println("Login Failed");
        }



        String searchKeyword = "Backpack";

        List<WebElement> products =
                driver.findElements(By.className("inventory_item"));

        boolean productFound = false;

        for (WebElement product : products) {

       

            String title = product.findElement(
                    By.className("inventory_item_name"))
                    .getText();

            if (title.contains(searchKeyword)) {

                productFound = true;

                System.out.println("Product Found");

                System.out.println("Product Title : " + title);


                String price = product.findElement(
                        By.className("inventory_item_price"))
                        .getText();

                System.out.println("Product Price : " + price);

     

                String description = product.findElement(
                        By.className("inventory_item_desc"))
                        .getText();

                System.out.println("Product Description : "
                        + description);

         

                WebElement image =
                        product.findElement(By.tagName("img"));

                if (image.isDisplayed()) {

                    System.out.println("Product Image Visible");
                }

       

                image.click();

                Thread.sleep(2000);

            

                WebElement zoomImage =
                        driver.findElement(
                                By.className("inventory_details_img"));

                if (zoomImage.isDisplayed()) {

                    System.out.println("Image Zoom Working");
                }

          

                WebElement addToCartBtn =
                        driver.findElement(
                                By.xpath("//button[contains(text(),'Add to cart')]"));

                if (addToCartBtn.isDisplayed()) {

                    System.out.println("Add To Cart Button Visible");
                }

                addToCartBtn.click();

               

                WebElement cartButton =
                        driver.findElement(
                                By.className("shopping_cart_link"));

                if (cartButton.isDisplayed()) {

                    System.out.println("Cart Button Visible");
                }

                cartButton.click();

                

                WebElement checkoutButton =
                        driver.findElement(By.id("checkout"));

                if (checkoutButton.isDisplayed()) {

                    System.out.println("Checkout Button Visible");
                }

                break;
            }
        }

        if (!productFound) {

            System.out.println("Product Not Found");
        }

     

        Thread.sleep(3000);

        driver.quit();
    }
}