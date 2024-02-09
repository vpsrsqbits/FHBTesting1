import home.TabSwitchTest;
import org.frenbenhealth.SignIn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.*;
import profilesetup.*;

import java.time.Duration;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserOnboardingTest {
    WebDriver driver;
    SignIn obj = new SignIn();
    @Test
    @Order(1)
    void seekingFriends() throws InterruptedException {
        obj.invalidateOnboarding();
        driver = obj.signIn();

        new SeekingFriendsFlowTest().seekingFriends_Flow(driver);
        new TabSwitchTest().test(driver);
        driver.quit();
    }


    @Test
    @Order(2)
    void healthJourney() throws InterruptedException {
        obj.invalidateOnboarding();
        driver = obj.signIn();

        new HealthJourneyFlowTest().healthJourney_Flow(driver);
        new TabSwitchTest().test(driver);
        driver.quit();
    }


    @Test
    @Order(3)
    void yolo() throws InterruptedException {
        obj.invalidateOnboarding();
        driver = obj.signIn();

        new YOLOFlowTest().yolo_Flow(driver);
        new TabSwitchTest().test(driver);
    }


    @Test
    @Order(4)
    void healthPractitioner() throws InterruptedException {
        obj.invalidateOnboarding();
        driver = obj.signIn();

        new HealthPractitionerFlowTest().healthPractitioner_Flow(driver);
        new TabSwitchTest().test(driver);
    }

    @Test
    @Order(5)
    void justBrowse() throws InterruptedException {
        obj.invalidateOnboarding();
        driver = obj.signIn();

        new JustBrowseFlowTest().justBrowse_Flow(driver);
        new TabSwitchTest().test(driver);
    }

    @AfterEach
    void teardown(){
    driver.quit();
}
}