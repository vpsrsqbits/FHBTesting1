import net.datafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SignUpPageTest {
    ChromeDriver driver;
    WebElement google, facebook, apple, fullName, email, userName, setPassword,  signUp, signIn;
    Faker faker = new Faker();
    int i;

    String URL= "https://dev-app-fhb.quartustech.com/signup/", pass="Test@123";

    @BeforeAll
    void setup() throws InterruptedException{
        i=399;
        driver = new ChromeDriver();
        driver.get(URL);

        String currentWindow = driver.getWindowHandle();

//      Test Terms and Conditions.
        driver.findElement(By.xpath("//a[@href='https://dev-api-fhb.quartustech.com/fhb-terms-and-conditions']")).click();
/*
          new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("fhb-terms-and-conditions"));
          System.out.println(driver.getCurrentUrl());
*/
        System.out.println(driver.getTitle());
        driver.switchTo().window(currentWindow);

//      Test Privacy policy.
        driver.findElement(By.xpath("//a[@href='https://dev-api-fhb.quartustech.com/fhb-privacy-policy']")).click();
        driver.switchTo().window(currentWindow);
/*
        google = driver.findElement(By.id("ic_google"));
        facebook = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div[2]/button"));
        apple = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div[3]/button"));
        fullName = driver.findElement(By.id("name"));
        email = driver.findElement(By.id("email"));
        userName = driver.findElement(By.id("username"));
        setPassword = driver.findElement(By.id("password"));

        signUp = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));
        signIn = driver.findElement((By.linkText("Sign in")));
*/
    }

    @Test()
    void userSignUp() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        fullName = driver.findElement(By.id("name"));
        email = driver.findElement(By.id("email"));
        userName = driver.findElement(By.id("username"));
        setPassword = driver.findElement(By.id("password"));

        signUp = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));

        fullName.sendKeys(faker.name().fullName());
        i++;
        email.sendKeys("ramsample1+"+i+"@gmail.com");
        userName.sendKeys(faker.name().username());
        setPassword.sendKeys(pass);

        signUp.click();

/*
        Thread.sleep(4000);
        fullName = driver.findElement(By.id("name"));
        email = driver.findElement(By.id("email"));
        userName = driver.findElement(By.id("username"));
        setPassword = driver.findElement(By.id("password"));
        signUp = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));
        fullName.sendKeys(Keys.CONTROL,"A",Keys.BACK_SPACE);
        email.sendKeys(Keys.CONTROL,"A",Keys.BACK_SPACE);
        userName.sendKeys(Keys.CONTROL,"A",Keys.BACK_SPACE);
        setPassword.sendKeys(Keys.CONTROL,"A",Keys.BACK_SPACE);
        signIn.click();
*/
    }

//    @AfterAll
    void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
