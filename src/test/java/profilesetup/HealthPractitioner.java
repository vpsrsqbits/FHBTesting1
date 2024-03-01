package profilesetup;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.datafaker.Faker;
import org.frenbenhealth.APIs;
import org.frenbenhealth.Data;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HealthPractitioner {
    Faker faker = new Faker();
    String profileSetupURL = Data.profileSetupUrl;
    WebElement practitioner, next, selectExpertise, businessName, contactNumber, businessAddress, lastElement, businessDescription, business_url, facebook_url, linkedin_url, youtube_url, instagram_url, twitter_url, addTags;
    WebElement serviceTitle, serviceDescription, selectCategory, selectTopic, access, tagline, physical, massage, addImage;
    WebDriverWait wait;
    public void healthPractitioner_Flow(WebDriver driver)throws InterruptedException{
        Thread.sleep(5000);

        String companyName= faker.company().name();
        String script = "arguments[0].scrollIntoView();";

        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        
        driver.get(profileSetupURL);

        practitioner = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'I am a health practitioner/specialist')]")));
        practitioner.click();


        selectExpertise = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Medical Doctor')]")));
        selectExpertise.click();

        selectExpertise = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Social Counselor')]")));
        selectExpertise.click();

        selectExpertise = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Yoga Trainer')]")));
        selectExpertise.click();

        next = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Next')]")));
        next.click();

        businessName = wait.until(ExpectedConditions.elementToBeClickable(By.id("businessName")));
        businessName.sendKeys(companyName);
        tagline = wait.until(ExpectedConditions.elementToBeClickable(By.id("tagLine")));
        tagline.sendKeys(faker.company().catchPhrase());
        contactNumber = wait.until(ExpectedConditions.elementToBeClickable(By.id("contactNumber")));
        contactNumber.sendKeys(faker.phoneNumber().cellPhone());
        businessAddress = wait.until(ExpectedConditions.elementToBeClickable(By.id("address")));
        businessAddress.sendKeys(faker.address().fullAddress());

        lastElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("p:last-child")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, lastElement);

        businessDescription = wait.until(ExpectedConditions.elementToBeClickable(By.id("aboutYourself")));
        businessDescription.sendKeys(faker.shakespeare().hamletQuote());
        addTags = wait.until(ExpectedConditions.elementToBeClickable(By.id("tags")));
        addTags.sendKeys("#"+faker.harryPotter().house(), Keys.ENTER);

//      Add Media
        for(int i=1;i<=5;i++) {
            addImage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/input[@type='file' and @accept='image/png, image/jpg, image/jpeg, video/mp4, video/mkv']")));
            addImage.sendKeys("/home/squarebits/Desktop/Test data/Test Images/Test Post Images/nature/image" + faker.number().numberBetween(1, 50) + ".jpg");
            wait.until(ExpectedConditions.elementToBeClickable(By.id("crop-done"))).click();
        }
        addImage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/input[@type='file' and @accept='image/png, image/jpg, image/jpeg, video/mp4, video/mkv']")));
        addImage.sendKeys("/home/squarebits/Desktop/Test data/Test Videos/Diatery.mp4");

        next = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Next')]")));
        next.click();

//      Add social links
        business_url = wait.until(ExpectedConditions.elementToBeClickable(By.id("yourURL")));
        business_url.sendKeys("https://www."+companyName+".org");
        facebook_url = wait.until(ExpectedConditions.elementToBeClickable(By.id("facebookURL")));
        facebook_url.sendKeys("https://www.facebook.com/"+companyName);
        linkedin_url = wait.until(ExpectedConditions.elementToBeClickable(By.id("linkedInURL")));
        linkedin_url.sendKeys("https://www.linkedin.com/"+companyName);
        youtube_url = wait.until(ExpectedConditions.elementToBeClickable(By.id("youtubeURL")));
        youtube_url.sendKeys("https://www.youtube.com/"+companyName);
        instagram_url = wait.until(ExpectedConditions.elementToBeClickable(By.id("instagramURL")));
        instagram_url.sendKeys("https://www.instagram.com/"+companyName);
        twitter_url = wait.until(ExpectedConditions.elementToBeClickable(By.id("xURL")));
        twitter_url.sendKeys("https://www.twitter.com/"+companyName);

//        driver.navigate().back();
//        Thread.sleep(2000);
//
//        driver.navigate().forward();

        next = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Next')]")));
        next.click();

//      Add Service


        serviceTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("services[0].title")));
        serviceTitle.sendKeys(faker.company().industry());

        serviceDescription = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("services[0].aboutYourService")));
        serviceDescription.sendKeys(faker.company().catchPhrase());

        selectCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Physical')]")));
        selectCategory.click();

        selectTopic = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Chiropractic or Massage')]")));
        selectTopic.click();
        next = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Next')]")));
        next.click();

//        addService = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), '+Add')]"));
//        addService.click();

//      Pick health category
        selectHealthBenefits(driver);

        next = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Next')]")));
        next.click();

        access = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']")));
        access.click();

        next = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Next')]")));
        next.click();
    }
    public void selectHealthBenefits(WebDriver driver) {

        Response response = new APIs().getHealthTopicCategories();

        assertNotNull(response,"Could not get API response successfully.");

//        response.then().log().body();
        JsonPath json = response.jsonPath();

//     The following lines of code allows API response debugging.
/*

//      This will get total number of health categories.
        System.out.println("Total health categories: "+json.getList("data").size());

//      This will get name of a health category.
        System.out.println("First health category: "+json.getString("data[7].name"));

//      This will get name of one of health topic.
        System.out.println("First health category topic: "+json.getString("data[0].healthTopics[0].name"));

//      This will get the total number of health topics of a particular health category.
        System.out.println("Health topics in first category: "+json.getList("data[0].healthTopics").size()+"\n");
*/

        for(int i=0; i < json.getList("data").size() ; i++){
//            System.out.println("Health category: "+json.getString("data["+i+"].name"));

            new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'"+json.getString("data["+i+"].name")+"')]"))).click();
//            driver.findElement(By.xpath("//*[contains(text(),'"+json.getString("data["+i+"].name")+"')]")).click();
            for(int j=0;j<json.getList("data["+i+"].healthTopics").size();j++){
//                System.out.println("Health topic: "+json.getString("data["+i+"].healthTopics["+j+"].name"));
                new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(text(),\""+json.getString("data["+i+"].healthTopics["+j+"].name")+"\")])["+(i+1)+"]"))).click();
//                driver.findElement(By.xpath("//*[contains(text(),'"+json.getString("data["+i+"].healthTopics["+j+"].name")+"')]")).click();
            }
        }
    }
}
