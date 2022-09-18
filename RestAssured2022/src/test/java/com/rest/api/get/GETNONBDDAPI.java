package com.rest.api.get;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETNONBDDAPI {
	
	
	//prepare the request
	//hit the API
	//get the response
	
	@Test
	public void getUser_Non_Test() {
		
		RestAssured.baseURI="https://gorest.co.in";
		RequestSpecification request=RestAssured.given();
		request.header("Authorization","Bearer 7152d20d88c5a9aa6517cbe1eb745b4a94d95c9d864ae5775d1666b7c2ea11ae");
	Response response=	request.get("/public/v2/users");
	System.out.println(response.prettyPrint());
	System.out.println(response.getStatusCode());
	System.out.println(response.getHeader("Sever"));
		
	}
	   
	@Test	
  public void getUser_Non_BDD_withJqueryParams_Test() {
		
		RestAssured.baseURI="https://gorest.co.in";
		RequestSpecification request=RestAssured.given();
		request.header("Authorization","Bearer 7152d20d88c5a9aa6517cbe1eb745b4a94d95c9d864ae5775d1666b7c2ea11ae");
		request.queryParam("name", "Ekaaksh Chaturvedi");
		request.queryParam("gender", "female");
	Response response=	request.get("/public/v2/users");
	System.out.println(response.prettyPrint());
	System.out.println(response.getStatusCode());
	System.out.println(response.getHeader("Sever"));
		
	}
	
	@Test
public void getUser_Non_BDD_withJqueryParams_HashMapTest() {
		
		RestAssured.baseURI="https://gorest.co.in";
		RequestSpecification request=RestAssured.given();
		request.header("Authorization","Bearer 7152d20d88c5a9aa6517cbe1eb745b4a94d95c9d864ae5775d1666b7c2ea11ae");
		Map<String,String> params=new HashMap<String,String>();
		params.put("name", "Ekaaksh Chaturvedi");
		params.put("gender", "female");
		request.queryParams(params);
	Response response=	request.get("/public/v2/users");
	System.out.println(response.prettyPrint());
	System.out.println(response.getStatusCode());
	System.out.println(response.getHeader("Sever"));
	
	JsonPath js=response.jsonPath();
	js.getString(" _meta.sucess");
		
	}

}
