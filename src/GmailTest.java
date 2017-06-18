import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.SessionId;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class GmailTest {

    public static void main(String[] args) {
        //System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");

        String userName = "";
        String password= "";

        WebDriver driver = null;
        try {
            driver = new FirefoxDriver();
            String baseUrl = "https://www.gmail.com";
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

            driver.get(baseUrl);

            System.out.println("Enter User Name");
            driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys(userName);

            System.out.println("Click Next Button");
            driver.findElement(By.xpath("//div[@id='identifierNext']")).click();

            System.out.println("Enter Password");
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

            System.out.println("Click Next Button");
            driver.findElement(By.xpath("//*[@id='passwordNext']/content")).click();

            System.out.println("Waiting...");
            Thread.sleep(50000L);

            System.out.println("Click Compose Button");
            driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();

            driver.findElement(By.xpath("//textarea[@aria-label='To']")).sendKeys("ajjax12@gmail.com");

            driver.findElement(By.xpath("//input[@placeholder='Subject']")).click();
            driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("TestMail");

            driver.findElement(By.xpath("//*[@aria-label='Message Body']")).click();
            driver.findElement(By.xpath("//*[@aria-label='Message Body']")).sendKeys("Hello");

            System.out.println("Click Send Button");
            driver.findElement(By.xpath("//div[text()='Send']")).click();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
