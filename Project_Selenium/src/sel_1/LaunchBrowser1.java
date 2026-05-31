package sel_1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class LaunchBrowser1
{
public static void main(String[] args) throws InterruptedException
{
	
WebDriver driver = new ChromeDriver();
 
driver.get("https://www.saucedemo.com");
 
driver.manage().window().maximize();
Thread.sleep(1000);
 
driver.findElement(By.id("user-name")).sendKeys("visual_user");
Thread.sleep(1000);
 
driver.findElement(By.id("password")).sendKeys("secret_sauce");
Thread.sleep(1000);
 
driver.findElement(By.id("login-button")).click();
 
System.out.println(driver.getTitle());
Thread.sleep(1000);
driver.quit();
}
}