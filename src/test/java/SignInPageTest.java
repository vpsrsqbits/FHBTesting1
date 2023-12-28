import home.TabSwitchTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;
import profilesetup.ProfileSetupTest;

import java.time.Duration;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SignInPageTest {
WebDriver driver;
WebElement email, password, signIn, continueAsGuest, forgotPassword, signUp, google, facebook, apple;
String URL= "https://dev-app-fhb.quartustech.com/";
@BeforeAll
    void setup(){
    driver = new ChromeDriver();
    driver.get(URL);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    email = driver.findElement(By.xpath("//*[@id=\"username\"]"));
    password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
    signIn = driver.findElement(By.xpath("//button[contains(text(),'Sign In')]"));
/*
    signUp = driver.findElement(By.xpath(""));
    continueAsGuest = driver.findElement(By.xpath(""));
    forgotPassword = driver.findElement(By.xpath(""));
    google = driver.findElement(By.xpath(""));
    facebook = driver.findElement(By.xpath(""));
    apple = driver.findElement(By.xpath(""));
*/

}
//    @Test
//    @Order(1)
    void signIn1(){
    driver.manage().window().maximize();
    email.sendKeys("randall.hen");
    password.sendKeys("Ram@1234");
    signIn.click();
    }
//    @Test
//    @Order(2)
    void seekingFriends() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        new ProfileSetupTest().seekingFriends_Flow(driver);
        new TabSwitchTest().test(driver);
        driver.quit();
    }
//    @Test
//    @Order(3)
    void signIn2(){
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        email = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        signIn = driver.findElement(By.xpath("//button[contains(text(),'Sign In')]"));

        driver.manage().window().maximize();
        email.sendKeys("randall.hen");
        password.sendKeys("Ram@1234");
        signIn.click();
    }
//    @Test
//    @Order(4)
    void healthJourney() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        new ProfileSetupTest().healthJourney_Flow(driver);
        new TabSwitchTest().test(driver);
        driver.quit();
    }
//    @Test
//    @Order(5)
    void signIn3(){
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        email = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        signIn = driver.findElement(By.xpath("//button[contains(text(),'Sign In')]"));

        driver.manage().window().maximize();
        email.sendKeys("randall.hen");
        password.sendKeys("Ram@1234");
        signIn.click();
    }

//    @Test
//    @Order(6)
    void yolo() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        new ProfileSetupTest().yolo_Flow(driver);
        new TabSwitchTest().test(driver);
    }
    @Test
    @Order(7)
    void signIn4(){
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        email = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        signIn = driver.findElement(By.xpath("//button[contains(text(),'Sign In')]"));

        driver.manage().window().maximize();
        email.sendKeys("randall.hen");
        password.sendKeys("Ram@1234");
        signIn.click();
    }


    @Test
    @Order(8)
    void healthPractitioner() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        new ProfileSetupTest().healthPractitioner_Flow(driver);
        new TabSwitchTest().test(driver);
    }

    @Test
    @Order(9)
    void signIn5(){
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        email = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        signIn = driver.findElement(By.xpath("//button[contains(text(),'Sign In')]"));

        driver.manage().window().maximize();
        email.sendKeys("randall.hen");
        password.sendKeys("Ram@1234");
        signIn.click();
    }
    @Test
    @Order(10)
    void justBrowse() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        new ProfileSetupTest().justBrowse_Flow(driver);
        new TabSwitchTest().test(driver);
    }

//    @Test
//    @Order(7)
//    void homePage() throws InterruptedException {
//        new home.TabSwitchTest().test(driver);
//    }

@AfterAll
    void teardown(){
    driver.quit();
}
}
