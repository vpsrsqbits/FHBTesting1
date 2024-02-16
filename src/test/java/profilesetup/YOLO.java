package profilesetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.time.Duration;

public class YOLO {
    String URL = "https://dev-app-fhb.quartustech.com/profile-setup";
    WebElement yolo, next, physical, massage, access;
    public void yolo_Flow(WebDriver driver) throws InterruptedException {
//        Thread.sleep(5000);
//        driver.switchTo().newWindow(WindowType.TAB);

        driver.get(URL);

        yolo = driver.findElement(By.xpath("//*[contains(text(),'YOLO')]"));

        yolo.click();
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
}
