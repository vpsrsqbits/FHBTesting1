package profilesetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.time.Duration;

public class SeekingFriendsFlowTest {
    String URL="https://dev-app-fhb.quartustech.com/profile-setup";
    WebElement seeking_Friends, physical, massage, next, access;
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
}
