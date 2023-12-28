import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SignUpPageTest {
    ChromeDriver driver;
    WebElement google, facebook, apple, fullName, email, userName, setPassword,  signUp, signIn;
    Faker faker = new Faker();

    String URL= "https://dev-app-fhb.quartustech.com/signup/", mail="ramsample1+2@gmail.com", pass="Test@123";
    int counter=0;

    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get(URL);

//        google = driver.findElement(By.id("ic_google"));
//        facebook = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div[2]/button"));
//        apple = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div[3]/button"));

//        fullName = driver.findElement(By.id("name"));
//        email = driver.findElement(By.id("email"));
//        userName = driver.findElement(By.id("username"));
//        setPassword = driver.findElement(By.id("password"));
//
//        signUp = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));

//        signIn = driver.findElement((By.linkText("Sign in")));
    }
//    @Test()
    @RepeatedTest(10)
    void test() throws InterruptedException {
        Thread.sleep(3000);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        fullName = driver.findElement(By.id("name"));
        email = driver.findElement(By.id("email"));
        userName = driver.findElement(By.id("username"));
        setPassword = driver.findElement(By.id("password"));

        signUp = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));

//        nameField.clear();

        fullName.sendKeys(faker.name().fullName());
        email.sendKeys(mail);
        userName.sendKeys(faker.name().username());
        setPassword.sendKeys(pass);

        signUp.click();

        Thread.sleep(4000);
        fullName = driver.findElement(By.id("name"));
        email = driver.findElement(By.id("email"));
        userName = driver.findElement(By.id("username"));
        setPassword = driver.findElement(By.id("password"));

//        signUp = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));


        fullName.sendKeys(Keys.CONTROL,"A",Keys.BACK_SPACE);
        email.sendKeys(Keys.CONTROL,"A",Keys.BACK_SPACE);
        userName.sendKeys(Keys.CONTROL,"A",Keys.BACK_SPACE);
        setPassword.sendKeys(Keys.CONTROL,"A",Keys.BACK_SPACE);

//        signIn.click();
    }
    @AfterAll
    void teardown(){

//        driver.quit();
    }
}
