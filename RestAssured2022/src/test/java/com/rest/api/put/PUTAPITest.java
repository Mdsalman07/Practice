package com.rest.api.put;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.api.post.User;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class PUTAPITest {
	
	//Create a user with post call
	//user info
	//update the info with put call
	//1.other attributes which has been changed,need to check
	//2.the attribute which has been changed need to check
	
	
	//1.Create a POST REQUEST with Payload
	@Test
	public void update_user_PUT_API_Test() {
	User user = new User("Umang", "Sharma", "UmangSharma", "male", "01-12-1990", "umang@gmail.com",
			"21,avenueLand,OFS,FL", "active");
	
	//Convert POJO To JSON-------Using JACKSON API-  ObjectMapper
	
	ObjectMapper mapper = new ObjectMapper();
	String userJson = null;
	try {
		userJson = mapper.writeValueAsString(user);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("POST CALL JSON IS:"+userJson);
	//write POST CALL
	RestAssured.baseURI="https://gorest.co.in";
	String userId=given()
	.contentType(ContentType.JSON)
	.header("Authorization","Bearer 7152d20d88c5a9aa6517cbe1eb745b4a94d95c9d864ae5775d1666b7c2ea11ae")
	.body(userJson)
	.when()
	.post("/public/v2/users")
	.then()
	.assertThat()
	.contentType(ContentType.JSON)
	.extract().path("data.id");
	System.out.println("user id is:"+userId);
	
	
	//Call the PUT API
	
	user.setEmail("umang123@gmail.com");
	
	//Convert this POJO to JSON -----Using JACKSON API-Object Mapper
	String updatedUserJson=null;
	
	try {
		updatedUserJson = mapper.writeValueAsString(user);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	given()
	.contentType(ContentType.JSON)
	.header("Authorization","Bearer 7152d20d88c5a9aa6517cbe1eb745b4a94d95c9d864ae5775d1666b7c2ea11ae")
	.body(updatedUserJson)
	.when()
	.put("/public/v2/users"+userId)
	.then()
	.assertThat()
	.contentType(ContentType.JSON);
	
	
	
	}

	private Object equalTo(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
