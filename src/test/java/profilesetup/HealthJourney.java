package profilesetup;

import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.time.Duration;
import java.util.stream.IntStream;

public class HealthJourney {
    String URL="https://dev-app-fhb.quartustech.com/profile-setup";
    WebElement health_Journey, selectCategory, selectTopic, storyTitle, storyBody, addImage, physical, massage, access, next;

    Faker faker = new Faker();
    public void healthJourney_Flow(WebDriver driver) throws InterruptedException {
//        Thread.sleep(5000);
//        driver.switchTo().newWindow(WindowType.TAB);

        driver.get(URL);

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

}
