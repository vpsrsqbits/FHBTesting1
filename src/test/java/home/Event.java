package home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Event {

    WebElement events, title, personalized_Message, description, select_Category, lastElement, select_Topic, enter_Location, tag_People, post;
    public void createEvent(WebDriver driver) throws InterruptedException{

//----- Events tab -----------------------------------------------------------------------------------------------------

        events = driver.findElement(By.xpath("//button[contains(text(),'Events')]"));
        events.click();

        Thread.sleep(3000);

        title = driver.findElement(By.id("title"));
        title.sendKeys("Test event title");
        personalized_Message = driver.findElement(By.id("personalizedMessage"));
        personalized_Message.sendKeys("Test event message");

        description = driver.findElement(By.id("description"));
        description.sendKeys("Test event description");

//      Implement scrolling here till end.

//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");


        select_Category = driver.findElement(By.xpath("//*[contains(text(),'Physical')]"));
        select_Category.click();

        lastElement = driver.findElement(By.xpath("//button[contains(text(),'Post Now')]"));
//        js.executeScript(script, lastElement);
//        lastElement = driver.findElement(By.cssSelector("p:last-child"));
//        js.executeScript(script, lastElement);
        Thread.sleep(3000);

        select_Topic = driver.findElement(By.xpath("//*[contains(text(),'Exercise')]"));
        select_Topic.click();

//      Implement date picker logic.
//        event_Period = driver.findElement(By.id("eventPeriod"));
//        event_Period.click();

        enter_Location = driver.findElement(By.id("location"));
//      Implement location

        tag_People = driver.findElement(By.id("ic_back_arrow_nav"));

        post = driver.findElement(By.xpath("//button[contains(text(),'Post Now')]"));
        post.click();
        Thread.sleep(3000);
    }
}