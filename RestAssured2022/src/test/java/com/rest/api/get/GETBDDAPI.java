package com.rest.api.get;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

//REST ASSURED BDD
//given()
//when()
//then()
//and()

public class GETBDDAPI {
	
	@Test
	public void getAPITest() {
		
		given()
		.when()
		.get("http://ergast.com/api/f1/2017/circuits.json")
		.then()
		.assertThat()
		.body("MrData.total", hasSize(20));
		
	}
	
	@Test
	public void getAPITest2() {
		
	Response response=given().log().all()
		.when().log().all()
		.get("http://ergast.com/api/f1/2017/circuits.json");
	     int StatusCode=response.getStatusCode();
	     System.out.println("Api response status code:"+StatusCode);
	     Assert.assertEquals(StatusCode, 200);
	     System.out.println(response.prettyPrint());
		}
	
	
	@Test
	public void getAPITest3() {
		RestAssured.baseURI="http://ergast.com";
		given().log().all()
			.when().log().all()
			.get("/api/f1/2017/circuits.json")
			.then().log().all()      //Seperator
			.assertThat()
			.statusCode(200)
			.and()
			.contentType(ContentType.JSON)
			.and()
			.header("Content-Length", equalTo("4552"));
		     
			}
	
	@Test
	public void getAPITest4() {
		
		given().log().all()
		.param("text", "test")
			.when().log().all()
			.get("http://md5.jsontest.com")
			.then().log().all()      //Seperator
			.assertThat()
			.body("md5", equalTo("098f6bcd4621d373cade4e832627b4f6"));
		     
			}
	
	@DataProvider(name="getCircuityearData")
	public Object[][] getCircuitYearInfo() {
		return new Object[][] {
			 {"2017",20},
			 {"2016",21},
			 {"1966",9}
		 };
	}
	@Test(dataProvider="getCircuityearData")
	public void getAPITest5(String seasonYear,int circuitNumber) {
       given().log().all()
       .when().log().all()
       .pathParam("raceSeason", seasonYear)
       .get("http://ergast.com/api/f1/{raceSeason}/circuits.json")
       .then()
       .assertThat()
       .body("MRData.CircuitTable.Circuits.circuitId", hasSize(circuitNumber));

	
	}
}
