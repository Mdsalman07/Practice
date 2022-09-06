package com.rest.api.get;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class ResponseSpecBuilderTest {
	
	//t1,t2,t3..........t100
	//statusCode=200
	//content type
	//header
	
	ResponseSpecBuilder  res=new ResponseSpecBuilder();
    ResponseSpecification resSpec_200OK=res.
     expectContentType(ContentType.JSON).
     expectStatusCode(200).expectHeader("Server", "cloudflare").
     build();
    
    ResponseSpecification resSpec_401_Auth_fail=res.
    	     expectStatusCode(401).
    	     expectHeader("Server", "cloudflare").
    	     build();
     
	
	 
	 @Test
	 public void ResponseSpecTest() {
		 RestAssured.baseURI="https://gorest.co.in";
		 given().log().all()
		 .header("Authorization","Bearer 7152d20d88c5a9aa6517cbe1eb745b4a94d95c9d864ae5775d1666b7c2ea11ae")
		 .when().log().all()
		 .get("/public/v2/users")
		 .then()
		 .assertThat()
		 .spec(resSpec_200OK);
		 
	 }
	 @Test
	 public void ResponseSpec_Auth_Fail_Test() {
		 RestAssured.baseURI="https://gorest.co.in";
		 given().log().all()
		 .header("Authorization","Bearer 7152d20d88c5a9aa6517cbe1eb745b4a94d95c9d864ae5775d1666b7c2ea11ae11111")
		 .when().log().all()
		 .get("/public/v2/users")
		 .then()
		 .assertThat()
		 .spec(resSpec_401_Auth_fail);
		 
	 }
}
