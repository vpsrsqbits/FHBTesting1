package org.frenbenhealth;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class APIs {

//    public static void main(String[] args) {
//
//        Response response = getHealthTopicCategories();
////        response.then().log().body();
//        JsonPath json = response.jsonPath();
//
////     The following lines of code allows API response debugging.
///*
//
////      This will get total number of health categories.
//        System.out.println("Total health categories: "+json.getList("data").size());
//
////      This will get name of a health category.
//        System.out.println("First health category: "+json.getString("data[7].name"));
//
////      This will get name of one of health topic.
//        System.out.println("First health category topic: "+json.getString("data[0].healthTopics[0].name"));
//
////      This will get the total number of health topics of a particular health category.
//        System.out.println("Health topics in first category: "+json.getList("data[0].healthTopics").size()+"\n");
//*/
//
//        for(int i=0; i < json.getList("data").size() ; i++){
//            System.out.println("Health category: "+json.getString("data["+i+"].name"));
//            for(int j=0;j<json.getList("data["+i+"].healthTopics").size();j++){
//                System.out.println("Health topic: "+json.getString("data["+i+"].healthTopics["+j+"].name"));
//            }
//        }
//    }

    public Response getHealthTopicCategories(){
            return  given()
                    .contentType(ContentType.JSON)
                    .header("Authorization", Data.authToken)
                    .when()
                    .get(Data.apiBaseUrl+"/v1/posts/health-topic-categories");
    }
    public void invalidateOnboarding(){
        given().log().body()
                .contentType(ContentType.JSON)
                .header("Authorization", Data.authToken)
                .body("{\"isOnboardingCompleted\":false}")
                .when()
                .patch(Data.apiBaseUrl+"/v1/users/update")
                .then().log().all();
    }
}