package org.frenbenhealth;

import io.restassured.http.ContentType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class SignIn {

    public WebDriver driver;
    final private String authToken = "Bearer eyJraWQiOiJLZzNLdG02MWxyRVJVZFU3ZDhGMHZYekZIRGJROTh3VVwvT0UrVzFUSThSWT0iLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiI4YTgxNzQwNy02MDEwLTRlMzAtOGRiYy1kYmE3ZTEwOTQ0ZjciLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLnVzLWVhc3QtMS5hbWF6b25hd3MuY29tXC91cy1lYXN0LTFfS2FJODV3amx6IiwiY29nbml0bzp1c2VybmFtZSI6InJhbmRhbGwuaGVuIiwib3JpZ2luX2p0aSI6ImE3M2UwZDQ3LTlhNGYtNDRmOS1iYjU5LWRhMmRjMWRlOWE5YiIsImF1ZCI6IjQ3bG9mNjBhcWRxNXZvZnRibzVjYTY1ZDFnIiwiZXZlbnRfaWQiOiI1YmFhMWQ3My02NjFlLTRiYmItOTc0Ny0zOTY2ZDNiZjk1YjciLCJ0b2tlbl91c2UiOiJpZCIsImF1dGhfdGltZSI6MTcwNzIxMzQwNCwibmFtZSI6IkNocmlzIiwiZXhwIjoxNzA3Mjk5ODA0LCJpYXQiOjE3MDcyMTM0MDQsImp0aSI6IjVkNTAwYmRlLTQzYTktNGQyNy1iNTg4LTNhYjZkMDNlMjhmNSIsImVtYWlsIjoicmFtc2FtcGxlMUBnbWFpbC5jb20ifQ.PBpOecE87jVeOENAorV4-f8f8ev9W-YRdQD7qsDBnlXeYFV1Rq66fxT_ZYiSLnSGIn5zhxNPvyPQpA_DE0DHTDqBAguY6P0Ru7UJF-CBv6fES7isWowbb5a7NkIxpfASEIaTog7TDKf9ioJslzn051-Ll9M9J_0AKP3xodUNuUye5EKAQIqc7anxJ5T4zFGl3XULuMOHrgUXaZ_y14PKN9heP6v25771xj0bPRXZBVJu37Mu6h3iLwlCosTZyDBLoilYTOOaMlTtDz07G0cmBE8HAQk0wMkx1aFivvm1v4t2YPeLXHitqsSbW7OnoHynFRQGR039ol_f7NX4tKmygg";
    static private String userName = "randall.hen";
    static private String password = "Test@1234";
    WebElement continueAsGuest,forgotPassword,signUp,google,facebook,apple;
     String URL= "https://dev-app-fhb.quartustech.com/";

    public  WebDriver signIn() throws InterruptedException{
        driver= new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(userName);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
        return driver;
    }
    public void invalidateOnboarding(){
        given().log().body()
                .contentType(ContentType.JSON)
                .header("Authorization", authToken)
                .body("{\n" +
                        "    \"isOnboardingCompleted\":false\n" +
                        "}")
                .when()
                .patch("https://dev-api-fhb.quartustech.com/v1/users/update")
                .then().log().all();
    }

//    public static void main(String[] args) {
//        signIn();
//    }

}