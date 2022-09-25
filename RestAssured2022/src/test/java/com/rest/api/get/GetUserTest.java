package com.rest.api.get;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetUserTest {
	
	String baseURI="https://gorest.co.in";
	String basePath="/public-api/users";
	String token="7152d20d88c5a9aa6517cbe1eb745b4a94d95c9d864ae5775d1666b7c2ea11ae";
	
	
	@Test
	public void getAllUserListAPITest() {
		
	Response response=	RestClient.doGet("JSON", baseURI, basePath, token, null, true);
	System.out.println(response.getStatusCode());
	System.out.println(response.asPrettyString());
		
	}

}
