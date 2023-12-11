import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SignUpPageTest {
    ChromeDriver driver;
    WebElement google, facebook, apple, fullName, email, userName, setPassword,  signUp, signIn;
    Faker faker = new Faker();

    String URL= "https://dev-app-fhb.quartustech.com/signup/", mail="ramsample1+1@gmail.com", pass="Test@123";
    int counter=0;

    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get(URL);

        google = driver.findElement(By.id("ic_google"));
        facebook = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div[2]/button"));
        apple = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div[3]/button"));

        fullName = driver.findElement(By.id("name"));
        email = driver.findElement(By.id("email"));
        userName = driver.findElement(By.id("username"));
        setPassword = driver.findElement(By.id("password"));

        signUp = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/form/div/button"));

        signIn = driver.findElement((By.linkText("Sign in")));
    }
    @Test()
    void test(){
        fullName.sendKeys(faker.name().fullName());
        email.sendKeys(mail);
        userName.sendKeys(faker.name().username());
        setPassword.sendKeys(pass);

        signUp.click();
        signIn.click();
    }
    @AfterAll
    void teardown(){

        driver.quit();
    }
}
