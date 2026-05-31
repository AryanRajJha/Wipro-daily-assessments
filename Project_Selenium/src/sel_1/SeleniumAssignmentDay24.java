package sel_1;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumAssignmentDay24 {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        Actions act =
                new Actions(driver);
        // 1. TEXT FIELD
        driver.get("https://demoqa.com/text-box");

        driver.findElement(By.id("userName"))
                .sendKeys("Aryan Raj");

        driver.findElement(By.id("userEmail"))
                .sendKeys("aryan@gmail.com");

        driver.findElement(By.id("currentAddress"))
                .sendKeys("Darbhanga, Bihar");

        driver.findElement(By.id("permanentAddress"))
                .sendKeys("India");

        System.out.println("1. Text Field - Successfully Executed");
        // 2. BUTTON
        js.executeScript("window.scrollBy(0,500)");

        WebElement submit =
                driver.findElement(By.id("submit"));

        js.executeScript("arguments[0].click();", submit);

        System.out.println("2. Buttons - Successfully Executed");

        Thread.sleep(2000);
        // 3. RADIO BUTTON
        driver.get("https://demoqa.com/radio-button");

        driver.findElement(
                By.xpath("//label[@for='yesRadio']"))
                .click();

        System.out.println("3. Radio Buttons - Successfully Executed");

        Thread.sleep(2000);
        // 7. CHECK BOX
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox =
                driver.findElement(
                        By.xpath("(//input[@type='checkbox'])[1]"));

        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        System.out.println("7. Check Boxes - Successfully Executed");

        Thread.sleep(2000);
        // 4. LIST BOX
        driver.get("https://demoqa.com/select-menu");

        driver.findElement(By.id("react-select-2-input"))
                .sendKeys("Group 1, option 1");

        driver.findElement(By.id("react-select-2-input"))
                .sendKeys(Keys.ENTER);

        System.out.println("4. List Box - Successfully Executed");

        Thread.sleep(2000);
        // 5. DROPDOWN BUTTON
        WebElement dropdown =
                driver.findElement(By.id("oldSelectMenu"));

        Select select =
                new Select(dropdown);

        select.selectByVisibleText("Purple");

        System.out.println("5. Dropdown Button - Successfully Executed");

        Thread.sleep(2000);
        // 6. IMAGE HANDLING
        driver.get("https://demoqa.com");

        WebElement image =
                driver.findElement(By.tagName("img"));

        System.out.println(
                "6. Image Handling - Successfully Executed : "
                        + image.isDisplayed());

        Thread.sleep(2000);
        // 8. SCROLL PAGE
        js.executeScript(
                "window.scrollTo(0,document.body.scrollHeight)");

        Thread.sleep(2000);

        js.executeScript("window.scrollTo(0,0)");

        System.out.println("8. Scroll Page - Successfully Executed");
        // 9. SCREENSHOT
        File src =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        Files.copy(
                src.toPath(),
                new File("Screenshot.png").toPath(),
                StandardCopyOption.REPLACE_EXISTING);

        System.out.println("9. Screenshot Captured Successfully");

        // 10. ACTIONS CLASS

        // DOUBLE CLICK
        driver.get("https://demoqa.com/buttons");

        WebElement doubleBtn =
                driver.findElement(By.id("doubleClickBtn"));

        act.doubleClick(doubleBtn).perform();

        System.out.println("Double Click Performed Successfully");

        Thread.sleep(1000);

        // RIGHT CLICK
        WebElement rightBtn =
                driver.findElement(By.id("rightClickBtn"));

        act.contextClick(rightBtn).perform();

        System.out.println("Right Click Performed Successfully");

        Thread.sleep(1000);

        // DYNAMIC CLICK
        WebElement clickMe =
                driver.findElement(
                        By.xpath("//button[text()='Click Me']"));

        clickMe.click();

        System.out.println("Dynamic Click Performed Successfully");

        Thread.sleep(1000);

        // MOUSE HOVER
        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement hover =
                driver.findElement(By.className("figure"));

        act.moveToElement(hover).perform();

        System.out.println("Mouse Hover Performed Successfully");

        Thread.sleep(1000);

        // SLIDER
        driver.get(
                "https://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider =
                driver.findElement(By.tagName("input"));

        act.dragAndDropBy(slider, 50, 0).perform();

        System.out.println("Slider Moved Successfully");

        Thread.sleep(1000);

        // DRAG AND DROP
        driver.get(
                "https://crossbrowsertesting.github.io/drag-and-drop.html");

        WebElement source =
                driver.findElement(By.id("draggable"));

        WebElement target =
                driver.findElement(By.id("droppable"));

        act.dragAndDrop(source, target).perform();

        System.out.println("Drag And Drop Performed Successfully");

        Thread.sleep(1000);

        System.out.println("10. Actions Class - Successfully Executed");
        // 11. ALERT HANDLING
        driver.get("https://demoqa.com/alerts");

        // SIMPLE ALERT
        WebElement alertBtn =
                driver.findElement(By.id("alertButton"));

        js.executeScript("arguments[0].click();", alertBtn);

        Alert alert1 =
                wait.until(ExpectedConditions.alertIsPresent());

        alert1.accept();

        System.out.println("Simple Alert Handled Successfully");

        Thread.sleep(1000);

        // TIMER ALERT
        WebElement timerBtn =
                driver.findElement(By.id("timerAlertButton"));

        js.executeScript("arguments[0].click();", timerBtn);

        Alert timerAlert =
                wait.until(ExpectedConditions.alertIsPresent());

        timerAlert.accept();

        System.out.println("Timer Alert Handled Successfully");

        Thread.sleep(1000);

        // CONFIRM ALERT
        WebElement confirmBtn =
                driver.findElement(By.id("confirmButton"));

        js.executeScript("arguments[0].click();", confirmBtn);

        Alert confirmAlert =
                wait.until(ExpectedConditions.alertIsPresent());

        confirmAlert.dismiss();

        System.out.println("Confirmation Alert Handled Successfully");

        Thread.sleep(1000);

        // PROMPT ALERT
        WebElement promptBtn =
                driver.findElement(By.id("promtButton"));

        js.executeScript("arguments[0].click();", promptBtn);

        Alert promptAlert =
                wait.until(ExpectedConditions.alertIsPresent());

        promptAlert.sendKeys("Hello Selenium");

        promptAlert.accept();

        System.out.println("Prompt Alert Handled Successfully");

        System.out.println("11. Alerts Handling - Successfully Executed");

        // FINAL OUTPUT
        System.out.println("ALL SELENIUM CONCEPTS COMPLETED");

        Thread.sleep(3000);

        driver.quit();
    }
}