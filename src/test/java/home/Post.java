package home;

import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Post {

    Faker faker = new Faker();
    WebElement create, upload_Image, title, description, lastElement, select_Category, select_Topic, post;

    public void  createPost(WebDriver driver) throws InterruptedException {

        String script = "arguments[0].scrollIntoView();";

        Thread.sleep(2000);

        create = driver.findElement(By.id("ic_add_new_post"));
        create.click();
        Thread.sleep(5000);

//----- Post tab -------------------------------------------------------------------------------------------------------

        upload_Image = driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div[2]/div/div/main/div[3]/form/div/div[1]/div/input"));
        upload_Image.sendKeys("/home/squarebits/Desktop/Test data/Test Images/Test Post Images/nature/image"+faker.number().numberBetween(1,50)+".jpg");
        Thread.sleep(3000);
        driver.findElement(By.id("crop-done")).click();
        Thread.sleep(5000);
        title = driver.findElement(By.id("title"));
        title.sendKeys(faker.shakespeare().hamletQuote());
        description = driver.findElement(By.id("description"));
        description.sendKeys(faker.shakespeare().asYouLikeItQuote());

//      Implement scrolling here.

        lastElement = driver.findElement(By.cssSelector("p:last-child"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, lastElement);

//      Select Category.
        select_Category = driver.findElement(By.xpath("//*[contains(text(),'Physical')]"));
        select_Category.click();
//      Select a topic.
        select_Topic = driver.findElement(By.xpath("//*[contains(text(),'Exercise')]"));
        select_Topic.click();
        post = driver.findElement(By.xpath("//*[contains(text(),'Post Now')]"));
        post.click();
        Thread.sleep(3000);
    }
}
