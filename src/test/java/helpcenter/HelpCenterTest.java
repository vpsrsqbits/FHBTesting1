package helpcenter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HelpCenterTest {
    WebDriver driver;
    WebElement help_Title, help_Description, submit, email, password, signIn;
    @BeforeAll
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://dev-app-fhb.quartustech.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        email = driver.findElement(By.id("username"));
        password = driver.findElement(By.id("password"));
        signIn = driver.findElement(By.xpath("//button[contains(text(),'Sign In')]"));
        driver.manage().window().maximize();
        email.sendKeys("randall.hen");
        password.sendKeys("Ram@1234");
        signIn.click();
        Thread.sleep(5000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://dev-app-fhb.quartustech.com/help-center/");
    }
    @Test
    public void help(){
        help_Title = driver.findElement(By.id("title"));
        help_Description = driver.findElement(By.id("description"));
        submit = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
        help_Title.sendKeys("Test title");
        help_Description.sendKeys("Test Description");
        submit.click();
    }
    @AfterAll
    public void teardown(){
        driver.quit();
    }
}
