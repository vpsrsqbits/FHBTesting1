package about;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AboutTest {
    WebElement email,password,signIn,yes_Logout,logout,about;
    WebDriver driver;
    @BeforeAll
    void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://dev-app-fhb.quartustech.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        email = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        signIn = driver.findElement(By.xpath("//button[contains(text(),'Sign In')]"));
        driver.manage().window().maximize();
        email.sendKeys("randall.hen");
        password.sendKeys("Ram@1234");
        signIn.click();
        Thread.sleep(5000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://dev-app-fhb.quartustech.com/");
    }
    @Test
    void about(){
        about = driver.findElement(By.xpath("//*[contains(text(),'About')]"));
        about.click();

    }
    @AfterAll
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        logout = driver.findElement(By.xpath("//*[contains(text(),'Log Out')]"));
        logout.click();
        Thread.sleep(2000);
        yes_Logout = driver.findElement(By.xpath("//*[contains(text(),'Yes, Log Out')]"));
        yes_Logout.click();
        Thread.sleep(2000);
        driver.quit();
    }
}
