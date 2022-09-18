package com.rest.api.authentications;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AuthAPI {

	
//basic auth:
//username/password	

@Test
public void basic_Auth_API_Test() {
		
		given().log().all()
		.auth()
		.preemptive()
		.basic("admin", "admin")
		.when().log().all()
		.get("http://the-internet.herokuapp.com/basic_auth")
		.then().log().all()
		.assertThat()
		.statusCode(200);
		
	}

//Oauth2.0
//if you are using:
//1. with header: append your token with bearer
//2. with oauth2() method: No need to add Bearer,just to pass the token value


@Test
public void basic_Auth_API1_Test() {
		
		given().log().all()
		.auth()
		.basic("admin", "admin")
		.when().log().all()
		.get("http://the-internet.herokuapp.com/basic_auth")
		.then().log().all()
		.assertThat()
		.statusCode(200);
		
	}

@Test
public void basic_Auth_Digest_Test() {
		
		given().log().all()
		.auth()
		.digest("admin", "admin")
		.when().log().all()
		.get("http://the-internet.herokuapp.com/basic_auth")
		.then().log().all()
		.assertThat()
		.statusCode(200);
		
	}

  @Test
  public void OAuth2_API_Test() {
	  given().log().all()
		.auth()
		.oauth2("7152d20d88c5a9aa6517cbe1eb745b4a94d95c9d864ae5775d1666b7c2ea11ae")
		.when().log().all()
		.get("https://gorest.co.in/public-api/users?first_name=Elva")
		.then().log().all()
		.assertThat()
		.statusCode(200);
		  }
  @Test
  public void OAuth2_API_Test_AuthHeader() {
	  RestAssured.baseURI="https://gorest.co.in";
	  given().log().all()
	  .contentType("application/json")
	  .header("Authorization","Bearer 7152d20d88c5a9aa6517cbe1eb745b4a94d95c9d864ae5775d1666b7c2ea11ae")
	  .when().log().all()
	  .get("/public-api/users?first_name=Elva")
	  .then().log().all()
	  .assertThat()
	  .statusCode(200)
	  .and()
	  .header("Server", "cloudflare");
  }
  
  @Test
  public void OAuth2_API_WithTwoQueryParams_API_Test() {
	  
	  RestAssured.baseURI="https://gorest.co.in";
	  given().log().all()
	  .contentType("application/json")
	  .header("Authorization","Bearer 7152d20d88c5a9aa6517cbe1eb745b4a94d95c9d864ae5775d1666b7c2ea11ae")
	  .queryParam("name", "Ekaaksh Chaturvedi")
	  .queryParam("gender", "female")
	  .when().log().all()
	  .get("/public-api/users")
	  .then().log().all()
	  .assertThat()
	  .statusCode(200)
	  .and()
	  .header("Server", "cloudflare");
	  
  }
  

}
