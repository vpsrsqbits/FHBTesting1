package profilesetup;

import net.datafaker.Faker;
import org.openqa.selenium.*;
import java.time.Duration;

public class HealthPractitioner {
    Faker faker = new Faker();
    String URL = "https://dev-app-fhb.quartustech.com/profile-setup";
    WebElement practitioner, next, selectExpertise, businessName, contactNumber, businessAddress, lastElement, businessDescription, business_url, facebook_url, linkedin_url, youtube_url, instagram_url, twitter_url, addTags;
    WebElement serviceTitle, serviceDescription, selectCategory, selectTopic, access, tagline, physical, massage, addImage;
    public void healthPractitioner_Flow(WebDriver driver) throws InterruptedException {
//        Thread.sleep(5000);
        String companyName= faker.company().name();
        String script = "arguments[0].scrollIntoView();";
//        driver.switchTo().newWindow(WindowType.TAB);

        driver.get(URL);

        practitioner = driver.findElement(By.xpath("//*[contains(text(),'I am a health practitioner/specialist')]"));
        practitioner.click();

        Thread.sleep(3000);

        selectExpertise = driver.findElement(By.xpath("//*[contains(text(), 'Medical Doctor')]"));
        selectExpertise.click();

        selectExpertise = driver.findElement(By.xpath("//*[contains(text(), 'Social Counselor')]"));
        selectExpertise.click();

        selectExpertise = driver.findElement(By.xpath("//*[contains(text(), 'Yoga Trainer')]"));
        selectExpertise.click();
        Thread.sleep(2000);

        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

        Thread.sleep(1000);
        businessName = driver.findElement(By.id("businessName"));
        businessName.sendKeys(companyName);
        tagline = driver.findElement(By.id("tagLine"));
        tagline.sendKeys(faker.company().catchPhrase());
        contactNumber = driver.findElement(By.id("contactNumber"));
        contactNumber.sendKeys(faker.phoneNumber().cellPhone());
        businessAddress = driver.findElement(By.id("address"));
        businessAddress.sendKeys(faker.address().fullAddress());

        lastElement = driver.findElement(By.cssSelector("p:last-child"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, lastElement);

        businessDescription = driver.findElement(By.id("aboutYourself"));
        businessDescription.sendKeys(faker.shakespeare().hamletQuote());
        addTags = driver.findElement(By.id("tags"));
        addTags.sendKeys("#"+faker.harryPotter().house(), Keys.ENTER);

//      Add Media
        for(int i=1;i<=5;i++) {
            addImage = driver.findElement(By.xpath("//div/input[@type='file' and @accept='image/png, image/jpg, image/jpeg, video/mp4, video/mkv']"));
            addImage.sendKeys("/home/squarebits/Desktop/Test data/Test Images/Test Post Images/nature/image" + faker.number().numberBetween(1, 50) + ".jpg");
            driver.findElement(By.id("crop-done")).click();
            Thread.sleep(4000);
        }
        addImage = driver.findElement(By.xpath("//div/input[@type='file' and @accept='image/png, image/jpg, image/jpeg, video/mp4, video/mkv']"));
        addImage.sendKeys("/home/squarebits/Desktop/Test data/Test Videos/Diatery.mp4");
        Thread.sleep(8000);

        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

//      Add social links
        business_url = driver.findElement(By.id("yourURL"));
        business_url.sendKeys("https://www."+companyName+".org");
        facebook_url = driver.findElement(By.id("facebookURL"));
        facebook_url.sendKeys("https://www.facebook.com/"+companyName);
        linkedin_url = driver.findElement(By.id("linkedInURL"));
        linkedin_url.sendKeys("https://www.linkedin.com/"+companyName);
        youtube_url = driver.findElement(By.id("youtubeURL"));
        youtube_url.sendKeys("https://www.youtube.com/"+companyName);
        instagram_url = driver.findElement(By.id("instagramURL"));
        instagram_url.sendKeys("https://www.instagram.com/"+companyName);
        twitter_url = driver.findElement(By.id("xURL"));
        twitter_url.sendKeys("https://www.twitter.com/"+companyName);

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
        serviceTitle.sendKeys(faker.company().industry());
        serviceDescription.sendKeys(faker.company().catchPhrase());
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
