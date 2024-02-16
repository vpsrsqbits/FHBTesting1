import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ForgotPasswordTest {

    String url = "https://dev-app-fhb.quartustech.com/signin/";
    WebElement forgotPassword, email, send, verificationCode, newPassword1, newPassword2, resend, setPassword;
    WebDriver driver;

    @BeforeAll
    public void setup(){
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void setForgotPassword(){
        forgotPassword = driver.findElement(By.xpath("//p[contains(text(),'Forgot Password?')]"));
        forgotPassword.click();
        email = driver.findElement(By.id("email"));
        email.sendKeys("ramsample1@gmail.com");
        send = driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Send')]"));
        send.click();
//        verificationCode = driver.findElement(By.xpath("Path to input"));
//        verificationCode.sendKeys("123456");
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Set Password')]")));
        newPassword1 = driver.findElement(By.id("password"));
        newPassword1.sendKeys("Test@123");
        newPassword2 = driver.findElement(By.id("confirmPassword"));
        newPassword2.sendKeys("Test@123");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        resend = driver.findElement(By.xpath("//span[contains(text(),'Resend')]"));
        resend.click();
        setPassword = driver.findElement(By.xpath("//button[contains(text(),'Set Password')]"));
        setPassword.click();
    }
//    @AfterAll
    public void teardown() throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }
}