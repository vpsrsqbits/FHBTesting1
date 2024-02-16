package home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Service {

    WebElement services, title, description, select_Category, select_Topic, post;
    public void createService(WebDriver driver) throws InterruptedException{

//----- Services tab ---------------------------------------------------------------------------------------------------

        services = driver.findElement(By.xpath("//div/button[contains(text(),'Services')]"));
        services.click();

        Thread.sleep(3000);

        title = driver.findElement(By.id("title"));
        title.sendKeys("Test service title");
        description = driver.findElement(By.id("description"));
        description.sendKeys("Test service description");
        select_Category = driver.findElement(By.xpath("//*[contains(text(),'Physical')]"));
        select_Category.click();
        select_Topic = driver.findElement(By.xpath("//*[contains(text(),'Exercise')]"));
        select_Topic.click();
        post = driver.findElement(By.xpath("//button[contains(text(),'Post Now')]"));
        post.click();
        Thread.sleep(3000);
    }
}