package com.rest.api.post;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


/**
 * 
 * @author Mohammed Salman
 *
 */
public class POSTAPIWithPOJO {

	// create a user
	// POST - URL
	// JSON BODY------->
	// USER JAVA(POJO)----->JSON Object

	@Test
	public void createuser_With_POJO_Test() {
		User user = new User("Nisha", "John", "NishaJohn", "female", "01-01-1990", "nisha1@gmail.com",
				"12,avenue,SFO,CA", "active");

		// convert Java pojo to json --Serialization---Jackson API
		ObjectMapper mapper = new ObjectMapper();
		String userJson = null;
		try {
			userJson = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(userJson);
		RestAssured.baseURI="https://gorest.co.in";
		given()
		.contentType(ContentType.JSON)
		.header("Authorization","Bearer 7152d20d88c5a9aa6517cbe1eb745b4a94d95c9d864ae5775d1666b7c2ea11ae")
		.body(userJson)
		.when()
		.post("/public/v2/users")
		.then()
		.assertThat()
		.contentType(ContentType.JSON);
		
	}

}
