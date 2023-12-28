package org.frenbenhealth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SignIn {
    WebDriver driver;
    WebElement email, password, signIn, continueAsGuest, forgotPassword, signUp, google, facebook, apple;
    String URL= "https://dev-app-fhb.quartustech.com/";

    public void signIn(){
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        email = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        signIn = driver.findElement(By.xpath("//button[contains(text(),'Sign In')]"));
    }

}
