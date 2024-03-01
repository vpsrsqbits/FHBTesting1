import home.TabSwitchTest;
import org.frenbenhealth.APIs;
import org.frenbenhealth.Data;
import org.frenbenhealth.SignIn;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.*;
import profilesetup.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserOnboardingTest {
    WebDriver driver;
    SignIn signIn = new SignIn();
    APIs api = new APIs();
//    @Test
    @Order(1)
    void seekingFriends() throws InterruptedException {
//        api.invalidateOnboarding();

//      Sign-In and Sign-Out
//        driver = signIn.signIn();
//        new SeekingFriends().logout(driver);

//      Sign-In and SeekingFriends user flow setup.
        driver = signIn.signIn(Data.userName);
        new SeekingFriends().seekingFriends_Flow(driver);
/*

//      Switch between tabs on Home.
        new TabSwitchTest().test(driver);
        driver.quit();
 */
    }


//    @Test
    @Order(2)
    void healthJourney() throws InterruptedException {
//        api.invalidateOnboarding();
        driver = signIn.signIn(Data.userName);

        new HealthJourney().healthJourney_Flow(driver);
//        new TabSwitchTest().test(driver);
//        driver.quit();
    }


//    @Test
    @Order(3)
    void yolo() throws InterruptedException {
//        api.invalidateOnboarding();
        driver = signIn.signIn(Data.userName);

        new YOLO().yolo_Flow(driver);
//        new TabSwitchTest().test(driver);
    }


//    @Test
    @Order(4)
    void healthPractitioner() throws InterruptedException {
//        api.invalidateOnboarding();
        driver = signIn.signIn(Data.userName);

        new HealthPractitioner().healthPractitioner_Flow(driver);
//        new TabSwitchTest().test(driver);
    }

//    @Test
    @Order(5)
    void justBrowse() throws InterruptedException {
//        api.invalidateOnboarding();
        driver = signIn.signIn(Data.userName);

        new JustBrowse().justBrowse_Flow(driver);
//        new TabSwitchTest().test(driver);
    }

//    @AfterEach
    void teardown(){driver.quit();
}
}