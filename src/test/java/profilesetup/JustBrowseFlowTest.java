package profilesetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.time.Duration;

public class JustBrowseFlowTest {
    String URL="https://dev-app-fhb.quartustech.com/profile-setup";
    WebElement just_Browse, next, physical, selectTopic, access;
    public void justBrowse_Flow(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        just_Browse = driver.findElement(By.xpath("//*[contains(text(),'Just Browse Conversations')]"));
        just_Browse.click();
        Thread.sleep(3000);

        physical = driver.findElement(By.xpath("//*[contains(text(),'Physical')]"));
        physical.click();
        selectTopic = driver.findElement(By.xpath("//*[contains(text(), 'Chiropractic or Massage')]"));
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

        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();

        Thread.sleep(2000);
        access = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/label/span/span[1]/input"));
        access.click();
        Thread.sleep(2000);

        next = driver.findElement(By.xpath("//*[contains(text(), 'Next')]"));
        next.click();
        //To Home
    }
}
