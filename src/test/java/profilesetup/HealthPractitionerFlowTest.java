package profilesetup;

import org.openqa.selenium.*;

import java.time.Duration;

public class HealthPractitionerFlowTest {
    String URL = "https://dev-app-fhb.quartustech.com/profile-setup";
    WebElement practitioner, next, selectExpertise, businessName, contactNumber, businessAddress, lastElement, businessDescription, facebook_url, linkedin_url, youtube_url, instagram_url, twitter_url, addTags;
    WebElement serviceTitle, serviceDescription, selectCategory, selectTopic, access, tagline, physical, massage;
    public void healthPractitioner_Flow(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);

        String script = "arguments[0].scrollIntoView();";
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        practitioner = driver.findElement(By.xpath("//*[contains(text(),'I am a health practitioner/specialist')]"));
        practitioner.click();

        Thread.sleep(3000);
        selectExpertise = driver.findElement(By.xpath("//*[contains(text(), 'Medical Doctor')]"));
        selectExpertise.click();
        Thread.sleep(2000);

        Thread.sleep(2000);
        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();


        Thread.sleep(1000);
        businessName = driver.findElement(By.id("businessName"));
        businessName.sendKeys("Test");
        tagline = driver.findElement(By.id("tagLine"));
        tagline.sendKeys("This is a test tagline.");
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
        addTags.sendKeys("#Test", Keys.ENTER);

//        addImage
        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

//        Add social links

        facebook_url = driver.findElement(By.id("facebookURL"));
        facebook_url.sendKeys("https://www.facebook.com/Randall");
        linkedin_url = driver.findElement(By.id("linkedInURL"));
        linkedin_url.sendKeys("https://www.linkedin.com/Randall");
        youtube_url = driver.findElement(By.id("youtubeURL"));
        youtube_url.sendKeys("https://www.youtube.com/Randall");
        instagram_url = driver.findElement(By.id("instagramURL"));
        instagram_url.sendKeys("https://www.instagram.com/Randall");
        twitter_url = driver.findElement(By.id("xURL"));
        twitter_url.sendKeys("https://www.twitter.com/Randall");

//        driver.navigate().back();
//        Thread.sleep(2000);
//
//        driver.navigate().forward();
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
        Thread.sleep(2000);

//        addService = driver.findElement(By.xpath("//*[contains(text(), '+Add')]"));
//        addService.click();

//      Pick health category
        physical = driver.findElement(By.xpath("//*[contains(text(),'Physical')]"));
        physical.click();
        massage =  driver.findElement(By.xpath("//*[contains(text(),'Chiropractic or Massage')]"));
        massage.click();
//        Thread.sleep(2000);
        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

        Thread.sleep(3000);
        access = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/label/span/span[1]/input"));
        access.click();

        Thread.sleep(3000);
        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();
    }
}
