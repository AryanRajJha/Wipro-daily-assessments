package sel_1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day22EcommerceAutomationCombined {

    public static void main(String[] args) throws InterruptedException {

        // Launch Chrome Browser
        WebDriver driver = new ChromeDriver();

        // Maximize Browser
        driver.manage().window().maximize();

        // Implicit Wait
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        // Open Tira Website
        driver.get("https://www.tirabeauty.com/");

        System.out.println("Tira Website Opened Successfully");


        try {

            WebElement popupClose =
                    driver.findElement(By.xpath("//button[contains(@class,'close')]"));

            popupClose.click();

            System.out.println("Popup Closed");

        } catch (Exception e) {

            System.out.println("No Popup Found");
        }

       
        WebElement searchBox =
                driver.findElement(By.xpath("//input[@placeholder='Search']"));

        searchBox.sendKeys("Cleanser");

        searchBox.sendKeys(Keys.ENTER);

        System.out.println("Product Search Successful");

        Thread.sleep(3000);

        List<WebElement> products =
                driver.findElements(By.xpath("//div[contains(@class,'product-card')]"));

        System.out.println("Available Products:");

        for (int i = 0; i < products.size(); i++) {

            try {

                String productName =
                        products.get(i).findElement(
                                By.xpath(".//p")).getText();

                System.out.println(productName);

            } catch (Exception e) {

                System.out.println("Product Name Not Found");
            }
        }

        

        driver.findElement(By.xpath("(//div[contains(@class,'product-card')])[1]"))
                .click();

        System.out.println("First Product Opened");

        Thread.sleep(3000);

        

        WebElement productTitle =
                driver.findElement(By.tagName("h1"));

        if (productTitle.isDisplayed()) {

            System.out.println("Product Title : "
                    + productTitle.getText());
        }

        

        WebElement productPrice =
                driver.findElement(By.xpath("//span[contains(@class,'price')]"));

        if (productPrice.isDisplayed()) {

            System.out.println("Product Price : "
                    + productPrice.getText());
        }

        WebElement productImage =
                driver.findElement(By.tagName("img"));

        if (productImage.isDisplayed()) {

            System.out.println("Product Image Displayed");
        }


        WebElement addToBag =
                driver.findElement(By.xpath("//button[contains(text(),'Add to Bag')]"));

        if (addToBag.isDisplayed()) {

            System.out.println("Add To Bag Button Visible");

            addToBag.click();

            System.out.println("Product Added To Bag");
        }

        Thread.sleep(3000);


        driver.findElement(By.xpath("//a[contains(@href,'cart')]"))
                .click();

        System.out.println("Cart Opened");

        Thread.sleep(3000);

       
        WebElement checkoutButton =
                driver.findElement(By.xpath("//button[contains(text(),'Checkout')]"));

        if (checkoutButton.isDisplayed()) {

            System.out.println("Checkout Button Visible");
        }

       
        try {

            List<WebElement> recommendedProducts =
                    driver.findElements(
                            By.xpath("//section//*[contains(text(),'Recommended')]"));

            if (recommendedProducts.size() > 0) {

                System.out.println("Recommended Products Section Visible");
            }

        } catch (Exception e) {

            System.out.println("Recommendation Section Not Found");
        }

        driver.navigate().back();

        Thread.sleep(3000);

        try {

            WebElement filterButton =
                    driver.findElement(By.xpath("//button[contains(text(),'Filter')]"));

            filterButton.click();

            System.out.println("Filter Opened");

        } catch (Exception e) {

            System.out.println("Filter Button Not Found");
        }


        try {

            WebElement sortButton =
                    driver.findElement(By.xpath("//button[contains(text(),'Sort')]"));

            sortButton.click();

            System.out.println("Sort Button Clicked");

        } catch (Exception e) {

            System.out.println("Sort Option Not Found");
        }

        Thread.sleep(3000);

        driver.quit();

        System.out.println("Tira Automation Test Completed Successfully");
    }
}