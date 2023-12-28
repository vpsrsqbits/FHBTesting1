package becomeasponsor;

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
public class BecomeSponsorTest {
    WebElement email,password,signIn,yes_Logout,logout,becomeSponsor;
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
    void becomeSponsor() throws InterruptedException {
        becomeSponsor = driver.findElement(By.xpath("//*[contains(text(),'Become A Sponsor')]"));
        becomeSponsor.click();
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
