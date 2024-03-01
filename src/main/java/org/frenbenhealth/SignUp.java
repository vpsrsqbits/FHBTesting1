package org.frenbenhealth;

import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignUp {
    ChromeDriver driver;
    WebElement fullName, email, userName, setPassword, signUp;
    Faker faker = new Faker();
    UserIncrement userIncrement = new UserIncrement();
    String URL= Data.webAppBaseUrl+"signup/", pass = Data.password, uName;

    // Create an instance of the Cognito Identity Provider client
    AWSCognitoIdentityProvider cognitoIdentityProvider = AWSCognitoIdentityProviderClientBuilder.standard()
            .withRegion("us-east-1") // Specify the region
            .build();;
    AdminUpdateUserAttributesRequest updateUserAttributesRequest;
    public String userSignUp(){

        driver = new ChromeDriver();

        // Read the integer from the file
        int num = userIncrement.readFromFile(userIncrement.filePath);

        driver.get(URL);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        fullName = driver.findElement(By.id("name"));
        fullName.sendKeys(faker.name().fullName());

        email = driver.findElement(By.id("email"));

        email.sendKeys("ramsample1+"+num+"@gmail.com");

        userName = driver.findElement(By.id("username"));
        uName = faker.name().username();
        userName.sendKeys(uName);

        setPassword = driver.findElement(By.id("password"));
        setPassword.sendKeys(pass);

        signUp = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));
        signUp.click();

        System.out.println("User created with user name: "+uName);
        System.out.println("User created with email: ramsample1+"+num+"@gmail.com");

        // Increment the number
        num++;

        // Write the updated number back to the file
        userIncrement.writeToFile(userIncrement.filePath, num);

        return uName;
    }

    public void confirmSignUp(){



        // Set up the parameters for the AdminUpdateUserAttributesRequest
        updateUserAttributesRequest = new AdminUpdateUserAttributesRequest()
                .withUserPoolId("us-east-1_KaI85wjlz") // Specify your user pool ID
                .withUsername(uName); // Specify the username of the user whose email you want to mark as verified

        // Add the email_verified attribute with the value "true" to mark the email as verified
        AttributeType attribute1 = new AttributeType()
                .withName("email_verified")
                .withValue("true");

        // Verify user
        AdminConfirmSignUpRequest confirmSignUpRequest = new AdminConfirmSignUpRequest()
                .withUserPoolId("us-east-1_KaI85wjlz")
                .withUsername(uName);

        AdminConfirmSignUpResult confirmSignUpResult = cognitoIdentityProvider.adminConfirmSignUp(confirmSignUpRequest);

        List<AttributeType> attributes = new ArrayList<>();

        attributes.add(attribute1);

        updateUserAttributesRequest.setUserAttributes(attributes);

        // Call the AdminUpdateUserAttributes API
        AdminUpdateUserAttributesResult updateUserAttributesResult = cognitoIdentityProvider.adminUpdateUserAttributes(updateUserAttributesRequest);

        // Print the result
        System.out.println("User sign-up confirmed: "+confirmSignUpResult.getSdkResponseMetadata().getRequestId());
        System.out.println("Email verification status updated: " + updateUserAttributesResult.getSdkResponseMetadata().getRequestId());

    }

    public void deleteUser(){

        cognitoIdentityProvider.adminDeleteUser(new AdminDeleteUserRequest()
                .withUserPoolId("us-east-1_KaI85wjlz")
                .withUsername(uName));
    }
    public void deleteUser(String name){

        cognitoIdentityProvider.adminDeleteUser(new AdminDeleteUserRequest()
                .withUserPoolId("us-east-1_KaI85wjlz")
                .withUsername(name));
    }

//      Test for Terms and Conditions.
    public void terms_and_conditions(){

        driver.get("https://dev-api-fhb.quartustech.com/fhb-terms-and-conditions");

//      Waiting for expected URL.
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("fhb-terms-and-conditions"));

//      Getting page's source.
        String pageSource = driver.getPageSource();

//      Checking for heading "Terms and service" in the page's source.
        assertTrue(pageSource.contains("Terms of service"),"'Terms of service' not found.");

//      Checking for page's title to be "FrenBen".
        assertEquals("FrenBen",driver.getTitle(), "Page title is different.");
    }

//      Test for Privacy policy.
    public void privacy_Policy(){

        driver.get("https://dev-api-fhb.quartustech.com/fhb-privacy-policy");

//      Waiting for expected URL.
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("fhb-privacy-policy"));

//      Getting page's source.
        String pageSource = driver.getPageSource();

//      Checking for heading "Terms and service" in the page's source.
        assertTrue(pageSource.contains("Privacy Policy"),"'Privacy Policy' not found.");

//      Checking for page's title to be "FrenBen".
        assertEquals("FrenBen",driver.getTitle(), "Page title is different.");
    }

}