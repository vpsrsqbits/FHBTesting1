package home;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TabSwitchTest {


    ChromeDriver driver;
    WebElement home, chats, yolo, explore, ai_Search, news_Feed, become_Sponsor, reference_Guide, about, settings, help_Center, logout, userProfile, myAccount;
//    Faker faker = new Faker();

    String URL = "https://dev-app-fhb.quartustech.com/";
    WebDriverWait wait;
/*
    int counter=0;
    @BeforeAll
    void setup() {
        driver = new ChromeDriver();
        driver.get(URL);

        home = driver.findElement(By.linkText("/"));
        chats = driver.findElement(By.linkText("chats"));
        yolo = driver.findElement(By.linkText("yolo"));
        explore = driver.findElement(By.linkText("explore"));
        ai_Search = driver.findElement(By.linkText("ai-search"));
        news_Feed = driver.findElement(By.linkText("news-feed"));
        become_Sponsor = driver.findElement(By.linkText("become-sponsor"));
        reference_Guide = driver.findElement(By.linkText("reference-guide"));
        about = driver.findElement(By.linkText("about"));
        settings = driver.findElement(By.linkText("settings"));
        help_Center = driver.findElement(By.linkText("help-center"));
        logout = driver.findElement(By.id("icn_Logout"));

    }
*/

//    @Test()
    public void test(WebDriver driver) throws InterruptedException {
//        driver.switchTo().newWindow(WindowType.TAB);
//        driver.get(URL);
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        home = driver.findElement(By.xpath("//*[contains(text(),'Home')]"));
//        home.click();
        //        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Beauty')]")));
        chats = driver.findElement(By.xpath("//*[contains(text(),'Chats')]"));
        chats.click();
        Thread.sleep(2000);
        yolo = driver.findElement(By.xpath("//*[contains(text(),'YOLO')]"));
        yolo.click();
        Thread.sleep(2000);
        explore = driver.findElement(By.xpath("//*[contains(text(),'Explore')]"));
        explore.click();
        Thread.sleep(1000);
        ai_Search = driver.findElement(By.xpath("//*[contains(text(),'AI Search')]"));
        ai_Search.click();
        Thread.sleep(2000);
        news_Feed = driver.findElement(By.xpath("//*[contains(text(),'News Feed')]"));
        news_Feed.click();
        Thread.sleep(1000);
        become_Sponsor = driver.findElement(By.xpath("//*[contains(text(),'Become A Sponsor')]"));
        become_Sponsor.click();
        Thread.sleep(1000);
        reference_Guide = driver.findElement(By.xpath("//*[contains(text(),'Reference Guide')]"));
        reference_Guide.click();
        Thread.sleep(1000);



        userProfile = driver.findElement(By.xpath("//main/div[2]/div/div[1]/div[2]/div/button[4]"));
        userProfile.click();
        Thread.sleep(1000);

        myAccount = driver.findElement(By.xpath("//div/ul/li/div/span/span[contains(text(),'My account')]"));
        myAccount.click();
        Thread.sleep(1000);

        userProfile = driver.findElement(By.xpath("//main/div[2]/div/div[1]/div[2]/div/button[4]"));
        userProfile.click();
        Thread.sleep(1000);

        settings = driver.findElement(By.xpath("//div/ul/li/div/span/span[contains(text(),'Settings')]"));
        settings.click();
        Thread.sleep(1000);

        userProfile = driver.findElement(By.xpath("//main/div[2]/div/div[1]/div[2]/div/button[4]"));
        userProfile.click();
        Thread.sleep(1000);

        logout = driver.findElement(By.xpath("//div/ul/li/div/span/span[contains(text(),'Logout')]"));
        logout.click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[contains(text(),'Yes, Log Out')]")).click();
        Thread.sleep(1000);
    }

//    @AfterAll
    void teardown() {
//        driver.quit();
    }
}

