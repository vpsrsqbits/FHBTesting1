package profilesetup;

import org.frenbenhealth.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YOLO {
    String profileSetupURL = Data.profileSetupUrl;
    WebElement yolo, next, physical, massage, access;
    WebDriverWait wait;
    public void yolo_Flow(WebDriver driver)throws InterruptedException{
        Thread.sleep(5000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(profileSetupURL);

        yolo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'YOLO')]")));

        yolo.click();

//  Handle this dropdown

        new SeekingFriends().selectHealthBenefits(driver);

        next = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Next')]")));
        next.click();

        access = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']")));
        access.click();

//        driver.navigate().back();
//        Thread.sleep(2000);
//
//        driver.navigate().forward();
//        Thread.sleep(2000);

        next = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Next')]")));
        next.click();

        //To Home
    }
}
