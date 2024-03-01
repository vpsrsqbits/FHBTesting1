package home;

import net.datafaker.Faker;
import org.frenbenhealth.Data;
import org.frenbenhealth.SignIn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Post {

    Faker faker = new Faker();
    WebElement create, upload_Image, title, description, lastElement, select_Category, select_Topic, post;
    WebDriver driver;
    SignIn object = new SignIn();
    int i = 0;
    @BeforeAll
    void setup() throws InterruptedException {
        driver = object.signIn(Data.userName);
        Thread.sleep(4000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://dev-app-fhb.quartustech.com/");
    }
    @RepeatedTest(3)
    public void  createPost(WebDriver driver) throws InterruptedException {

        String script = "arguments[0].scrollIntoView();";

        Thread.sleep(2000);

        create = this.driver.findElement(By.id("ic_add_new_post"));
        create.click();
        Thread.sleep(5000);

//----- Post tab -------------------------------------------------------------------------------------------------------
for (int i=0;i<4;i++) {
    upload_Image = this.driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div[2]/div/div/main/div[3]/form/div/div[1]/div/input"));
    upload_Image.sendKeys("/home/squarebits/Desktop/Test data/Test Images/Test Post Images/nature/image" + faker.number().numberBetween(1, 50) + ".jpg");
    Thread.sleep(3000);
    this.driver.findElement(By.id("crop-done")).click();
    Thread.sleep(5000);
}
        title = this.driver.findElement(By.id("title"));
        title.sendKeys(faker.shakespeare().hamletQuote());
        description = this.driver.findElement(By.id("description"));
        description.sendKeys(faker.shakespeare().asYouLikeItQuote());

//      Implement scrolling here.

        lastElement = this.driver.findElement(By.cssSelector("p:last-child"));

        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript(script, lastElement);

//      Select Category.
        select_Category = this.driver.findElement(By.xpath("//*[contains(text(),'Physical')]"));
        select_Category.click();
//      Select a topic.
        select_Topic = this.driver.findElement(By.xpath("//*[contains(text(),'Exercise')]"));
        select_Topic.click();
        post = this.driver.findElement(By.xpath("//*[contains(text(),'Post Now')]"));
        post.click();
        Thread.sleep(3000);
        i++;
    }
}
