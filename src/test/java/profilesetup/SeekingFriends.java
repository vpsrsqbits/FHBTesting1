package profilesetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SeekingFriends {
    String URL="https://dev-app-fhb.quartustech.com/profile-setup";
    WebElement seeking_Friends, physical, massage, next, access, isSignOutSuccess, categories;
    List<WebElement> divs, topics;
    public void seekingFriends_Flow(WebDriver driver) throws InterruptedException {
//        Thread.sleep(5000);
//        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(URL);

        seeking_Friends = driver.findElement(By.xpath("//span[contains(text(),'myhealthysocial')]"));

        seeking_Friends.click();

        Thread.sleep(5000);

//      Find and get categories.
        categories = driver.findElement(By.xpath("//div[@class='MuiBox-root css-eawi8m']"));

        List<WebElement> divs = categories.findElements(By.tagName("div"));
        System.out.println(divs.size());
        List<String> categoriesList = new ArrayList<>();
        Set<String> uniqueCatList = new HashSet<>();

        for (int i=0;i< divs.size();i++)
        {
//            if(!Objects.equals(divs.get(i).getText(), ""))
                uniqueCatList.add(divs.get(i).getText());
        }

        Map<String, List<String>> healthCategories = new HashMap<>();


//        List<String> ;
//        System.out.println(divs.get(0).getText());

        for(String category: uniqueCatList)
        {
            System.out.println(category);
            driver.findElement(By.xpath("//*[contains(text(), '"+category+"')]")).click();
            Thread.sleep(3000);
        }

        Thread.sleep(3000);

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
        // To Home
    }
    public void logout(WebDriver driver) throws InterruptedException{
//        Thread.sleep(5000);
//        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(URL);

        driver.findElement(By.id("ic_back_arrow_nav")).click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Yes, Log Out')]")));

        driver.findElement(By.xpath("//*[contains(text(),'Yes, Log Out')]")).click();

        isSignOutSuccess = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Sign-out is successful. Goodbye!')]")));

        assertNotNull(isSignOutSuccess, "Sign-Out success message not found.");
    }
}