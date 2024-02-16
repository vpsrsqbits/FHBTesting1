package org.frenbenhealth;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class APIs {

    public static void main(String[] args) {

        Response response = getHealthTopicCategories();
//        response.then().log().body();
        JsonPath json = response.jsonPath();
//        String data = json.getList("data");
//        List<String> data = json.getString("data");
        System.out.println("Total health categories: "+json.getList("data").size());
        System.out.println("Health topics in first category: "+json.getList("data[0].healthTopics").size());

    }
    public static Response getHealthTopicCategories(){
           return given()
                .contentType(ContentType.JSON)
                .header("Authorization", Data.authToken)
                .when()
                .get(Data.apiBaseUrl+"/v1/posts/health-topic-categories");
    }
    public void invalidateOnboarding(){
        given().log().body()
                .contentType(ContentType.JSON)
                .header("Authorization", Data.authToken)
                .body("{\n" +
                        "    \"isOnboardingCompleted\":false\n" +
                        "}")
                .when()
                .patch("https://dev-api-fhb.quartustech.com/v1/users/update")
                .then().log().all();
    }

}