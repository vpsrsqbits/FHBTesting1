package yolo;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class YOLOTest {
    WebElement email,password,signIn,offers,events,practitioners,first_Offer,first_Event,first_Practitioner,lastElement;
    WebDriver driver;
    JavascriptExecutor js;
    String script = "arguments[0].scrollIntoView();";
    @BeforeAll
    void setup() throws InterruptedException {
        driver = new ChromeDriver();
         js = (JavascriptExecutor) driver;
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
    @BeforeEach
    public void yolo() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(text(),'YOLO')]")).click();
        Thread.sleep(3000);
    }
    @Test
    @Order(1)
    public void offers() throws InterruptedException {
        offers = driver.findElement(By.xpath("//*[contains(text(),'Offers')]"));
        offers.click();
        Thread.sleep(3000);
        first_Offer = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div/div[2]/div/div/main/div/div[2]/div[1]"));
        first_Offer.click();
        lastElement = driver.findElement(By.cssSelector(".MuiTypography-root.MuiTypography-body2.css-nyxw2y"));
        Thread.sleep(3000);
        js.executeScript(script,lastElement);
    }
    @Test
    @Order(2)
    public void events() throws InterruptedException {
        events = driver.findElement(By.xpath("//*[contains(text(),'Events')]"));
        events.click();
        Thread.sleep(3000);
        first_Event = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div/div[2]/div/div/main/div/div[2]/div[1]"));
        first_Event.click();
        Thread.sleep(3000);
        js.executeScript(script,driver.findElement(By.cssSelector(".MuiTypography-root.MuiTypography-body2.css-nyxw2y")));
    }
    @Test
    @Order(3)
    public void practitioners() throws InterruptedException {
        practitioners = driver.findElement(By.xpath("//*[contains(text(),'Practitioners')]"));
        practitioners.click();
        Thread.sleep(3000);
        first_Practitioner = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div/div[2]/div/div/main/div/ul/li[1]/div[2]/button"));
        first_Practitioner.click();
        Thread.sleep(3000);
//        js.executeScript(script,driver.findElement(By.cssSelector(".MuiTypography-root.MuiTypography-body2.css-nyxw2y")));

    }
    @AfterAll
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}






















