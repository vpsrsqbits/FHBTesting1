package home;

import org.frenbenhealth.SignIn;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HomePageTest {
    WebElement select_Category,select_Topic,notification,services,events,offers,filter,apply,profile,award_Points,nft,activity,full_name,save,search_User,view_All_User,select_User;
    WebDriver driver;
    SignIn object = new SignIn();
    int i = 0;
    @BeforeAll
    void setup() throws InterruptedException {
        driver = object.signIn();
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


//    @Test
    public void createPost() throws InterruptedException {new Post().createPost(driver);}

    @Test
    public void createOffer() throws InterruptedException{new Offer().createOffer(driver);}

//    @Test
    public void createEvent() throws InterruptedException{new Event().createEvent(driver);}

//    @Test
    public void createService() throws InterruptedException {new Service().createService(driver);}


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