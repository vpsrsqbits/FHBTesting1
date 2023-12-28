package profilesetup;

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
public void seekingFriends_Flow(WebDriver d) throws InterruptedException {
        d.switchTo().newWindow(WindowType.TAB);
        d.get(URL);
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        seeking_Friends = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[1]"));
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));

        seeking_Friends.click();
        next.click();

        physical = d.findElement(By.xpath("//*[contains(text(), 'Physical')]"));
        physical.click();
        Thread.sleep(3000);

            massage = d.findElement(By.xpath("//*[contains(text(), 'Chiropractic or Massage')]"));
            massage.click();

/*
            stretching = d.findElement(By.xpath("//*[contains(text(), 'Stretching')]"));
            stretching.click();
            exercise = d.findElement(By.xpath("//*[contains(text(), 'Exercise')]"));
            exercise.click();
        physical.click();
        lifestyle = d.findElement(By.xpath("//*[contains(text(), 'Lifestyle')]"));
        lifestyle.click();
            beauty = d.findElement(By.xpath("//*[contains(text(), 'Beauty')]"));
            beauty.click();
            parenting = d.findElement(By.xpath("//*[contains(text(), 'Parenting')]"));
            parenting.click();
        lifestyle.click();
*/

    Thread.sleep(3000);
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

        Thread.sleep(3000);
        access = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/label/span/span[1]/input"));
        access.click();
        Thread.sleep(3000);
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();
        // To Home
    }
public void healthJourney_Flow(WebDriver d) throws InterruptedException {
        d.switchTo().newWindow(WindowType.TAB);
        d.get(URL);
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        health_Journey = d.findElement(By.xpath("//*[contains(text(), 'I have a health journey story')]"));
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));

        health_Journey.click();
        next.click();

        Thread.sleep(3000);
        selectCategory = d.findElement(By.xpath("//*[contains(text(), 'Physical')]"));
        selectCategory.click();

        selectTopic = d.findElement(By.xpath("//*[contains(text(), 'Chiropractic or Massage')]"));
        selectTopic.click();

        storyTitle = d.findElement(By.id("title"));
        storyTitle.sendKeys("My journey towards healthy lifestyle");

        storyBody = d.findElement(By.id("description"));
        storyBody.sendKeys("Gave an hour of a day for three months and it enhanced my stamina and strength.");

//        addImage
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

        Thread.sleep(3000);

        physical = d.findElement(By.xpath("//*[contains(text(), 'Physical')]"));
        physical.click();
        Thread.sleep(3000);

        massage = d.findElement(By.xpath("//*[contains(text(), 'Chiropractic or Massage')]"));
        massage.click();

        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

        Thread.sleep(3000);
        access = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/label/span/span[1]/input"));
        access.click();
        Thread.sleep(3000);
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();
        // To Home
    }
public void yolo_Flow(WebDriver d) throws InterruptedException {
        d.switchTo().newWindow(WindowType.TAB);
        d.get(URL);
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        yolo = d.findElement(By.xpath("//*[contains(text(),'YOLO')]"));
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));

        yolo.click();
        next.click();
//  Handle this dropdown

        physical = d.findElement(By.xpath("//*[contains(text(), 'Physical')]"));
        physical.click();
        Thread.sleep(3000);

        massage = d.findElement(By.xpath("//*[contains(text(), 'Chiropractic or Massage')]"));
        massage.click();

/*
            stretching = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[4]"));
            stretching.click();
            exercise = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[5]"));
            exercise.click();

        lifestyle = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[6]"));
        lifestyle.click();
            beauty = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[7]"));
            beauty.click();
            parenting = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[8]"));
            parenting.click();
*/
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
    public void healthPractitioner_Flow(WebDriver d) throws InterruptedException {
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
        businessName = d.findElement(By.id("businessName"));
        businessName.sendKeys("Test");
        contactNumber = d.findElement(By.id("contactNumber"));
        contactNumber.sendKeys("1234567890");
        businessAddress = d.findElement(By.id("address"));
        businessAddress.sendKeys("Test");

        lastElement = d.findElement(By.cssSelector("p:last-child"));

        JavascriptExecutor js = (JavascriptExecutor) d;
        js.executeScript(script, lastElement);

        businessDescription = d.findElement(By.id("aboutYourself"));
        businessDescription.sendKeys("Test");
        addTags = d.findElement(By.id("tags"));
        addTags.sendKeys("#Test",Keys.ENTER);

//        addImage
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

//        Add social links

        facebook_url = d.findElement(By.id("facebookURL"));
        facebook_url.sendKeys("https://www.facebook.com/Randell");
        linkedin_url = d.findElement(By.id("linkedInURL"));
        linkedin_url.sendKeys("https://www.linkedin.com/Randell");
        youtube_url = d.findElement(By.id("youtubeURL"));
        youtube_url.sendKeys("https://www.youtube.com/Randell");
        instagram_url = d.findElement(By.id("instagramURL"));
        instagram_url.sendKeys("https://www.instagram.com/Randell");
        twitter_url = d.findElement(By.id("xURL"));
        twitter_url.sendKeys("https://www.twitter.com/Randell");
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

//      Add Service

        Thread.sleep(3000);

        serviceTitle = d.findElement(By.id("services[0].title"));
        serviceDescription = d.findElement(By.id("services[0].aboutYourService"));
        selectCategory = d.findElement(By.xpath("//*[contains(text(), 'Physical')]"));
        selectTopic = d.findElement(By.xpath("//*[contains(text(), 'Chiropractic or Massage')]"));
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        serviceTitle.sendKeys("Test");
        serviceDescription.sendKeys("Test");
        selectCategory.click();
        selectTopic.click();
        next.click();

//        addService = d.findElement(By.xpath("//*[contains(text(), '+Add')]"));
//        addService.click();

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

    public void justBrowse_Flow(WebDriver d) throws InterruptedException {
        d.switchTo().newWindow(WindowType.TAB);
        d.get(URL);
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        just_Browse = d.findElement(By.xpath("//*[contains(text(),'Just Browse Conversations')]"));
        next = d.findElement(By.xpath("//*[contains(text(), 'Next')]"));

        just_Browse.click();
        next.click();
        Thread.sleep(3000);

        physical = d.findElement(By.xpath("//*[contains(text(),'Physical')]"));
        selectTopic = d.findElement(By.xpath("//*[contains(text(), 'Chiropractic or Massage')]"));
        physical.click();
        selectTopic.click();
        Thread.sleep(3000);

/*
            massage = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[3]"));
            massage.click();
            stretching = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[4]"));
            stretching.click();
            exercise = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[5]"));
            exercise.click();

        lifestyle = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[6]"));
        lifestyle.click();
            beauty = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[7]"));
            beauty.click();
            parenting = d.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[8]"));
            parenting.click();
*/

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
}
