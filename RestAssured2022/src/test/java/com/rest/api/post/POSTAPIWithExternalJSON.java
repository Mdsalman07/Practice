package com.rest.api.post;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class POSTAPIWithExternalJSON {
	
	@Test
	public void PostExternalJSON() throws IOException {
		
		String current = System.getProperty("user.dir");
        System.out.println("Current working directory in Java : " + current);
     String filePath= Files.readString(Paths.get(System.getProperty("user.dir")+"\\src\\test\\java\\DataFiles\\test.json"));
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		String response=given().log().all()
		.header("Content-Type","application/json")
		.body(filePath)
		.when()
		.post("/booking")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
			
	}

}
