package org.frenbenhealth;

import io.restassured.http.ContentType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class SignIn {

    public WebDriver driver;

    WebElement continueAsGuest,forgotPassword,signUp,google,facebook,apple;

    public  WebDriver signIn() throws InterruptedException{
        driver= new ChromeDriver();
        driver.get(Data.webAppUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(Data.userName);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(Data.password);
        driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Sign-in is successful. Welcome back')]")));
        return driver;
    }
    public void invalidateOnboarding(){
        given().log().body()
                .contentType(ContentType.JSON)
                .header("Authorization", Data.authToken)
                .body("{\n" +
                        "    \"isOnboardingCompleted\":false\n" +
                        "}")
                .when()
                .patch("https://dev-api-fhb.quartustech.com/v1/users/update")
                .then().log().all();
    }

}