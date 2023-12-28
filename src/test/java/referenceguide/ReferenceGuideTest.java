package referenceguide;

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
public class ReferenceGuideTest {
    WebElement email,password,signIn,yes_Logout,logout,reference,add_Reference,select_Category,select_Topic,apply,title,link,reference_Category,select_Reference_Category;
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
    void referenceGuide() throws InterruptedException {
        reference = driver.findElement(By.xpath("//*[contains(text(),'Reference Guide')]"));
        reference.click();
        Thread.sleep(1000);
        select_Category = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div/div[2]/div/div/main/div/div[1]/span"));
        select_Category.click();
        Thread.sleep(3000);
        select_Topic = driver.findElement(By.xpath("//*[contains(text(),'Diets')]"));
        select_Topic.click();
        Thread.sleep(1000);
        apply = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/button"));
        apply.click();
        Thread.sleep(2000);
        add_Reference = driver.findElement(By.xpath("//*[contains(text(),'Add Reference')]"));
        add_Reference.click();
        Thread.sleep(2000);
        title = driver.findElement(By.id("title"));
        title.sendKeys("Test title");
        Thread.sleep(2000);
        link = driver.findElement(By.id("link"));
        link.sendKeys("testlink.com");
        Thread.sleep(2000);
        reference_Category = driver.findElement(By.id("select-category"));
        reference_Category.click();
        Thread.sleep(2000);
        select_Reference_Category = driver.findElement(By.xpath("//*[@id=\":rr5:\"]/li[2]"));
        select_Reference_Category.click();
        Thread.sleep(2000);
        add_Reference = driver.findElement(By.xpath("//*[contains(text(),'Add Reference')]"));
        add_Reference.click();
    }
    @AfterAll
    public void teardown() throws InterruptedException {
        logout = driver.findElement(By.xpath("//*[contains(text(),'Log Out')]"));
        logout.click();
        Thread.sleep(2000);
        yes_Logout = driver.findElement(By.xpath("//*[contains(text(),'Yes, Log Out')]"));
        yes_Logout.click();
        Thread.sleep(2000);
        driver.quit();
    }
}
