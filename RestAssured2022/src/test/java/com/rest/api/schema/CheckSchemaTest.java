package com.rest.api.schema;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class CheckSchemaTest {
	
	@Test
	public void bookings_SchemaTest() {
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		given().log().all()
		.contentType(ContentType.JSON)
		.body(new File("C:\\Users\\Mohammed Salman\\eclipse-workspace\\RestAssured2022\\"
		+"src\\test\\java\\com\\rest\\api\\schema\\bookings.json"))
		.when().log().all()
		.post("/booking")
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.and()
		.body(matchesJsonSchemaInClasspath("BookingsSchema.json"));
		
	}

}
