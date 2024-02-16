import net.datafaker.Faker;
import org.frenbenhealth.UserIncrement;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SignUpPageTest {
    ChromeDriver driver;
    WebElement fullName, email, userName, setPassword, signUp;
    Faker faker = new Faker();
    UserIncrement userIncrement = new UserIncrement();
    int i;
    String URL= "https://dev-app-fhb.quartustech.com/signup/", pass="Test@123";

    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
    }

    @Test
    void userSignUp() throws IOException {


        // Read the integer from the file
        int num = userIncrement.readFromFile(userIncrement.filePath);

        driver.get(URL);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        fullName = driver.findElement(By.id("name"));
        fullName.sendKeys(faker.name().fullName());

        email = driver.findElement(By.id("email"));
        i++;
        email.sendKeys("ramsample1+"+num+"@gmail.com");

        userName = driver.findElement(By.id("username"));
        userName.sendKeys(faker.name().username());

        setPassword = driver.findElement(By.id("password"));
        setPassword.sendKeys(pass);

        signUp = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));
        signUp.click();

        // Increment the number
        num++;

        // Write the updated number back to the file
        userIncrement.writeToFile(userIncrement.filePath, num);
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

    //      Test for Terms and Conditions.
//    @Test
    @Order(1)
    void terms_and_conditions() {

        driver.get("https://dev-api-fhb.quartustech.com/fhb-terms-and-conditions");

//      Waiting for expected URL.
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("fhb-terms-and-conditions"));

//      Getting page's source.
        String pageSource = driver.getPageSource();

//      Checking for heading "Terms and service" in the page's source.
        assertTrue(pageSource.contains("Terms of service"),"'Terms of service' not found.");

//      Checking for page's title to be "FrenBen".
        assertEquals("FrenBen",driver.getTitle(), "Page title is different.");
    }

//      Test for Privacy policy.
//    @Test
    @Order(2)
    void privacy_Policy() {

        driver.get("https://dev-api-fhb.quartustech.com/fhb-privacy-policy");

//      Waiting for expected URL.
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("fhb-privacy-policy"));

//      Getting page's source.
        String pageSource = driver.getPageSource();

//      Checking for heading "Terms and service" in the page's source.
        assertTrue(pageSource.contains("Privacy Policy"),"'Privacy Policy' not found.");

//      Checking for page's title to be "FrenBen".
        assertEquals("FrenBen",driver.getTitle(), "Page title is different.");
    }


//    @AfterAll
    void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}