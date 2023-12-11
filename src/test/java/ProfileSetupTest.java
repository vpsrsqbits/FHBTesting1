import org.openqa.selenium.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProfileSetupTest {
    WebDriver driver;
    WebElement seeking_Friends, health_Journey, yolo, practitioner, just_Browse, next, physical, lifestyle, massage, stretching, exercise, beauty, parenting, access, selectCategory, selectTopic, storyTitle, storyBody, addImage, selectExpertise, businessName, contactNumber, businessAddress, businessDescription, addTags, lastElement, facebook_url, linkedin_url, youtube_url, instagram_url, twitter_url, addService, serviceTitle, serviceDescription;
    String URL= "https://dev-app-fhb.quartustech.com/profile-setup";
    String script;
    WebDriverWait wait;
/*
    @BeforeAll
    void setup(){
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
*/
    @Test
    void seekingFriends_Flow(WebDriver d) throws InterruptedException {
        d.switchTo().newWindow(WindowType.TAB);
        d.get(URL);
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        seeking_Friends = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[1]"));
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));

        seeking_Friends.click();
        next.click();

//        physical = d.findElement(By.xpath("//*[contains(text(), 'Physical')]"));
//        physical.click();
//            massage = d.findElement(By.xpath("//*[contains(text(), 'Chiropractic or Massage')]"));
//            massage.click();
//            stretching = d.findElement(By.xpath("//*[contains(text(), 'Stretching')]"));
//            stretching.click();
//            exercise = d.findElement(By.xpath("//*[contains(text(), 'Exercise')]"));
//            exercise.click();
//        physical.click();

//        lifestyle = d.findElement(By.xpath("//*[contains(text(), 'Lifestyle')]"));
//        lifestyle.click();
//            beauty = d.findElement(By.xpath("//*[contains(text(), 'Beauty')]"));
//            beauty.click();
//            parenting = d.findElement(By.xpath("//*[contains(text(), 'Parenting')]"));
//            parenting.click();
//        lifestyle.click();

        Thread.sleep(5000);
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

        Thread.sleep(5000);
        access = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/label/span/span[1]/input"));
        access.click();
        Thread.sleep(5000);
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();
        // To Home
    }
    @Test
    void healthJourney_Flow(WebDriver d) throws InterruptedException {
        d.switchTo().newWindow(WindowType.TAB);
        d.get(URL);
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        health_Journey = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[2]"));
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));

        health_Journey.click();
        next.click();

        Thread.sleep(5000);
        selectCategory = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[1]/div[1]/div"));
        selectCategory.click();

        selectTopic = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[2]/div[1]/span[1]"));
        selectTopic.click();

        storyTitle = d.findElement(By.id("title"));
        storyTitle.sendKeys("Test");

        storyBody = d.findElement(By.id("description"));
        storyBody.sendKeys("Test description.");

//        addImage
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

        Thread.sleep(5000);
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

        Thread.sleep(5000);
        access = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/label/span/span[1]/input"));
        access.click();
        Thread.sleep(5000);
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();
        // To Home
    }
    @Test
    void yolo_Flow(WebDriver d) throws InterruptedException {
        d.switchTo().newWindow(WindowType.TAB);
        d.get(URL);
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        yolo = d.findElement(By.xpath("//*[contains(text(),'YOLO')]"));
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));

        yolo.click();
        next.click();
//  Handle this dropdown
//        physical = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[2]"));
//        physical.click();
//            massage = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[3]"));
//            massage.click();
//            stretching = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[4]"));
//            stretching.click();
//            exercise = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[5]"));
//            exercise.click();
//
//        lifestyle = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[6]"));
//        lifestyle.click();
//            beauty = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[7]"));
//            beauty.click();
//            parenting = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[8]"));
//            parenting.click();
        Thread.sleep(3000);
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

        Thread.sleep(3000);
        access = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/label/span/span[1]/input"));
        access.click();
        Thread.sleep(3000);
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

        //To Home
    }
    @Test
    void healthPractitioner_Flow(WebDriver d) throws InterruptedException {
        String script = "arguments[0].scrollIntoView();";
        d.switchTo().newWindow(WindowType.TAB);
        d.get(URL);
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        practitioner = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[4]"));
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));

        practitioner.click();
        next.click();

        Thread.sleep(3000);
        selectExpertise = d.findElement(By.xpath("//*[contains(text(), 'Medical Doctor')]"));
        selectExpertise.click();
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();


        Thread.sleep(1000);
        businessName = d.findElement(By.id("professionalProfile.businessName"));
        businessName.sendKeys("Test");
        contactNumber = d.findElement(By.id("professionalProfile.contactNumber"));
        contactNumber.sendKeys("1234567890");
        businessAddress = d.findElement(By.id("professionalProfile.address"));
        businessAddress.sendKeys("Test");

        lastElement = d.findElement(By.cssSelector("p:last-child"));

        JavascriptExecutor js = (JavascriptExecutor) d;
        js.executeScript(script, lastElement);

        businessDescription = d.findElement(By.id("professionalProfile.about"));
        businessDescription.sendKeys("Test");
        addTags = d.findElement(By.id("professionalProfile.tags"));
        addTags.sendKeys("#Test",Keys.ENTER);

//        addImage
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

//        Add social links

        facebook_url = d.findElement(By.id("professionalProfile.facebookUrl"));
        facebook_url.sendKeys("XXXXXXXXXXXXXXXXXXXXXXXXX");
        linkedin_url = d.findElement(By.id("professionalProfile.linkedInUrl"));
        linkedin_url.sendKeys("XXXXXXXXXXXXXXXXXXXXXXXXX");
        youtube_url = d.findElement(By.id("professionalProfile.youtubeUrl"));
        youtube_url.sendKeys("XXXXXXXXXXXXXXXXXXXXXXXXX");
        instagram_url = d.findElement(By.id("professionalProfile.instagramUrl"));
        instagram_url.sendKeys("XXXXXXXXXXXXXXXXXXXXXXXXX");
        twitter_url = d.findElement(By.id("professionalProfile.twitterUrl"));
        twitter_url.sendKeys("XXXXXXXXXXXXXXXXXXXXXXXXX");
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

//      Add Service

        addService = d.findElement(By.xpath("//*[contains(text(), '+Add')]"));
        addService.click();

        serviceTitle = d.findElement(By.id("professionalProfile.services[0].title"));
        serviceTitle.sendKeys("Test");
        serviceDescription = d.findElement(By.id("professionalProfile.services[0].description"));
        serviceDescription.sendKeys("Test");
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

//      Pick health category
        Thread.sleep(3000);
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

        Thread.sleep(3000);
        access = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/label/span/span[1]/input"));
        access.click();

        Thread.sleep(3000);
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

    }
    @Test
    void justBrowse_Flow(WebDriver d) throws InterruptedException {
        d.switchTo().newWindow(WindowType.TAB);
        d.get(URL);
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        just_Browse = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[5]/p"));
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));

        just_Browse.click();
        next.click();

//        physical = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[2]"));
//        physical.click();
//            massage = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[3]"));
//            massage.click();
//            stretching = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[4]"));
//            stretching.click();
//            exercise = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[5]"));
//            exercise.click();
//
//        lifestyle = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[6]"));
//        lifestyle.click();
//            beauty = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[7]"));
//            beauty.click();
//            parenting = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[8]"));
//            parenting.click();

        Thread.sleep(2000);
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

        Thread.sleep(2000);
        access = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/label/span/span[1]/input"));
        access.click();

        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();
        //To Home
    }

    @AfterAll
    void teardown(){
//    driver.quit();
    }
}
