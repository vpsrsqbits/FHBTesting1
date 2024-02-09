package profilesetup;

import net.datafaker.Faker;
import org.openqa.selenium.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Random;
import java.util.stream.IntStream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    public class ProfileSetupTest {

    Faker faker = new Faker();
    WebDriver driver;
    WebElement seeking_Friends, health_Journey, yolo, practitioner, just_Browse, next, physical, lifestyle, massage, stretching, exercise, beauty, parenting, access, selectCategory, selectTopic, storyTitle, storyBody, addImage, selectExpertise, businessName, contactNumber, businessAddress, businessDescription, addTags, lastElement, facebook_url, linkedin_url, youtube_url, instagram_url, twitter_url, addService, serviceTitle, serviceDescription;
    String URL= "https://dev-app-fhb.quartustech.com/profile-setup";
    String script;
    WebDriverWait wait;
    public void seekingFriends_Flow(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        seeking_Friends = driver.findElement(By.xpath("//span[contains(text(),'myhealthysocial')]"));

        seeking_Friends.click();

        physical = driver.findElement(By.xpath("//*[contains(text(), 'Physical')]"));
        physical.click();
        Thread.sleep(3000);

            massage = driver.findElement(By.xpath("//*[contains(text(), 'Chiropractic or Massage')]"));
            massage.click();

/*
            stretching = driver.findElement(By.xpath("//*[contains(text(), 'Stretching')]"));
            stretching.click();
            exercise = driver.findElement(By.xpath("//*[contains(text(), 'Exercise')]"));
            exercise.click();
        physical.click();
        lifestyle = driver.findElement(By.xpath("//*[contains(text(), 'Lifestyle')]"));
        lifestyle.click();
            beauty = driver.findElement(By.xpath("//*[contains(text(), 'Beauty')]"));
            beauty.click();
            parenting = driver.findElement(By.xpath("//*[contains(text(), 'Parenting')]"));
            parenting.click();
        lifestyle.click();
*/

        Thread.sleep(3000);
        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

        Thread.sleep(3000);
        access = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/label/span/span[1]/input"));
        access.click();
        Thread.sleep(3000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);

        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();
        // To Home
    }
    public void healthJourney_Flow(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        health_Journey = driver.findElement(By.xpath("//*[contains(text(), 'I have a health journey story')]"));

        health_Journey.click();
//----------------------------------------------------------------------------------------------------------------------
        Thread.sleep(3000);
        selectCategory = driver.findElement(By.xpath("//*[contains(text(), 'Physical')]"));
        selectCategory.click();

        selectTopic = driver.findElement(By.xpath("//*[contains(text(), 'Chiropractic or Massage')]"));
        selectTopic.click();

        storyTitle = driver.findElement(By.id("title"));
        storyTitle.sendKeys("My journey towards healthy lifestyle");

        storyBody = driver.findElement(By.id("description"));
        storyBody.sendKeys("Gave an hour of a day for three months and it enhanced my stamina and strength.");

//      addImage
        addImage = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[4]/div/input"));

        IntStream.range(0, 4)
                .forEach(index -> {
//                                addImage.sendKeys("/home/squarebits/Desktop/Test data/Test Images/Test Post Images/nature/image" + (faker.number().numberBetween(1, 50)) + ".jpg");

                            if(index == 0) {
                                addImage.sendKeys("/home/squarebits/Desktop/Test data/Test Images/Test Post Images/nature/image" + (faker.number().numberBetween(1, 50)) + ".jpg");
                            }
                            else {
//                                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//                                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/div/div/div[4]/div/div[last()]")));
                                driver.findElement(By.xpath("//form/div/div/div[4]/div/div[last()]/input")).sendKeys("/home/squarebits/Desktop/Test data/Test Images/Test Post Images/nature/image" + (faker.number().numberBetween(1, 50)) + ".jpg");
                            }
                            try {
                                Thread.sleep(3000);
                                driver.findElement(By.id("crop-done")).click();
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        });
//        addImage.sendKeys("/home/squarebits/Desktop/Test data/Test Images/Test Post Images/nature/image13.jpg");
//        driver.navigate().back();
//        Thread.sleep(2000);
//        driver.navigate().forward();
        Thread.sleep(2000);
        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();
//----------------------------------------------------------------------------------------------------------------------
        Thread.sleep(3000);

        physical = driver.findElement(By.xpath("//*[contains(text(), 'Physical')]"));
        physical.click();
        Thread.sleep(3000);

        massage = driver.findElement(By.xpath("//*[contains(text(), 'Chiropractic or Massage')]"));
        massage.click();

        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

        Thread.sleep(3000);
        access = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/label/span/span[1]/input"));
        access.click();
        Thread.sleep(3000);

//    driver.navigate().back();
//    Thread.sleep(2000);
//
//    driver.navigate().forward();
//    Thread.sleep(2000);

        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();
        // To Home
    }

    public void yolo_Flow(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        yolo = driver.findElement(By.xpath("//*[contains(text(),'YOLO')]"));
        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));

        yolo.click();
        next.click();
//  Handle this dropdown

        physical = driver.findElement(By.xpath("//*[contains(text(), 'Physical')]"));
        physical.click();
        Thread.sleep(3000);

        massage = driver.findElement(By.xpath("//*[contains(text(), 'Chiropractic or Massage')]"));
        massage.click();

/*
            stretching = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[4]"));
            stretching.click();
            exercise = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[5]"));
            exercise.click();

        lifestyle = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[6]"));
        lifestyle.click();
            beauty = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[7]"));
            beauty.click();
            parenting = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[8]"));
            parenting.click();
*/
    Thread.sleep(3000);

    driver.navigate().back();
    Thread.sleep(2000);

    driver.navigate().forward();
    Thread.sleep(2000);

        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

        Thread.sleep(3000);
        access = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/label/span/span[1]/input"));
        access.click();
        Thread.sleep(3000);

    driver.navigate().back();
    Thread.sleep(2000);

    driver.navigate().forward();
    Thread.sleep(2000);

        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

        //To Home
    }
    public void healthPractitioner_Flow(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);

        String script = "arguments[0].scrollIntoView();";
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        practitioner = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[4]"));
        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));

        practitioner.click();
        next.click();

        Thread.sleep(3000);
        selectExpertise = driver.findElement(By.xpath("//*[contains(text(), 'Medical Doctor')]"));
        selectExpertise.click();
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);

        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();


        Thread.sleep(1000);
        businessName = driver.findElement(By.id("businessName"));
        businessName.sendKeys("Test");
        contactNumber = driver.findElement(By.id("contactNumber"));
        contactNumber.sendKeys("1234567890");
        businessAddress = driver.findElement(By.id("address"));
        businessAddress.sendKeys("Test");

        lastElement = driver.findElement(By.cssSelector("p:last-child"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, lastElement);

        businessDescription = driver.findElement(By.id("aboutYourself"));
        businessDescription.sendKeys("Test");
        addTags = driver.findElement(By.id("tags"));
        addTags.sendKeys("#Test",Keys.ENTER);

//        addImage
        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

//        Add social links

        facebook_url = driver.findElement(By.id("facebookURL"));
        facebook_url.sendKeys("https://www.facebook.com/Randell");
        linkedin_url = driver.findElement(By.id("linkedInURL"));
        linkedin_url.sendKeys("https://www.linkedin.com/Randell");
        youtube_url = driver.findElement(By.id("youtubeURL"));
        youtube_url.sendKeys("https://www.youtube.com/Randell");
        instagram_url = driver.findElement(By.id("instagramURL"));
        instagram_url.sendKeys("https://www.instagram.com/Randell");
        twitter_url = driver.findElement(By.id("xURL"));
        twitter_url.sendKeys("https://www.twitter.com/Randell");

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);

        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

//      Add Service

        Thread.sleep(3000);

        serviceTitle = driver.findElement(By.id("services[0].title"));
        serviceDescription = driver.findElement(By.id("services[0].aboutYourService"));
        selectCategory = driver.findElement(By.xpath("//*[contains(text(), 'Physical')]"));
        selectTopic = driver.findElement(By.xpath("//*[contains(text(), 'Chiropractic or Massage')]"));
        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        serviceTitle.sendKeys("Test");
        serviceDescription.sendKeys("Test");
        selectCategory.click();
        selectTopic.click();
        next.click();

//        addService = driver.findElement(By.xpath("//*[contains(text(), '+Add')]"));
//        addService.click();

//      Pick health category
        Thread.sleep(3000);
        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

        Thread.sleep(3000);
        access = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/label/span/span[1]/input"));
        access.click();

        Thread.sleep(3000);
        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();
    }
    public void justBrowse_Flow(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        just_Browse = driver.findElement(By.xpath("//*[contains(text(),'Just Browse Conversations')]"));
        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));

        just_Browse.click();
        next.click();
        Thread.sleep(3000);

        physical = driver.findElement(By.xpath("//*[contains(text(),'Physical')]"));
        selectTopic = driver.findElement(By.xpath("//*[contains(text(), 'Chiropractic or Massage')]"));
        physical.click();
        selectTopic.click();
        Thread.sleep(3000);

/*
            massage = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[3]"));
            massage.click();
            stretching = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[4]"));
            stretching.click();
            exercise = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[5]"));
            exercise.click();

        lifestyle = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[6]"));
        lifestyle.click();
            beauty = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[7]"));
            beauty.click();
            parenting = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/form/div/div/div[8]"));
            parenting.click();
*/

        Thread.sleep(2000);
        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

        Thread.sleep(2000);
        access = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/label/span/span[1]/input"));
        access.click();
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);
        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();
        //To Home
    }
}