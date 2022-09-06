package com.rest.api.authentications;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OAuth2APITest {
	
	@Test
	public void checkOAuth2_API_Test() {
		
		RequestSpecification request=
				RestAssured.given()
				.auth()
				.oauth2("f1460ca175cac06b9a53670e46e9e0762cbc3ae7");
	Response response=request.post("http://coop.apps.symfonycasts.com/api/3712/chickens-feed");
	int statusCode=response.getStatusCode();
	System.out.println(response.getStatusCode());
	Assert.assertEquals(statusCode, 200);
	System.out.println(response.prettyPrint());
	
		
	}
	
	//1.Generate a Token at the run time by using token api
	//2.String tokenID from the response
	//3.hit the next api with this tokenID
	
	@Test
	public void getOAuth2AccessTokenAPITest() {
		RequestSpecification request=RestAssured.given()
				.formParam("client_id", "Learning_Application")
				.formParam("client_secret", "60937ad0a8baa7c4193f0aaacec2aff3")
				.formParam("grant_type", "client_credentials");
		
	Response response=request.post("http://coop.apps.symfonycasts.com/token");
	System.out.println(response.statusCode());
	System.out.println(response.prettyPrint());
	String accessToken=response.jsonPath().getString("access_token");

	//feed Chicken API
	RequestSpecification request1=
			RestAssured.given()
			.auth()
			.oauth2(accessToken);
    Response response1=request1.post("http://coop.apps.symfonycasts.com/api/3712/chickens-feed");
    int statusCode=response1.getStatusCode();
    System.out.println(response1.getStatusCode());
    Assert.assertEquals(statusCode, 200);
    System.out.println(response1.prettyPrint());
		
	}

	
	
}
