package settings;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SettingsTest {
    WebDriver driver;
    WebElement feed_Preference, notification, help_Center, privacy_Policy, delete_Account, email, password, signIn, physical, exercise, save_Update, back,
            help_Title ,help_Description ,submit, settings, dont_Delete, logout, yes_Logout;

    @BeforeAll
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://dev-app-fhb.quartustech.com/");
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
        driver.get("https://dev-app-fhb.quartustech.com/settings/");
    }
    @Test
    @Order(1)
    public void feed_Preference() throws InterruptedException {
        feed_Preference = driver.findElement(By.xpath("//*[contains(text(),'Feed Preference')]"));
        feed_Preference.click();
        Thread.sleep(2000);
        physical = driver.findElement(By.xpath("//*[contains(text(),'Physical')]"));
        physical.click();
        Thread.sleep(2000);
        exercise = driver.findElement(By.xpath("//*[contains(text(),'Exercise')]"));
        exercise.click();
        Thread.sleep(2000);
        physical.click();
        save_Update = driver.findElement(By.xpath("//*[contains(text(),'Save & Update')]"));
        save_Update.click();
        Thread.sleep(1000);

        back = driver.findElement(By.id("ic_back_arrow_nav"));
        back.click();

    }
    @Test
    @Order(2)
    public void notification() throws InterruptedException {
        notification = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div/div[2]/div/div/main/div[1]/div[2]/div/label/span/span[1]/input"));
        Thread.sleep(1000);
        notification.click();
        Thread.sleep(1000);
        notification.click();
    }
    @Test
    @Order(3)
    public void help_Center() throws InterruptedException {
        Thread.sleep(1000);
        help_Center = driver.findElement(By.xpath("//*[contains(text(),'Help Center')]"));
        help_Center.click();
        Thread.sleep(1000);

        help_Title = driver.findElement(By.id("title"));
        help_Description = driver.findElement(By.id("description"));
        submit = driver.findElement(By.xpath("//*[contains(text(),'Submit')]"));
        help_Title.sendKeys("Test title");
        help_Description.sendKeys("Test Description");
        submit.click();
    }
    @Test
    @Order(4)
    public void privacy_Policy() throws InterruptedException {
        Thread.sleep(1000);

        settings = driver.findElement(By.xpath("//*[contains(text(),'Settings')]"));
        settings.click();
        Thread.sleep(1000);

        privacy_Policy = driver.findElement(By.xpath("//*[contains(text(),'Privacy Policy')]"));
        privacy_Policy.click();
    }
    @Test
    @Order(5)
    public void delete_Account() throws InterruptedException {
        Thread.sleep(1000);

        delete_Account = driver.findElement(By.xpath("//*[contains(text(),'Delete Account')]"));
        delete_Account.click();
        Thread.sleep(2000);

        dont_Delete = driver.findElement(By.xpath("//*[contains(text(),'No,')]"));
        dont_Delete.click();

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