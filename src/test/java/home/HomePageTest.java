package home;

import net.datafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HomePageTest {
    Faker faker = new Faker();
    WebElement email,password,signIn,create,title,description,select_Category,select_Topic,post,offer_Benefits,offer_Type,promotion_Type,promote_Product,product_Category,offer_Period,enter_Location,tag_People,personalized_Message,event_Period,notification,services,events,offers,filter,apply,profile,award_Points,nft,activity,edit_Profile,full_name,save,lastElement,upload_Image,search_User,view_All_User,select_User;
    WebDriver driver;
    int i = 0;
    @BeforeAll
    void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://dev-app-fhb.quartustech.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        email = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        signIn = driver.findElement(By.xpath("//button[contains(text(),'Sign In')]"));
        driver.manage().window().maximize();
        email.sendKeys("randall.hen");
        password.sendKeys("Test@1234");
        signIn.click();
        Thread.sleep(4000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://dev-app-fhb.quartustech.com/");
    }
//    @Test
//    public void search() throws InterruptedException {
//
//        driver.switchTo().newWindow(WindowType.TAB);
//        Thread.sleep(5000);
//        driver.get("https://dev-app-fhb.quartustech.com/");
//
//        Thread.sleep(2000);
//        search_bar = driver.findElement(By.id("search"));
//        search_bar.sendKeys("Para");
//        option = search_bar.getAttribute("value");
//        System.out.println(option);
//    }

//    The following lines of code creates multiple posts.

//    @Test
    @RepeatedTest(5)
    public void  post() throws InterruptedException {

        String script = "arguments[0].scrollIntoView();";

        Thread.sleep(2000);

        create = driver.findElement(By.id("ic_add_new_post"));
        create.click();
        Thread.sleep(5000);

//----- Post tab -------------------------------------------------------------------------------------------------------

        upload_Image = driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div[2]/div/div/main/div[3]/form/div/div[1]/div/input"));
        upload_Image.sendKeys("/home/squarebits/Desktop/Test data/Test Images/Test Post Images/nature/image"+faker.number().numberBetween(0,50)+".jpg");
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
//    @Test
    @Order(1)
    public void create() throws InterruptedException {
        String script = "arguments[0].scrollIntoView();";

        Thread.sleep(2000);

        create = driver.findElement(By.id("ic_add_new_post"));
        create.click();
        Thread.sleep(5000);

//----- Post tab -------------------------------------------------------------------------------------------------------

        upload_Image = driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div[2]/div/div/main/div[3]/form/div/div[1]/div/input"));
        upload_Image.sendKeys("https://source.unsplash.com/featured/?cars");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(text(),'Done')]")).click();
        Thread.sleep(5000);
        title = driver.findElement(By.id("title"));
        title.sendKeys("Test title");
        description = driver.findElement(By.id("description"));
        description.sendKeys("Test description");

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

//----- Offers tab -----------------------------------------------------------------------------------------------------

        create = driver.findElement(By.id("ic_add_new_post"));
        create.click();
        Thread.sleep(3000);

        offers = driver.findElement(By.xpath("//button[contains(text(),'Offers')]"));
        offers.click();

        Thread.sleep(3000);

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
//    @Test()
    @Order(2)
    public void notification() throws InterruptedException {
        notification = driver.findElement(By.id("icn_Notifications"));
        notification.click();

        Thread.sleep(3000);
    }
//    @Test
    @Order(3)
    public void filter() throws InterruptedException {
        filter = driver.findElement(By.id("ic_right_menu_nav"));
        filter.click();
        Thread.sleep(6000);

        select_Category = driver.findElement(By.xpath("//*[contains(text(),'Physical')]"));
        Thread.sleep(6000);

        select_Category.click();
        Thread.sleep(5000);

        select_Topic = driver.findElement(By.xpath("//*[contains(text(),'Stretching')]"));
        select_Topic.click();
        Thread.sleep(5000);

        apply = driver.findElement(By.xpath("//*[contains(text(),'Apply')]"));
        apply.click();
        Thread.sleep(3000);

    }
//    @Test
    @Order(4)
    public void profile() throws InterruptedException {
        profile = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div/div[1]/div[2]/div/div"));
        profile.click();
        Thread.sleep(3000);
//        post = driver.findElement(By.xpath("//*[contains(text(),'Posts')]"));
//        post.click();
//        Thread.sleep(2000);

        award_Points = driver.findElement(By.xpath("//*[contains(text(),'Award Points')]"));
        award_Points.click();
        Thread.sleep(2000);

        offers = driver.findElement(By.xpath("//*[contains(text(),'Offers')]"));
        offers.click();
        Thread.sleep(2000);

        events = driver.findElement(By.xpath("//*[contains(text(),'Events')]"));
        events.click();
        Thread.sleep(2000);

        services = driver.findElement(By.xpath("//*[contains(text(),'Services')]"));
        services.click();
        Thread.sleep(2000);

        nft = driver.findElement(By.xpath("//*[contains(text(),'My NFTS')]"));
        nft.click();
        Thread.sleep(2000);

        activity = driver.findElement(By.xpath("//*[contains(text(),'My Activity')]"));
        activity.click();
        Thread.sleep(2000);

    }
//    @Test
    @Order(5)
    public void edit_Profile() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(text(),'Home')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Edit Profile')]")).click();
//        edit_Profile = driver.findElement(By.id("icn_Edit"));
//        edit_Profile.click();
        Thread.sleep(2000);

        full_name = driver.findElement(By.id("name"));
        full_name.sendKeys(Keys.CONTROL,"A",Keys.BACK_SPACE);
        full_name.sendKeys("Chrisss");

        save = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
        save.click();
        Thread.sleep(3000);

    }
//    @Test
    @Order(6)
    public void recent_Chats() throws InterruptedException {

//      Search users
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(text(),'Home')]")).click();
        search_User = driver.findElement(By.id("search-recent-chats"));
        search_User.sendKeys("kate");

//      View all users
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(text(),'Home')]")).click();
        view_All_User = driver.findElement(By.xpath("//*[contains(text(),'View All')]"));
        view_All_User.click();

//      Click user to chat
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(text(),'Home')]")).click();
        select_User = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div/div[2]/div/section/div/div[2]/div[3]/div[1]"));
        select_User.click();
    }
//    @AfterAll
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}



//Skype join link: https://join.skype.com/uUiPq9O0ny6r