package org.frenbenhealth;

import io.restassured.http.ContentType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignIn {

    public WebDriver driver;
    ChromeOptions options;

    WebElement continueAsGuest,forgotPassword,signUp,google,facebook,apple;

    public  WebDriver signIn(String userName) throws InterruptedException{
        driver= new ChromeDriver();
        driver.get(Data.webAppBaseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().minimize();
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(userName);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(Data.password);
        driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
//        assertNotNull(new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Sign-in is successful. Welcome back')]"))),"Sign-In not successful.");
        return driver;
    }
}