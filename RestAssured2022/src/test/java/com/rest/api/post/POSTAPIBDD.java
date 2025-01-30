package com.rest.api.post;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class POSTAPIBDD {
	
	@Test
	public void tokenPostBDDAPI_JSONSTRINGTest() {
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		given().log().all()
		.contentType(ContentType.JSON)
		.body("{\"username\" : \"admin\",   \"password\" : \"password123\"}")
		.when().log().all()
		.post("/auth")
		.then().log().all()
		.assertThat()
		.statusCode(200);
				
	}
	
	@Test
	public void tokenPostBDDAPI_FILE_TEST() {
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		Response response=	given().log().all()
		.contentType(ContentType.JSON)
		.body(new File("C:\\Users\\Mohammed Salman\\eclipse-workspace\\RestAssured2022\\"+
		"src\\test\\java\\DataFiles\\credentials.json"))
		.when().log().all()
		.post("/auth");
	    int statusCode=response.getStatusCode();
	    Assert.assertEquals(statusCode, 200);
	    System.out.println(statusCode);
	    System.out.println(response.prettyPrint());
	    String tokenID=  response.jsonPath().getString("token");
	    System.out.println(tokenID);
		
	}
	
	//@Author: Salman
	



}
