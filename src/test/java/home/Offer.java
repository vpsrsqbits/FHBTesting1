package home;

import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Offer {
    WebElement offers, create, title, offer_Benefits, offer_Type, offer_Period, description, lastElement, select_Category, select_Topic,promotion_Type, promote_Product, product_Category, post, tag_People, enter_Location, addImage;
    JavascriptExecutor js;
    Faker faker = new Faker();
    public void createOffer(WebDriver driver) throws InterruptedException {



//----- Offers tab -----------------------------------------------------------------------------------------------------
        String script = "arguments[0].scrollIntoView();";

        create = driver.findElement(By.id("ic_add_new_post"));
        create.click();
        Thread.sleep(3000);

        offers = driver.findElement(By.xpath("//button[contains(text(),'Offer')]"));
        offers.click();

        Thread.sleep(3000);

//      Implement add image.
/*
        addImage = driver.findElement(By.xpath("//*[@id=\"scrollableDiv\"]/div[3]/form/div/div[1]/div/input"));
        addImage.sendKeys("/home/squarebits/Desktop/Test data/Test Images/Test Post Images/nature/image"+faker.number().numberBetween(1,50)+".jpg");
        Thread.sleep(3000);
        driver.findElement(By.id("crop-done")).click();
        Thread.sleep(5000);
*/

        title = driver.findElement(By.id("title"));
        title.sendKeys("Test title");
        offer_Benefits = driver.findElement(By.id("benefitToSponsee"));
        offer_Benefits.sendKeys("Test Benefits");
        description = driver.findElement(By.id("description"));
        description.sendKeys("Test Description");

//      Implement scrolling here

        lastElement = driver.findElement(By.cssSelector("p:last-child"));
        js.executeScript(script, lastElement);

        select_Category = driver.findElement(By.xpath("//*[contains(text(),'Physical')]"));
        select_Category.click();
        select_Topic = driver.findElement(By.xpath("//*[contains(text(),'Exercise')]"));
        select_Topic.click();
//      Dropdown
        offer_Type = driver.findElement(By.id("select-offerType"));
        promotion_Type = driver.findElement(By.id("select-promotionType"));

        promote_Product = driver.findElement(By.id("productToBePromoted"));
        promote_Product.sendKeys("Test Product");

//      Dropdown
        product_Category = driver.findElement(By.id("select-productCategory"));

        offer_Period = driver.findElement(By.id("offerPeriod"));
        enter_Location = driver.findElement(By.id("location"));
//      Dropdown
        tag_People = driver.findElement(By.id("ic_back_arrow_nav"));

        post = driver.findElement(By.xpath("//button[contains(text(),'Post Now')]"));
        post.click();
        Thread.sleep(3000);
    }
}
