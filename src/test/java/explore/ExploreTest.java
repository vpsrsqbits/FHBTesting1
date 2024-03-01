package explore;

import org.frenbenhealth.Data;
import org.frenbenhealth.SignIn;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExploreTest {
    WebDriver driver;
    WebElement category, ellipses, not_Interested, block, follow, mute, report, switcher, clear_all, article, leaderboard, awardCategory, selectLeader, selectLocation;
    @BeforeAll
    public void setup() throws InterruptedException {
        SignIn signIn = new SignIn();
        driver = signIn.signIn(Data.userName);
        Thread.sleep(4000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://dev-app-fhb.quartustech.com/explore/");
    }
    @Test
    @Order(1)
    public void categories() throws InterruptedException {
        Thread.sleep(3000);
        category = driver.findElement(By.xpath("//*[contains(text(),'Lifestyle')]"));
        category.click();
        Thread.sleep(2000);

    }
    @Test
    @Order(2)
    public void post() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        ellipses = driver.findElement(By.id("icn_More"));
//        ellipses.click();
//        Thread.sleep(2000);
//        not_Interested = driver.findElement(By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']//li[1]"));
//        not_Interested.click();
//        Thread.sleep(2000);
//        not_Interested = driver.findElement(By.xpath("//*[contains(text(),'Mark Not Interested')]"));
//        not_Interested.click();
//        Thread.sleep(5000);
//        ellipses.click();
//        Thread.sleep(2000);
//        follow = driver.findElement(By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']//li[2]"));
//        follow.click();
//        Thread.sleep(2000);
//        ellipses.click();
//        mute = driver.findElement(By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']//li[3]"));
//        mute.click();
//        Thread.sleep(2000);
//        switcher = driver.findElement(By.xpath("/html/body/div[11]/div[3]/div/div[1]/form/div/div[1]/label[2]/span/span[1]/input"));
//        switcher.click();
//        Thread.sleep(1000);
//        switcher = driver.findElement(By.xpath("/html/body/div[11]/div[3]/div/div[1]/form/div/div[2]/label[2]/span/span[1]/input"));
//        switcher.click();
//        Thread.sleep(1000);
//        switcher = driver.findElement(By.xpath("/html/body/div[11]/div[3]/div/div[1]/form/div/div[3]/label[2]/span/span[1]/input"));
//        switcher.click();
//        Thread.sleep(1000);
//        switcher = driver.findElement(By.xpath("/html/body/div[11]/div[3]/div/div[1]/form/div/div[4]/label[2]/span/span[1]/input"));
//        switcher.click();
//        Thread.sleep(2000);
//        clear_all = driver.findElement(By.xpath("//h2[@id=':rd:']/p[2]"));
//        clear_all.click();
//        apply = driver.findElement(By.xpath(""));
//        apply.click();
//        Thread.sleep(2000);
//        ellipses.click();
//        block = driver.findElement(By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']//li[4]"));
//        block.click();
//        Thread.sleep(2000);
//        block = driver.findElement(By.xpath("//*[contains(text(),'Yes, Block User')]"));
//        block.click();
//        Thread.sleep(5000);
//        ellipses.click();
//        Thread.sleep(2000);
//        report = driver.findElement(By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']//li[5]"));
//        report.click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//*[contains(text(),'Harassment')]")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.id("detailedReason")).sendKeys("Test Reason");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("/html/body/div[9]/div[3]/div/div[2]/button")).click();
//        Thread.sleep(5000);

//      Implement post interaction.

        article = driver.findElement(By.xpath("//main/article[1]/div/img"));
        article.click();
        Thread.sleep(1000);
        driver.findElement(By.id(":rgk:")).sendKeys("Test Comment");
        Thread.sleep(1000);
        driver.findElement(By.id("ic_back_arrow_nav")).click();

    }
    @Test
    @Order(3)
    public void leaderboard() throws InterruptedException {

        leaderboard = driver.findElement(By.xpath("//a[@href='/explore/leaderboard/']"));
        leaderboard.click();
        awardCategory = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div/div[2]/div/div/main/div[1]/div[2]"));
        awardCategory.click();
        selectLocation = driver.findElement(By.id("icn_Location"));
        selectLocation.click();
        selectLeader = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div/div[2]/div/div/main/div[2]/div"));
        selectLeader.click();
        Thread.sleep(3000);
        driver.navigate().back();
    }

    @AfterAll
    public void teardown(){
        driver.quit();
    }
}
