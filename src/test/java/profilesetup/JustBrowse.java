package profilesetup;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.frenbenhealth.APIs;
import org.frenbenhealth.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JustBrowse {
    String profileSetupURL= Data.profileSetupUrl;
    WebElement just_Browse, next, physical, selectTopic, access;
    WebDriverWait wait;
    public void justBrowse_Flow(WebDriver driver)throws InterruptedException{
        Thread.sleep(5000);

        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get(profileSetupURL);

        selectHealthBenefits(driver);

        next = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Next')]")));
        next.click();

        access = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']")));
        access.click();

        next = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Next')]")));
        next.click();
        //To Home
    }

    public void selectHealthBenefits(WebDriver driver) {

        Response response = new APIs().getHealthTopicCategories();

        assertNotNull(response,"Could not get API response successfully.");

//        response.then().log().body();
        JsonPath json = response.jsonPath();

//     The following lines of code allows API response debugging.
/*

//      This will get total number of health categories.
        System.out.println("Total health categories: "+json.getList("data").size());

//      This will get name of a health category.
        System.out.println("First health category: "+json.getString("data[7].name"));

//      This will get name of one of health topic.
        System.out.println("First health category topic: "+json.getString("data[0].healthTopics[0].name"));

//      This will get the total number of health topics of a particular health category.
        System.out.println("Health topics in first category: "+json.getList("data[0].healthTopics").size()+"\n");
*/

        for(int i=0; i < json.getList("data").size() ; i++){
//            System.out.println("Health category: "+json.getString("data["+i+"].name"));

            new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'"+json.getString("data["+i+"].name")+"')]"))).click();
//            driver.findElement(By.xpath("//*[contains(text(),'"+json.getString("data["+i+"].name")+"')]")).click();
            for(int j=0;j<json.getList("data["+i+"].healthTopics").size();j++){
//                System.out.println("Health topic: "+json.getString("data["+i+"].healthTopics["+j+"].name"));
                new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(text(),\""+json.getString("data["+i+"].healthTopics["+j+"].name")+"\")])["+(i+1)+"]"))).click();
//                driver.findElement(By.xpath("//*[contains(text(),'"+json.getString("data["+i+"].healthTopics["+j+"].name")+"')]")).click();
            }
        }
    }
}
